"""
sample_match_simulation_v2.py

HAND-WRITTEN SAMPLE of what the M2T transformation (SimulationMM -> Python)
should generate. It follows rule-definitions.md (the version in the repo root).

Source model (pretend):
    Match id=1
      home: Vaxjo FC   F433  depth=High  passingStyle=One_Touch
      away: Kalmar AIK F442  depth=Low   passingStyle=Longballs

Event formulas (all limited to 1-99 %):
    P(pass)     = 50 + (Passing_A  - Recovery_B)               / 2 + modifiers
    P(recovery) = 50 + (Recovery_B - Passing_A)                / 2 + modifiers
    P(goal)     = 50 + (Shooting_A - GoalkeeperDefending_B)    / 2 + modifiers

Modifier tables - used by the M2M step to compute the numbers in SimTeam:
    Formation        Attack (goal)   Midfield (advance)   Defence (recovery)
      F442                0                 0                    0
      F433               +3                -3                    0
      F352                0                +3                   -3

    Depth            Own recovery   Opponent pass   Opponent goal
      Low                 -5             +5              -3
      Medium               0              0               0
      High                +5             -5              +3

    Passing style    Pass success   Progression bonus
      One_Touch           -5              +0
      Longballs          -10              +1
      Target_Man          +5              +1   (only passes to the target player)

    Zone transitions after a successful pass (rest = stay in the same zone)
      DEFENCE  -> MIDFIELD  40 %
      MIDFIELD -> ATTACK    25 %   (+ formation Midfield %)
      MIDFIELD -> DEFENCE   15 %   progression reset
      ATTACK   -> MIDFIELD  25 %   progression -2

Not stated in the document, so this sample assumes:
  * Progression is counted from the zone the pass is played FROM, then the
    shot check, then the zone transition.
  * Target_Man: passes from MIDFIELD and ATTACK go to the target player.
  * Formation "Defence %" changes own recovery chance.
  * Failed pass + failed recovery -> attacking team keeps the ball,
    progression is kept.
  * After a recovery the ball is in the mirrored zone (my DEFENCE = your ATTACK).
  * After a shot the other team gets the ball (goal kick / kick-off).

Run:  python3 sample_match_simulation_v2.py
"""

import random
from collections import Counter
from enum import Enum


# =============================================================================
# STATIC PART - identical in every generated file (plain template text in M2T)
# =============================================================================

class Position(Enum):
    GOALKEEPER = 0
    DEFENDER = 1
    MIDFIELDER = 2
    ATTACKER = 3


class ZoneType(Enum):
    DEFENCE = 0
    MIDFIELD = 1
    ATTACK = 2


class EventType(Enum):
    PASS = "pass"
    RECOVERY = "recovery"
    SHOT = "shot"


# After a recovery the other team has the ball in the mirrored zone:
# winning it in my DEFENCE means the opponent lost it in their ATTACK.
MIRROR = {
    ZoneType.DEFENCE: ZoneType.ATTACK,
    ZoneType.MIDFIELD: ZoneType.MIDFIELD,
    ZoneType.ATTACK: ZoneType.DEFENCE,
}

SHOT_THRESHOLD = 5  # progression needed for a shooting opportunity


def clamp(p):
    """All probabilities are limited to 1-99 %."""
    return max(1, min(99, p))


class Zone:
    def __init__(self, type, progression):
        self.type = type
        self.progression = progression  # added for each successful pass from this zone


class ZoneTransition:
    """Chance that the ball moves from one zone to another after a successful pass."""

    def __init__(self, source, target, chance, progression_change=0, reset_progression=False):
        self.source = source
        self.target = target
        self.chance = chance
        self.progression_change = progression_change  # e.g. -2 for ATTACK -> MIDFIELD
        self.reset_progression = reset_progression    # e.g. True for MIDFIELD -> DEFENCE


class Agent:
    def __init__(self, id, position, passing, shooting, defending):
        self.id = id
        self.position = position
        self.passing = passing
        self.shooting = shooting
        self.defending = defending  # GoalkeeperDefending for the goalkeeper


