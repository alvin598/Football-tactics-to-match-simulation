"""
sample_match_simulation.py

HAND-WRITTEN SAMPLE of what the M2T transformation (SimulationMM -> Python)
should generate. Every value in the "GENERATED PART" below would come from a
SimulationMM instance, which in turn comes from the M2M transformation
(FootballMM -> SimulationMM).

Source model (pretend):
    Match id=1
      home: Vaxjo FC   formation=F433  depth=4  passingStyle=One_Touch
      away: Kalmar AIK formation=F442  depth=2  passingStyle=Longballs

Run:  python3 sample_match_simulation.py
"""

import random
from collections import Counter
from dataclasses import dataclass, field
from enum import Enum


# =============================================================================
# STATIC PART - identical in every generated file (plain template text in M2T)
# =============================================================================

class ZoneType(Enum):
    DEFENCE = 0
    MIDFIELD = 1
    ATTACK = 2


class Outcome(Enum):
    ADVANCE = "advance"        # ball moves one zone forward
    LONG_BALL = "long ball"    # DEFENCE -> ATTACK, skipping midfield
    SHOOT = "shot"             # attempt on goal
    TURNOVER = "turnover"      # opponent wins the ball


# Where the opponent gets the ball after a turnover in a zone.
# Losing it in your ATTACK zone means they have it in their DEFENCE zone.
MIRROR = {
    ZoneType.DEFENCE: ZoneType.ATTACK,
    ZoneType.MIDFIELD: ZoneType.MIDFIELD,
    ZoneType.ATTACK: ZoneType.DEFENCE,
}

NEXT_ZONE = {
    ZoneType.DEFENCE: ZoneType.MIDFIELD,
    ZoneType.MIDFIELD: ZoneType.ATTACK,
}


@dataclass
class Agent:
    id: int
    slot: int
    zone: ZoneType
    passing: int
    shooting: int
    defending: int


@dataclass
class Rule:
    zone: ZoneType
    outcome: Outcome
    probability: int  # percent, like Rule.probability (EInt) in SimulationMM


@dataclass
class SimTeam:
    name: str
    agents: list
    rules: list
    shot_conversion: int  # percent chance that a shot becomes a goal

    def __post_init__(self):
        # Sanity check: the outcomes of each zone must add up to 100 %.
        for zone in ZoneType:
            total = sum(r.probability for r in self.rules_in(zone))
            if total != 100:
                raise ValueError(f"{self.name}: rules in {zone.name} sum to {total}, not 100")

    def rules_in(self, zone):
        return [r for r in self.rules if r.zone == zone]

    def pick_outcome(self, zone, rng):
        rules = self.rules_in(zone)
        return rng.choices(rules, weights=[r.probability for r in rules])[0].outcome

    def pick_shooter(self, rng):
        # Attackers shoot more often than midfielders; better shooters more often.
        weights = {ZoneType.ATTACK: 3, ZoneType.MIDFIELD: 1, ZoneType.DEFENCE: 0}
        candidates = [a for a in self.agents if weights[a.zone] > 0]
        return rng.choices(candidates, weights=[a.shooting * weights[a.zone] for a in candidates])[0]


@dataclass
class Event:
    minute: int
    team: str
    description: str


@dataclass
class MatchResult:
    home: str
    away: str
    home_goals: int = 0
    away_goals: int = 0
    home_shots: int = 0
    away_shots: int = 0
    events: list = field(default_factory=list)

    def score(self):
        return f"{self.home} {self.home_goals} - {self.away_goals} {self.away}"


class Simulation:
    def __init__(self, match_id, home, away, ticks, seed=None):
        self.match_id = match_id
        self.home = home
        self.away = away
        self.ticks = ticks          # number of "ball actions" in 90 minutes
        self.rng = random.Random(seed)

    def run(self):
        result = MatchResult(self.home.name, self.away.name)
        attacking, defending = self.home, self.away
        zone = ZoneType.MIDFIELD  # kick-off

        for tick in range(self.ticks):
            minute = tick * 90 // self.ticks + 1
            outcome = attacking.pick_outcome(zone, self.rng)

            if outcome == Outcome.ADVANCE:
                zone = NEXT_ZONE[zone]

            elif outcome == Outcome.LONG_BALL:
                zone = ZoneType.ATTACK

            elif outcome == Outcome.TURNOVER:
                attacking, defending = defending, attacking
                zone = MIRROR[zone]

            elif outcome == Outcome.SHOOT:
                shooter = attacking.pick_shooter(self.rng)
                is_home = attacking is self.home
                if is_home:
                    result.home_shots += 1
                else:
                    result.away_shots += 1

                if self.rng.randint(1, 100) <= attacking.shot_conversion:
                    if is_home:
                        result.home_goals += 1
                    else:
                        result.away_goals += 1
                    result.events.append(Event(minute, attacking.name, f"GOAL by player #{shooter.id}"))
                    zone = ZoneType.MIDFIELD  # conceding team kicks off
                else:
                    result.events.append(Event(minute, attacking.name, f"shot by player #{shooter.id}, missed"))
                    zone = ZoneType.DEFENCE   # goal kick
                attacking, defending = defending, attacking

        return result


def run_many(make_simulation, n):
    """Monte Carlo: play the same match n times and summarise."""
    wins = draws = losses = goals = 0
    scores = Counter()
    for i in range(n):
        r = make_simulation(seed=i).run()
        goals += r.home_goals + r.away_goals
        scores[(r.home_goals, r.away_goals)] += 1
        if r.home_goals > r.away_goals:
            wins += 1
        elif r.home_goals == r.away_goals:
            draws += 1
        else:
            losses += 1

    print(f"\n--- {n} simulations ---")
    print(f"Home win {wins / n:6.1%}   Draw {draws / n:6.1%}   Away win {losses / n:6.1%}")
    print(f"Average goals per match: {goals / n:.2f}")
    print("Most common scores:", ", ".join(f"{h}-{a} ({c / n:.1%})" for (h, a), c in scores.most_common(5)))


