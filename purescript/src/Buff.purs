module Buff where

data Buff = BasicBuff { soak :: Number, damage :: Number }

soakModifier :: Buff -> Number
soakModifier (BasicBuff { soak }) = soak

damageModifier :: Buff -> Number
damageModifier (BasicBuff { damage }) = damage