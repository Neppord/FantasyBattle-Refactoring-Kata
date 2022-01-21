#ifndef FANTASYBATTLE_SIMPLE_ARMOR_H
#define FANTASYBATTLE_SIMPLE_ARMOR_H

#include "Armor.h"

class SimpleArmor : public Armor {
public:
    explicit SimpleArmor(int soak);

    virtual int getDamageSoak() const override;

protected:
    int soak;
};


#endif //FANTASYBATTLE_SIMPLE_ARMOR_H
