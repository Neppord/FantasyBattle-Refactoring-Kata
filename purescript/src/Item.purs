module Item where

data Item =
  BasicItem
    { name :: String
    , baseDamage :: Int
    , damageModifier :: Number
    }

getBaseDamage :: Item -> Int
getBaseDamage (BasicItem { baseDamage }) = baseDamage

getDamageModifier :: Item -> Number
getDamageModifier (BasicItem { damageModifier }) = damageModifier
