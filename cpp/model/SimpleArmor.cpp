#include "SimpleArmor.h"

SimpleArmor::SimpleArmor(int soak) : soak(soak) {
}

int SimpleArmor::getDamageSoak() const {
    return soak;
}