class PassRule:
    """How a team's passing style works in one zone."""

    def __init__(self, zone, success_modifier, progression_bonus, to_target=False):
        self.zone = zone
        self.success_modifier = success_modifier    # added to P(pass)
        self.progression_bonus = progression_bonus  # added on a successful pass
        self.to_target = to_target                  # Target_Man: pass goes to the target player


class SimTeam:
    def __init__(self, name, agents, passing, recovery, shooting, goalkeeping,
                 goal_modifier, recovery_modifier, opponent_pass_modifier,
                 opponent_goal_modifier, pass_rules, transitions, target_player_id=None):
        self.name = name
        self.agents = agents
        # Team stats (computed by the M2M transformation)
        self.passing = passing          # average passing, outfield players
        self.recovery = recovery        # average defending, outfield players
        self.shooting = shooting        # average shooting, attackers
        self.goalkeeping = goalkeeping  # goalkeeper's defending
        # Tactic modifiers (formation + depth, computed by the M2M transformation)
        self.goal_modifier = goal_modifier                    # added to own P(goal)
        self.recovery_modifier = recovery_modifier            # added to own P(recovery)
        self.opponent_pass_modifier = opponent_pass_modifier  # added to opponent's P(pass)
        self.opponent_goal_modifier = opponent_goal_modifier  # added to opponent's P(goal)
        self.pass_rules = pass_rules
        self.transitions = transitions
        self.target_player_id = target_player_id  # only for Target_Man teams

        for zone in ZoneType:
            count = len([r for r in pass_rules if r.zone == zone])
            if count != 1:
                raise ValueError(f"{name}: needs exactly one pass rule for {zone.name}, has {count}")
            total = sum(t.chance for t in self.transitions_from(zone))
            if total > 100:
                raise ValueError(f"{name}: transitions from {zone.name} sum to {total} %, over 100")
        if any(r.to_target for r in pass_rules) and self.agent(target_player_id) is None:
            raise ValueError(f"{name}: Target_Man rules need a valid target_player_id")

    def agent(self, id):
        for a in self.agents:
            if a.id == id:
                return a
        return None

    def pass_rule(self, zone):
        for rule in self.pass_rules:
            if rule.zone == zone:
                return rule

    def transitions_from(self, zone):
        return [t for t in self.transitions if t.source == zone]

    def pick_shooter(self, rng):
        """Only used for the event log; P(goal) uses the team's shooting stat."""
        attackers = [a for a in self.agents if a.position == Position.ATTACKER]
        return rng.choices(attackers, weights=[a.shooting for a in attackers])[0]


# --- The three events from the document --------------------------------------

def pass_probability(attacking, defending, rule):
    return clamp(50 + (attacking.passing - defending.recovery) / 2
                 + rule.success_modifier + defending.opponent_pass_modifier)


def recovery_probability(attacking, defending):
    return clamp(50 + (defending.recovery - attacking.passing) / 2
                 + defending.recovery_modifier)


def goal_probability(attacking, defending):
    return clamp(50 + (attacking.shooting - defending.goalkeeping) / 2
                 + attacking.goal_modifier + defending.opponent_goal_modifier)


# --- Match statistics (rule 10) -----------------------------------------------

class TeamStats:
    def __init__(self):
        self.passes = 0
        self.passes_completed = 0
        self.recoveries = 0
        self.shots = 0
        self.goals = 0
        self.possession = 0  # ticks with the ball


class Event:
    def __init__(self, minute, team, type, success, description):
        self.minute = minute
        self.team = team
        self.type = type
        self.success = success
        self.description = description


class MatchResult:
    def __init__(self, home, away):
        self.home = home  # SimTeam
        self.away = away  # SimTeam
        # Keyed by the team object (not the name), so equal names can't collide
        self.stats = {home: TeamStats(), away: TeamStats()}
        self.events = []

    def score(self):
        return (f"{self.home.name} {self.stats[self.home].goals} - "
                f"{self.stats[self.away].goals} {self.away.name}")


