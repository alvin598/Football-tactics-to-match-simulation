# Rule Definitions – Football Simulation Project

## Events & Rules

### Events (1–3)

1. Passing success calculation
2. Defensive recovery calculation
3. Shooting success calculation

### Rules (4–10)

4. Failed passes trigger recovery attempts
5. Passing style affects passing and attacking progression
6. Defensive depth affects opponent shooting
7. Depth/pressing affects passing and recovery
8. Goalkeeper defending affects goal probability
9. Successful passes can create shooting opportunities
10. Match statistics are updated after every event

---

## Players

Players have four attributes:

1. **Position** (Goalkeeper, Defender, Midfielder, Attacker)
2. **Passing**
3. **Shooting**
4. **Defending / GoalkeeperDefending**

Each attribute has an individual ability rating of **1–99** (base individual success % before event/averages computations).

### Team stats

| Stat | Calculation |
|---|---|
| Passing | Average passing of all outfield players |
| Recovery | Average defending of all outfield players |
| Shooting | Average shooting of attacking players |
| Goalkeeping | Goalkeeper's individual defending attribute |

---

## Team Tactics

Team tactics have three attributes:

1. **Formation** (4-4-2, 4-3-3, 3-5-2, …)
2. **Depth** (defensive line positioning – how far up the pitch)
3. **Passing style** (long balls, one-touch, target man)

| Passing style | Success | Attacking progression |
|---|---|---|
| One-touch | Normal | Normal |
| Long balls | Lower | More |
| Target man | Medium | Slightly more (only to target player) |

---

## Main Events

### Passing

- **Success** → team keeps the ball
- **Fail** → defending team gets an opportunity to recover the ball (ball recovery event)

```
P(pass) = 50 + (Passing_A − Defending_B) / 2 + Modifiers
```

### Defending / Ball Recovery

```
P(recovery) = 50 + (Defending_B − Passing_A) / 2 + Modifiers
```

### Shooting

```
P(goal) = 50 + (Shooting_A − GoalkeeperDefending_B) / 2 + Modifiers
```

**Example:** `P(pass) = 50 + (80 − 85) / 2 = 47.5%`

> All probabilities are clamped to **1–99%**.

---

## Zones

- Defence
- Midfield
- Attack

### Zone transition chance (after each successful pass)

| From | To | Chance |
|---|---|---|
| Defence | Midfield | 40% |
| Midfield | Attack | 25% |
| Midfield | Defence | 15% |
| Attack | Midfield | 25% |

---

## Attacking Progression

Each successful pass contributes to the team's attacking progression depending on the zone:

| Zone | Progression |
|---|---|
| Defence | +0 |
| Midfield | +1 |
| Attack | +2 |

Passing backwards between zones lowers progression:

| Transition | Effect |
|---|---|
| Midfield → Defence | Reset progression |
| Attack → Midfield | −2 |

- A **shooting opportunity** is created when progression reaches **6**.
- Progression is **reset** after a shot is taken or if possession is lost.

### Bonus progression by pass type

| Event | Bonus |
|---|---|
| Successful normal pass | +0 |
| Successful one-touch pass | +0 |
| Successful long ball | +2 |
| Successful pass to target man | +1 |

---

## Modifiers

### Formations

| Formation | Attack | Midfield | Defence |
|---|---|---|---|
| 4-4-2 | 0% | 0% | 0% |
| 4-3-3 | +3% | −3% | 0% |
| 3-5-2 | 0% | +3% | −3% |

- **Attack %** affects goal chance
- **Midfield %** affects chance to advance to the attack zone
- **Defence %** affects defence / ball recovery chance

### Depth / Pressing

Modifier to opponent's shooting probability (and own recovery / opponent passing):

| Depth | Own recovery | Opponent pass | Opponent goal |
|---|---|---|---|
| Low | −5% | +5% | −3% |
| Medium | 0% | 0% | 0% |
| High | +5% | −5% | +3% |

### Passing style

| Style | Modifier |
|---|---|
| One-touch | 0% |
| Long balls | −10% |
| Target man | +5% (only for target player) |

### Additional smaller modifiers

| Modifier | Effect |
|---|---|
| Home advantage | +2% passes, shots, defending / ball recovery |
