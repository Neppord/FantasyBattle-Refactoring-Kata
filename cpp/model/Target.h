#ifndef FANTASYBATTLE_TARGET_H
#define FANTASYBATTLE_TARGET_H


#include <vector>

#include "Buff.h"
#include "Armor.h"

using namespace std;

class Target {
public:
    virtual const bool isPlayer() = 0;
};


#endif //FANTASYBATTLE_TARGET_H