class Simulation:
    def __init__(self, match_id, home, away, zones, ticks, seed=None):
        self.match_id = match_id
        self.home = home
        self.away = away
        self.zones = {z.type: z for z in zones}
        self.ticks = ticks  # number of pass attempts in 90 minutes
        self.rng = random.Random(seed)

    def happens(self, probability):
        return self.rng.random() * 100 < probability

    def pick_transition(self, team, zone):
        """Returns the transition that happens, or None if the ball stays in the zone."""
        roll = self.rng.random() * 100
        for t in team.transitions_from(zone):
            if roll < t.chance:
                return t
            roll -= t.chance
        return None

    def run(self):
        result = MatchResult(self.home, self.away)
        attacking, defending = self.home, self.away
        zone = ZoneType.MIDFIELD  # kick-off
        progression = 0

        for tick in range(self.ticks):
            minute = tick * 90 // self.ticks + 1
            att_stats = result.stats[attacking]
            def_stats = result.stats[defending]
            att_stats.possession += 1

            # ---- Event 1: passing ----
            rule = attacking.pass_rule(zone)
            receiver = f" to target player #{attacking.target_player_id}" if rule.to_target else ""
            att_stats.passes += 1
            if self.happens(pass_probability(attacking, defending, rule)):
                att_stats.passes_completed += 1
                progression += self.zones[zone].progression + rule.progression_bonus
                result.events.append(Event(minute, attacking.name, EventType.PASS, True,
                                           f"pass in {zone.name}{receiver}, progression {progression}"))

                # ---- Rule 9: enough progression -> shooting opportunity ----
                if progression >= SHOT_THRESHOLD:
                    # ---- Event 3: shooting ----
                    shooter = attacking.pick_shooter(self.rng)
                    att_stats.shots += 1
                    if self.happens(goal_probability(attacking, defending)):
                        att_stats.goals += 1
                        result.events.append(Event(minute, attacking.name, EventType.SHOT, True,
                                                   f"GOAL by player #{shooter.id}"))
                        zone = ZoneType.MIDFIELD  # conceding team kicks off
                    else:
                        result.events.append(Event(minute, attacking.name, EventType.SHOT, False,
                                                   f"shot by player #{shooter.id}, saved/missed"))
                        zone = ZoneType.DEFENCE   # goal kick
                    attacking, defending = defending, attacking
                    progression = 0
                    continue

                # ---- Zone transition after the pass ----
                transition = self.pick_transition(attacking, zone)
                if transition is not None:
                    zone = transition.target
                    if transition.reset_progression:
                        progression = 0
                    progression = max(0, progression + transition.progression_change)
            else:
                result.events.append(Event(minute, attacking.name, EventType.PASS, False,
                                           f"pass in {zone.name}{receiver} failed"))
                # ---- Rule 4 + Event 2: failed pass -> recovery attempt ----
                if self.happens(recovery_probability(attacking, defending)):
                    def_stats.recoveries += 1
                    result.events.append(Event(minute, defending.name, EventType.RECOVERY, True,
                                               f"ball recovered in {MIRROR[zone].name}"))
                    attacking, defending = defending, attacking
                    zone = MIRROR[zone]
                    progression = 0
                # else: loose ball goes back to the attacking team, nothing changes

        return result


def run_many(make_simulation, n):
    """Monte Carlo: play the same match n times and summarise."""
    home_wins = draws = away_wins = 0
    scores = Counter()
    totals = {"goals": 0, "shots": 0, "passes": 0, "completed": 0, "home_poss": 0, "ticks": 0}

    for i in range(n):
        sim = make_simulation(seed=i)
        r = sim.run()
        h, a = r.stats[r.home], r.stats[r.away]
        scores[(h.goals, a.goals)] += 1
        if h.goals > a.goals:
            home_wins += 1
        elif h.goals == a.goals:
            draws += 1
        else:
            away_wins += 1
        totals["goals"] += h.goals + a.goals
        totals["shots"] += h.shots + a.shots
        totals["passes"] += h.passes + a.passes
        totals["completed"] += h.passes_completed + a.passes_completed
        totals["home_poss"] += h.possession
        totals["ticks"] += sim.ticks

    print(f"\n--- {n} simulations ---")
    print(f"Home win {home_wins / n:6.1%}   Draw {draws / n:6.1%}   Away win {away_wins / n:6.1%}")
    print(f"Average goals per match: {totals['goals'] / n:.2f}")
    print(f"Average shots per match: {totals['shots'] / n:.2f}")
    print(f"Pass completion: {totals['completed'] / totals['passes']:.1%}   "
          f"Home possession: {totals['home_poss'] / totals['ticks']:.1%}")
    print("Most common scores:",
          ", ".join(f"{h}-{a} ({c / n:.1%})" for (h, a), c in scores.most_common(5)))
    most_goals = max(sum(score) for score in scores)
    highest_scoring = [f"{h}-{a}" for (h, a) in scores if h + a == most_goals]
    biggest_margin = max(abs(h - a) for h, a in scores)
    widest_wins = [f"{h}-{a}" for (h, a) in scores if abs(h - a) == biggest_margin]
    print(f"Most goals in a match: {most_goals} ({', '.join(highest_scoring)})")
    print(f"Biggest winning margin: {biggest_margin} goals ({', '.join(widest_wins)})")


