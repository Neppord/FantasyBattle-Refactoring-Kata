module Damage where

import Prelude

newtype Damage = Damage Int

derive newtype instance Show Damage
derive newtype instance Eq Damage
derive newtype instance Ord Damage