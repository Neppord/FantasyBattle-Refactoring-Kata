module Inventory where

import Equipment (Equipment)
import Data.Newtype (class Newtype)

newtype Inventory = Inventory { equipment :: Equipment }
derive instance Newtype Inventory _