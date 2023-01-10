module Equipment where

import Item (Item)

type Equipment =
  { leftHand :: Item
  , rightHand :: Item
  , head :: Item
  , feet :: Item
  , chest :: Item
  }