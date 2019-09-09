#include "Armor.h"


Armor::Armor(int soak) : soak(soak) {
}

int Armor::getDamageSoak() const {
    return soak;
}

