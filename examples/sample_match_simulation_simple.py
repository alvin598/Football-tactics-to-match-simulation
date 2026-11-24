
import random
from collections import Counter
from enum import Enum


class Zone(Enum):
    DEFENCE = 0
    MIDFIELD = 1
    ATTACK = 2


class Formation(Enum):
    F442 = 0
    F433 = 1
    F352 = 2


class Depth(Enum):
    LOW = 0
    MEDIUM = 1
    HIGH = 2


class PassingStyle(Enum):
    ONE_TOUCH = 0
    LONG_BALLS = 1
    TARGET_MAN = 2


# =============================================================================
# RULES - from rule-definitions.md
# =============================================================================

SHOT_THRESHOLD = 6 # progression needed for a shooting opportunity
HOME_ADVANTAGE = 2 # +2 % to passes, shots and ball recovery for the home team

ZONE_PROGRESSION = {Zone.DEFENCE: 0, Zone.MIDFIELD: 1, Zone.ATTACK: 2}

FORMATION_MODIFIERS = {
    # attack = goal chance, midfield = advance to attack, defence = recovery
    Formation.F442: {"attack": 0, "midfield": 0,  "defence": 0},
    Formation.F433: {"attack": 3, "midfield": -3, "defence": 0},
    Formation.F352: {"attack": 0, "midfield": 3,  "defence": -3},
}

DEPTH_MODIFIERS = {
    Depth.LOW:    {"own_recovery": -5, "opponent_pass": 5,  "opponent_goal": -3},
    Depth.MEDIUM: {"own_recovery": 0,  "opponent_pass": 0,  "opponent_goal": 0},
    Depth.HIGH:   {"own_recovery": 5,  "opponent_pass": -5, "opponent_goal": 3},
}

STYLE_MODIFIERS = {
    PassingStyle.ONE_TOUCH:  {"pass": 0,   "progression": 0},
    PassingStyle.LONG_BALLS: {"pass": -10, "progression": 2},
    PassingStyle.TARGET_MAN: {"pass": 5,   "progression": 1}, # only passes to the target player
}

NORMAL_PASS = {"pass": 0, "progression": 0}

# After a recovery, teamA DEFENCE is the opponent's ATTACK + other way round.
MIRROR = {Zone.DEFENCE: Zone.ATTACK, Zone.MIDFIELD: Zone.MIDFIELD, Zone.ATTACK: Zone.DEFENCE}


def clamp(p):
    # All probabilities are limited to 1-99 %
    return max(1, min(99, p))


def style_for_pass(team, zone):
    # Passing style modifiers for one pass. Target man only counts for passes to the target player
    if team.style == PassingStyle.TARGET_MAN and zone == Zone.DEFENCE:
        return NORMAL_PASS
    return STYLE_MODIFIERS[team.style]


# =============================================================================
# SIMULATION
# =============================================================================

class Team:
    def __init__(self, name, passing, recovery, shooting, goalkeeping, formation, depth, style,
                 home_team=False):
        self.name = name
        self.home_team = home_team      # True -> gets HOME_ADVANTAGE
        self.passing = passing          # average passing of outfield players
        self.recovery = recovery        # average defending of outfield players
        self.shooting = shooting        # average shooting of attackers
        self.goalkeeping = goalkeeping  # goalkeeper's defending
        self.formation = formation
        self.depth = depth
        self.style = style


class MatchSimulation:
    def __init__(self, home, away, ticks, seed=None):
        self.home = home
        self.away = away
        self.ticks = ticks # number of pass attempts in a match
        self.rng = random.Random(seed)
        if home.home_team and away.home_team:
            raise ValueError("Only one team can have home_team=True")

    def home_bonus(self, team):
        return HOME_ADVANTAGE if team.home_team else 0

    def happens(self, probability):
        return self.rng.random() * 100 < clamp(probability)

    # Event 1: passing
    def pass_chance(self, attacking, defending, style):
        return (50 + (attacking.passing - defending.recovery) / 2
                + style["pass"]
                + DEPTH_MODIFIERS[defending.depth]["opponent_pass"]
                + self.home_bonus(attacking))

    # Event 2: ball recovery
    def recovery_chance(self, attacking, defending):
        return (50 + (defending.recovery - attacking.passing) / 2
                + DEPTH_MODIFIERS[defending.depth]["own_recovery"]
                + FORMATION_MODIFIERS[defending.formation]["defence"]
                + self.home_bonus(defending))

    # Event 3: shooting
    def goal_chance(self, attacking, defending):
        return (50 + (attacking.shooting - defending.goalkeeping) / 2
                + FORMATION_MODIFIERS[attacking.formation]["attack"]
                + DEPTH_MODIFIERS[defending.depth]["opponent_goal"]
                + self.home_bonus(attacking))

    # Zone transition after a successful pass
    def move_ball(self, team, zone, progression):
        # Returns the new (zone, progression)
        roll = self.rng.random() * 100

        if zone == Zone.DEFENCE:
            if roll < 40:
                return Zone.MIDFIELD, progression

        elif zone == Zone.MIDFIELD:
            to_attack = 25 + FORMATION_MODIFIERS[team.formation]["midfield"]
            if roll < to_attack:
                return Zone.ATTACK, progression
            if roll < to_attack + 15:
                return Zone.DEFENCE, 0 # backwards: reset progression

        elif zone == Zone.ATTACK:
            if roll < 25:
                return Zone.MIDFIELD, max(0, progression - 2)  # backwards: -2

        return zone, progression  # ball stays in the same zone

    def run(self):
        stats = {}
        for team in (self.home, self.away):
            stats[team] = {"passes": 0, "completed": 0, "recoveries": 0, "shots": 0, "goals": 0, "possession": 0}
        events = []  # (minute, kind of event, text)

        attacking, defending = self.home, self.away
        zone = Zone.MIDFIELD # kick-off
        progression = 0

        for tick in range(self.ticks):
            minute = tick * 90 // self.ticks + 1
            stats[attacking]["possession"] += 1
            stats[attacking]["passes"] += 1
            style = style_for_pass(attacking, zone)

            if self.happens(self.pass_chance(attacking, defending, style)):
                # Successful pass: progression grows
                stats[attacking]["completed"] += 1
                progression += ZONE_PROGRESSION[zone] + style["progression"]
                events.append((minute, "pass", f"{attacking.name} pass in {zone.name}"))

                if progression >= SHOT_THRESHOLD:
                    # Shooting opportunity
                    stats[attacking]["shots"] += 1
                    if self.happens(self.goal_chance(attacking, defending)):
                        stats[attacking]["goals"] += 1
                        events.append((minute, "shot", f"GOAL {attacking.name}"))
                        zone = Zone.MIDFIELD   # kick-off for the other team
                    else:
                        events.append((minute, "shot", f"{attacking.name} shot missed"))
                        zone = Zone.DEFENCE    # goal kick for the other team
                    attacking, defending = defending, attacking
                    progression = 0
                else:
                    zone, progression = self.move_ball(attacking, zone, progression)

            else:
                # Failed pass: the defending team tries to recover the ball
                events.append((minute, "pass", f"{attacking.name} pass failed"))
                if self.happens(self.recovery_chance(attacking, defending)):
                    stats[defending]["recoveries"] += 1
                    events.append((minute, "recovery", f"{defending.name} recovers the ball"))
                    attacking, defending = defending, attacking
                    zone = MIRROR[zone]
                    progression = 0

        return stats, events