# =============================================================================
# GENERATED PART - this is what the M2T template fills in from the model
# =============================================================================

MATCH_ID = 1
TICKS = 90

ZONES = [
    Zone(ZoneType.DEFENCE,  progression=0),
    Zone(ZoneType.MIDFIELD, progression=1),
    Zone(ZoneType.ATTACK,   progression=2),
]

# --- SimTeam: Vaxjo FC (F433, depth High, One_Touch) -------------------------
HOME = SimTeam(
    name="Vaxjo FC",
    agents=[
        Agent(id=1,  position=Position.GOALKEEPER, passing=55, shooting=20, defending=78),
        Agent(id=2,  position=Position.DEFENDER,   passing=68, shooting=40, defending=74),
        Agent(id=3,  position=Position.DEFENDER,   passing=62, shooting=35, defending=80),
        Agent(id=4,  position=Position.DEFENDER,   passing=60, shooting=38, defending=79),
        Agent(id=5,  position=Position.DEFENDER,   passing=70, shooting=45, defending=72),
        Agent(id=6,  position=Position.MIDFIELDER, passing=82, shooting=60, defending=65),
        Agent(id=8,  position=Position.MIDFIELDER, passing=85, shooting=68, defending=58),
        Agent(id=10, position=Position.MIDFIELDER, passing=84, shooting=74, defending=45),
        Agent(id=7,  position=Position.ATTACKER,   passing=74, shooting=78, defending=30),
        Agent(id=9,  position=Position.ATTACKER,   passing=65, shooting=84, defending=28),
        Agent(id=11, position=Position.ATTACKER,   passing=76, shooting=77, defending=32),
    ],
    passing=72.6,       # avg passing of 10 outfield players
    recovery=56.3,      # avg defending of 10 outfield players
    shooting=79.7,      # avg shooting of 3 attackers
    goalkeeping=78,     # goalkeeper #1 defending
    goal_modifier=3,             # F433 Attack +3
    recovery_modifier=5,         # depth High +5, F433 Defence 0
    opponent_pass_modifier=-5,   # depth High
    opponent_goal_modifier=3,    # depth High
    pass_rules=[
        # One_Touch: -5 success, +0 progression
        PassRule(ZoneType.DEFENCE,  success_modifier=-5, progression_bonus=0),
        PassRule(ZoneType.MIDFIELD, success_modifier=-5, progression_bonus=0),
        PassRule(ZoneType.ATTACK,   success_modifier=-5, progression_bonus=0),
    ],
    transitions=[
        ZoneTransition(ZoneType.DEFENCE,  ZoneType.MIDFIELD, chance=40),
        ZoneTransition(ZoneType.MIDFIELD, ZoneType.ATTACK,   chance=22),  # 25, F433 Midfield -3
        ZoneTransition(ZoneType.MIDFIELD, ZoneType.DEFENCE,  chance=15, reset_progression=True),
        ZoneTransition(ZoneType.ATTACK,   ZoneType.MIDFIELD, chance=25, progression_change=-2),
    ],
)

