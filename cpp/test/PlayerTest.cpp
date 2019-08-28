
#include "gtest/gtest.h"
#include "../model/Player.h"
#include "../model/Damage.h"
#include "../model/Inventory.h"

TEST(PlayerTest, Foo) {

    auto damage = new Damage(42);
    ASSERT_EQ(2, damage->getAmount());
}

TEST(PlayerTest, Bar) {

    auto inventory = new Inventory();
    auto player =  new Player(*inventory);
    ASSERT_EQ(2, player->calculateDamage()->getAmount());
}