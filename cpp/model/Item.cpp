#include "Item.h"

Item::Item(std::string & name, int baseDamage, float damageModifier) : name(name), baseDamage(baseDamage), damageModifier(damageModifier) {}

const float Item::getDamageModifier() {
    return damageModifier;
}

const int Item::getBaseDamage() {
    return baseDamage;
}