#include "Buff.h"

Buff::Buff(float soakModifier, float damageModifier): soakModifier(soakModifier), damageModifier(damageModifier) {};

float Buff::getDamageModifier() {
    return damageModifier;
}

float Buff::getSoakModifier() {
    return soakModifier;
}

