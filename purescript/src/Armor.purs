module Armor where

data Armor = SimpleArmor { soak :: Int }

getDamageSoak :: Armor -> Int
getDamageSoak (SimpleArmor { soak }) = soak