# =============================================================================
# GENERATED PART - this is what the M2T template fills in from the model
# =============================================================================

MATCH_ID = 1
TICKS = 230

# --- SimTeam: Vaxjo FC (F433, depth 4, One_Touch) ----------------------------
HOME = SimTeam(
    name="Vaxjo FC",
    agents=[
        Agent(id=1,  slot=1,  zone=ZoneType.DEFENCE,  passing=55, shooting=20, defending=78),  # GK
        Agent(id=2,  slot=2,  zone=ZoneType.DEFENCE,  passing=68, shooting=40, defending=74),
        Agent(id=3,  slot=3,  zone=ZoneType.DEFENCE,  passing=62, shooting=35, defending=80),
        Agent(id=4,  slot=4,  zone=ZoneType.DEFENCE,  passing=60, shooting=38, defending=79),
        Agent(id=5,  slot=5,  zone=ZoneType.DEFENCE,  passing=70, shooting=45, defending=72),
        Agent(id=6,  slot=6,  zone=ZoneType.MIDFIELD, passing=82, shooting=60, defending=65),
        Agent(id=8,  slot=7,  zone=ZoneType.MIDFIELD, passing=85, shooting=68, defending=58),
        Agent(id=10, slot=8,  zone=ZoneType.MIDFIELD, passing=84, shooting=74, defending=45),
        Agent(id=7,  slot=9,  zone=ZoneType.ATTACK,   passing=74, shooting=78, defending=30),
        Agent(id=9,  slot=10, zone=ZoneType.ATTACK,   passing=65, shooting=84, defending=28),
        Agent(id=11, slot=11, zone=ZoneType.ATTACK,   passing=76, shooting=77, defending=32),
    ],
    rules=[
        # One_Touch + good midfield passing -> high chance to advance
        Rule(ZoneType.DEFENCE,  Outcome.ADVANCE,  62),
        Rule(ZoneType.DEFENCE,  Outcome.TURNOVER, 38),
        Rule(ZoneType.MIDFIELD, Outcome.ADVANCE,  48),
        Rule(ZoneType.MIDFIELD, Outcome.TURNOVER, 52),
        # F433 -> three attackers, more shots
        Rule(ZoneType.ATTACK,   Outcome.SHOOT,    34),
        Rule(ZoneType.ATTACK,   Outcome.TURNOVER, 66),
    ],
    shot_conversion=12,
)

# --- SimTeam: Kalmar AIK (F442, depth 2, Longballs) --------------------------
AWAY = SimTeam(
    name="Kalmar AIK",
    agents=[
        Agent(id=1,  slot=1,  zone=ZoneType.DEFENCE,  passing=50, shooting=18, defending=75),  # GK
        Agent(id=2,  slot=2,  zone=ZoneType.DEFENCE,  passing=60, shooting=35, defending=76),
        Agent(id=4,  slot=3,  zone=ZoneType.DEFENCE,  passing=55, shooting=30, defending=82),
        Agent(id=5,  slot=4,  zone=ZoneType.DEFENCE,  passing=54, shooting=32, defending=81),
        Agent(id=3,  slot=5,  zone=ZoneType.DEFENCE,  passing=62, shooting=36, defending=74),
        Agent(id=7,  slot=6,  zone=ZoneType.MIDFIELD, passing=70, shooting=62, defending=55),
        Agent(id=6,  slot=7,  zone=ZoneType.MIDFIELD, passing=72, shooting=55, defending=70),
        Agent(id=8,  slot=8,  zone=ZoneType.MIDFIELD, passing=74, shooting=58, defending=66),
        Agent(id=11, slot=9,  zone=ZoneType.MIDFIELD, passing=69, shooting=64, defending=50),
        Agent(id=9,  slot=10, zone=ZoneType.ATTACK,   passing=58, shooting=80, defending=30),
        Agent(id=10, slot=11, zone=ZoneType.ATTACK,   passing=64, shooting=75, defending=34),
    ],
    rules=[
        # Longballs -> skip midfield sometimes, but lose the ball more often
        Rule(ZoneType.DEFENCE,  Outcome.ADVANCE,   35),
        Rule(ZoneType.DEFENCE,  Outcome.LONG_BALL, 22),
        Rule(ZoneType.DEFENCE,  Outcome.TURNOVER,  43),
        # F442 -> four midfielders, decent midfield control
        Rule(ZoneType.MIDFIELD, Outcome.ADVANCE,   42),
        Rule(ZoneType.MIDFIELD, Outcome.TURNOVER,  58),
        # Only two attackers -> fewer shots
        Rule(ZoneType.ATTACK,   Outcome.SHOOT,     28),
        Rule(ZoneType.ATTACK,   Outcome.TURNOVER,  72),
    ],
    shot_conversion=11,
)


def make_simulation(seed=None):
    return Simulation(MATCH_ID, HOME, AWAY, ticks=TICKS, seed=seed)


if __name__ == "__main__":
    single = make_simulation(seed=42).run()
    print(f"Match {MATCH_ID}: {single.home} vs {single.away}\n")
    for e in single.events:
        print(f"{e.minute:>3}'  {e.team:<12} {e.description}")
    print(f"\nFull time: {single.score()}")
    print(f"Shots: {single.home_shots} - {single.away_shots}")

    run_many(make_simulation, 1000)
