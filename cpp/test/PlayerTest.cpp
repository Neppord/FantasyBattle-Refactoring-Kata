
#include <string>
#include <vector>

#include "gtest/gtest.h"
#include "../model/Player.h"
#include "../model/Damage.h"
#include "../model/Inventory.h"
#include "../model/Stats.h"
#include "../model/Armor.h"
#include "../model/Buff.h"
#include "../model/SimpleEnemy.h"

using namespace std;


TEST(PlayerTest, DamageCalculations) {

    auto shield = string("round shield");
    auto left = Item(shield, 0, 1.4);
    auto excalibur = string("excalibur");
    auto right = Item(excalibur, 20, 1.5);
    auto helmet = string("helmet of swiftness");
    auto head = Item(helmet, 0, 1.2);
    auto boots = string("ten league boots");
    auto feet = Item(boots, 0, 0.1);
    auto breastplate = string("breastplate of steel");
    auto chest = Item(breastplate, 0, 0.4);
    auto equipment = new Equipment(left, right, head, feet, chest);
    auto inventory = new Inventory(*equipment);
    auto stats = new Stats(0);
    auto player =  new Player(*inventory, *stats);

    auto armor = new Armor(10);
    vector<Buff> buffs;
    buffs.push_back(Buff(1.0, 2.0));
    auto target = new SimpleEnemy(*armor, buffs);
    Damage *damage = player->calculateDamage(*target);

    ASSERT_EQ(10, damage->getAmount());
}