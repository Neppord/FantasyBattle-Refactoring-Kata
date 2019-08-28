
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

    //TODO: finish this test case

    auto inventory = new Inventory(/*todo*/);
    auto stats = new Stats(0);
    auto player =  new Player(*inventory, *stats);

    auto target = new SimpleEnemy(/*todo*/, /*todo*/);
    Damage *damage = player->calculateDamage(*target);

    ASSERT_EQ(10, damage->getAmount());
}