class Buff:
    soak_modifier: float
    damage_modifier: float


class BasicBuff(Buff):
    def __init__(self, soak_modifier: float, damage_modifier: float) -> None:
        self.soak_modifier = soak_modifier
        self.damage_modifier = damage_modifier
