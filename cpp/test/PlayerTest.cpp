
#include <string>
#include <vector>

#include "gtest/gtest.h"
#include "../model/Player.h"
#include "../model/Damage.h"
#include "../model/Inventory.h"
#include "../model/Stats.h"
#include "../model/SimpleEnemy.h"

using namespace std;


TEST(PlayerTest, DamageCalculations) {

    //TODO: finish this test case

    auto inventory = new Inventory(/*todo*/);
    auto stats = new Stats(0);
    auto target = new SimpleEnemy(/*todo*/, /*todo*/);

    auto player =  new Player(*inventory, *stats);
    Damage *damage = player->calculateDamage(*target);

    ASSERT_EQ(10, damage->getAmount());
}
