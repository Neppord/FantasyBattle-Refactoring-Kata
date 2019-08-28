#ifndef FANTASYBATTLE_TARGET_H
#define FANTASYBATTLE_TARGET_H

#include <vector>

#include "Buff.h"
#include "Armor.h"

using namespace std;

class Target {
public:
    virtual const bool isPlayer() = 0;
    virtual const vector<Buff> getBuffs() = 0;
    virtual const Armor getArmor() = 0;
};

#endif //FANTASYBATTLE_TARGET_H
