#ifndef CPP_PLAYER_H
#define CPP_PLAYER_H


#include "Inventory.h"
#include "Damage.h"
#include "Stats.h"
#include "Target.h"

class Player {

public:
    Player(Inventory & inventory, Stats & stats);

    Damage * calculateDamage(Target & target);

protected:
    Inventory & inventory;
    Stats & stats;

    int getBaseDamage();
    float getDamageModifier();
    int getSoak(Target & other, int totalDamage);
};


#endif //CPP_PLAYER_H
