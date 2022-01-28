#include "BasicItem.h"

BasicItem::BasicItem(const std::string &name, int baseDamage, float damageModifier) : name(name), baseDamage(baseDamage), damageModifier(damageModifier) {

}

const float BasicItem::getDamageModifier() {
    return damageModifier;
}

const int BasicItem::getBaseDamage() {
    return baseDamage;
}
