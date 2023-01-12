module Equipment where

import Item (Item)
import Data.Newtype (class Newtype)

newtype Equipment = Equipment
  { leftHand :: Item
  , rightHand :: Item
  , head :: Item
  , feet :: Item
  , chest :: Item
  }
derive instance Newtype Equipment _