# --- SimTeam: Kalmar AIK (F442, depth Low, Longballs) ------------------------
AWAY = SimTeam(
    name="Kalmar AIK",
    agents=[
        Agent(id=1,  position=Position.GOALKEEPER, passing=50, shooting=18, defending=75),
        Agent(id=2,  position=Position.DEFENDER,   passing=60, shooting=35, defending=76),
        Agent(id=4,  position=Position.DEFENDER,   passing=55, shooting=30, defending=82),
        Agent(id=5,  position=Position.DEFENDER,   passing=54, shooting=32, defending=81),
        Agent(id=3,  position=Position.DEFENDER,   passing=62, shooting=36, defending=74),
        Agent(id=7,  position=Position.MIDFIELDER, passing=70, shooting=62, defending=55),
        Agent(id=6,  position=Position.MIDFIELDER, passing=72, shooting=55, defending=70),
        Agent(id=8,  position=Position.MIDFIELDER, passing=74, shooting=58, defending=66),
        Agent(id=11, position=Position.MIDFIELDER, passing=69, shooting=64, defending=50),
        Agent(id=9,  position=Position.ATTACKER,   passing=58, shooting=80, defending=30),
        Agent(id=10, position=Position.ATTACKER,   passing=64, shooting=75, defending=34),
    ],
    passing=63.8,       # avg passing of 10 outfield players
    recovery=61.8,      # avg defending of 10 outfield players
    shooting=77.5,      # avg shooting of 2 attackers
    goalkeeping=75,     # goalkeeper #1 defending
    goal_modifier=0,             # F442 Attack 0
    recovery_modifier=-5,        # depth Low -5, F442 Defence 0
    opponent_pass_modifier=5,    # depth Low
    opponent_goal_modifier=-3,   # depth Low
    pass_rules=[
        # Longballs: -10 success, +1 progression on every successful pass
        PassRule(ZoneType.DEFENCE,  success_modifier=-10, progression_bonus=1),
        PassRule(ZoneType.MIDFIELD, success_modifier=-10, progression_bonus=1),
        PassRule(ZoneType.ATTACK,   success_modifier=-10, progression_bonus=1),
    ],
    transitions=[
        ZoneTransition(ZoneType.DEFENCE,  ZoneType.MIDFIELD, chance=40),
        ZoneTransition(ZoneType.MIDFIELD, ZoneType.ATTACK,   chance=25),  # F442 Midfield 0
        ZoneTransition(ZoneType.MIDFIELD, ZoneType.DEFENCE,  chance=15, reset_progression=True),
        ZoneTransition(ZoneType.ATTACK,   ZoneType.MIDFIELD, chance=25, progression_change=-2),
    ],
)

# For comparison, a Target_Man team with player #9 as target would get:
#   target_player_id=9,
#   pass_rules=[
#       PassRule(ZoneType.DEFENCE,  success_modifier=0, progression_bonus=0),
#       PassRule(ZoneType.MIDFIELD, success_modifier=5, progression_bonus=1, to_target=True),
#       PassRule(ZoneType.ATTACK,   success_modifier=5, progression_bonus=1, to_target=True),
#   ]


def make_simulation(seed=None):
    return Simulation(MATCH_ID, HOME, AWAY, ZONES, ticks=TICKS, seed=seed)


if __name__ == "__main__":
    single = make_simulation(seed=42).run()
    print(f"Match {MATCH_ID}: {single.home.name} vs {single.away.name}\n")
    for e in single.events:
        if e.type == EventType.SHOT:
            print(f"{e.minute:>3}'  {e.team:<12} {e.description}")

    print(f"\nFull time: {single.score()}\n")
    print(f"{'':<20}{single.home.name:>12}{single.away.name:>12}")
    h, a = single.stats[single.home], single.stats[single.away]
    total_poss = h.possession + a.possession
    print(f"{'Possession':<20}{h.possession / total_poss:>12.0%}{a.possession / total_poss:>12.0%}")
    print(f"{'Passes (completed)':<20}{f'{h.passes} ({h.passes_completed})':>12}"
          f"{f'{a.passes} ({a.passes_completed})':>12}")
    print(f"{'Recoveries':<20}{h.recoveries:>12}{a.recoveries:>12}")
    print(f"{'Shots':<20}{h.shots:>12}{a.shots:>12}")
    print(f"{'Total events':<20}{len(single.events):>24}")

    run_many(make_simulation, 1000)
