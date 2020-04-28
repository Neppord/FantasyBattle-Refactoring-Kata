class Item:
    base_damage: int
    damage_modifier: float


class BaseItem(Item):
    name: str

    def __init__(
        self,
        name: str,
        base_damage: int,
        damage_modifier: float
    ) -> None:
        self.name = name
        self.base_damage = base_damage
        self.damage_modifier = damage_modifier
