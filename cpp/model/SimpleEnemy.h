#ifndef FANTASYBATTLE_SIMPLEENEMY_H
#define FANTASYBATTLE_SIMPLEENEMY_H

#include <vector>

#include "Armor.h"
#include "Buff.h"
#include "Target.h"

using namespace std;

class SimpleEnemy : public Target {
public:
    SimpleEnemy(Armor & armor, vector<Buff> & buffs);

    virtual const bool isPlayer();
    virtual const vector<Buff> getBuffs();
    virtual const Armor getArmor();
private:
    Armor armor;
    vector<Buff> & buffs;
};


#endif //FANTASYBATTLE_SIMPLEENEMY_H
