from typing import List

from Armor import Armor
from Buff import Buff


class Target:
    pass


class SimpleEnemy(Target):
    armor: Armor
    buffs: List[Buff]

    def __init__(self, armor: Armor, buffs: List[Buff]) -> None:
        self.armor = armor
        self.buffs = buffs
