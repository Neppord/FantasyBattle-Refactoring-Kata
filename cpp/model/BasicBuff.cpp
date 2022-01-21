#include "BasicBuff.h"

BasicBuff::BasicBuff(float soakModifier, float damageModifier): soakModifier(soakModifier), damageModifier(damageModifier) {

}

float BasicBuff::getDamageModifier() {
    return damageModifier;
}

float BasicBuff::getSoakModifier() {
    return soakModifier;
}
