#include "SimpleEnemy.h"

SimpleEnemy::SimpleEnemy(Armor &armor, vector<Buff> & buffs) : armor(armor), buffs(buffs) {}

const Armor SimpleEnemy::getArmor() {
    return armor;
}

const vector<Buff> SimpleEnemy::getBuffs() {
    return buffs;
}

const bool SimpleEnemy::isPlayer() {
    return false;
}