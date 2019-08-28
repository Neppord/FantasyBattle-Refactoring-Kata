#ifndef CPP_PLAYER_H
#define CPP_PLAYER_H


#include "Inventory.h"
#include "Damage.h"

class Player {

public:
    Player(Inventory & inventory);

    Damage * calculateDamage();

protected:
    Inventory & inventory;
};


#endif //CPP_PLAYER_H
