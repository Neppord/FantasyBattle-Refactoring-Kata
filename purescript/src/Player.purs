module Player where

import Prelude

import Damage (Damage(..))
import Data.Int (round, toNumber)
import Data.Newtype (un)
import Equipment (Equipment(Equipment))
import Inventory (Inventory(Inventory))
import SimpleEnemy (SimpleEnemy)
import Stats (Stats)
import Armor (getDamageSoak) as Armor
import Data.Array (foldr) as Array
import Buff (soakModifier) as Buff
import Item (getBaseDamage, getDamageModifier) as Item

type Player =
  { inventory :: Inventory
  , stats :: Stats
  }

data Target
  = PlayerTarget Player
  | SimpleEnemyTarget SimpleEnemy

calculateDamage :: Target -> Player -> Damage
calculateDamage other player = Damage (max 0 (totalDamage - soak))
  where
  baseDamage = player # getBaseDamage
  damageModifier = player # getDamageModifier
  totalDamage = round (toNumber baseDamage * damageModifier)
  soak = player # getSoak other totalDamage

getBaseDamage :: Player -> Int
getBaseDamage player = Item.getBaseDamage leftHand
  + Item.getBaseDamage rightHand
  + Item.getBaseDamage head
  + Item.getBaseDamage feet
  + Item.getBaseDamage chest
  where
  equipment = player.inventory
    # un Inventory
    # _.equipment
    # un Equipment
  leftHand = equipment.leftHand
  rightHand = equipment.rightHand
  head = equipment.head
  feet = equipment.feet
  chest = equipment.chest

getDamageModifier :: Player -> Number
getDamageModifier player = strengthModifier
  + Item.getDamageModifier leftHand
  + Item.getDamageModifier rightHand
  + Item.getDamageModifier head
  + Item.getDamageModifier feet
  + Item.getDamageModifier chest
  where
  equipment = player.inventory
    # un Inventory
    # _.equipment
    # un Equipment
  leftHand = equipment.leftHand
  rightHand = equipment.rightHand
  head = equipment.head
  feet = equipment.feet
  chest = equipment.chest
  strengthModifier = toNumber player.stats.strength * 0.1

getSoak :: Target -> Int -> Player -> Int
getSoak target totalDamage _ = case target of
  PlayerTarget _ -> totalDamage
  SimpleEnemyTarget other -> round $
    (other.armor # Armor.getDamageSoak # toNumber)
      * (other.buffs <#> Buff.soakModifier # Array.foldr (+) 1.0)