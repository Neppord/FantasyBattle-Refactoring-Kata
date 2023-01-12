module Test.Main where

import Prelude

import Damage (Damage(..))
import Effect (Effect)
import Effect.Aff (launchAff_)
import Item (Item(..))
import Player (Target(..), calculateDamage)
import Test.Spec (describe, it)
import Test.Spec.Assertions (shouldEqual)
import Test.Spec.Reporter.Console (consoleReporter)
import Test.Spec.Reporter.TeamCity (teamcityReporter)
import Test.Spec.Runner (runSpec)
import Inventory (Inventory(..))
import Equipment (Equipment(..))

main :: Effect Unit
main = launchAff_ $ runSpec [ consoleReporter, teamcityReporter ] do
  describe "player" do
    it "does no damage to itself" do
      let
        uselessItem = BasicItem { name: "useless", baseDamage: 0, damageModifier: 0.0 }
        equipment = Equipment
          { leftHand: uselessItem
          , rightHand: uselessItem
          , head: uselessItem
          , chest: uselessItem
          , feet: uselessItem
          }
        inventory = Inventory { equipment }
        stats = { strength: 1 }
        player = { inventory, stats }
        noDamage = Damage 0
      player
        # calculateDamage (PlayerTarget player)
        # shouldEqual noDamage

