module SimpleEnemy where

import Armor (Armor)
import Buff (Buff)

type SimpleEnemy =
  { armor :: Armor
  , buffs :: Array Buff
  }