def run_many(home, away, ticks, n):
    # Play the same match n times and print a summary
    home_wins = 0
    draws = 0
    away_wins = 0
    goals = shots = 0
    scores = Counter()

    for i in range(n):
        stats, _ = MatchSimulation(home, away, ticks, seed=i).run()
        h, a = stats[home]["goals"], stats[away]["goals"]
        scores[(h, a)] += 1
        goals += h + a
        shots += stats[home]["shots"] + stats[away]["shots"]
        if h > a:
            home_wins += 1
        elif h == a:
            draws += 1
        else:
            away_wins += 1

    print(f"\n--- {n} simulations ---")
    print(f"Home win {home_wins / n:6.1%}   Draw {draws / n:6.1%}   Away win {away_wins / n:6.1%}")
    print(f"Average goals per match: {goals / n:.2f}")
    print(f"Average shots per match: {shots / n:.2f}")
    print("Most common scores:",
          ", ".join(f"{h}-{a} ({c / n:.1%})" for (h, a), c in scores.most_common(5)))
    most_goals = max(sum(score) for score in scores)
    highest_scoring = [f"{h}-{a}" for (h, a) in scores if h + a == most_goals]
    biggest_margin = max(abs(h - a) for h, a in scores)
    widest_wins = [f"{h}-{a}" for (h, a) in scores if abs(h - a) == biggest_margin]
    print(f"Most goals in a match: {most_goals} ({', '.join(highest_scoring)})")
    print(f"Biggest winning margin: {biggest_margin} goals ({', '.join(widest_wins)})")


# =============================================================================
# GENERATED PART - written by the M2T transformation from the model
# (the averages are computed from the players by the M2M transformation)
# =============================================================================

TICKS = 80

HOME = Team("Vaxjo FC", home_team = True,
            passing=72.6, recovery=56.3, shooting=79.7, goalkeeping=78,
            formation=Formation.F433, depth=Depth.HIGH, style=PassingStyle.ONE_TOUCH)

AWAY = Team("Kalmar AIK", home_team = False,
            passing=63.8, recovery=61.8, shooting=77.5, goalkeeping=75,
            formation=Formation.F442, depth=Depth.LOW, style=PassingStyle.LONG_BALLS)


if __name__ == "__main__":
    stats, events = MatchSimulation(HOME, AWAY, TICKS, seed=42).run()

    print(f"{HOME.name} vs {AWAY.name}\n")
    for minute, kind, text in events:
        if kind == "shot":
            print(f"{minute:>3}'  {text}")

    h, a = stats[HOME], stats[AWAY]
    print(f"\nFull time: {HOME.name} {h['goals']} - {a['goals']} {AWAY.name}\n")
    print(f"{'':<20}{HOME.name:>12}{AWAY.name:>12}")
    total = h["possession"] + a["possession"]
    print(f"{'Possession':<20}{h['possession'] / total:>12.0%}{a['possession'] / total:>12.0%}")
    home_passes = f"{h['passes']} ({h['completed']})"
    away_passes = f"{a['passes']} ({a['completed']})"
    print(f"{'Passes (completed)':<20}{home_passes:>12}{away_passes:>12}")
    print(f"{'Recoveries':<20}{h['recoveries']:>12}{a['recoveries']:>12}")
    print(f"{'Shots':<20}{h['shots']:>12}{a['shots']:>12}")
    print(f"{'Total events':<20}{len(events):>24}")

    run_many(HOME, AWAY, TICKS, 1000)
