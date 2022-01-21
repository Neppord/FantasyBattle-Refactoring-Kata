#ifndef FANTASYBATTLE_BASIC_ITEM_H
#define FANTASYBATTLE_BASIC_ITEM_H


#include <string>
#include "Item.h"

class BasicItem : public Item {
public:
    BasicItem(const std::string & name, int baseDamage, float damageModifier);

    virtual const int getBaseDamage() override;
    virtual const float getDamageModifier() override;

protected:
    std::string name;
    int baseDamage;
    float damageModifier;
};


#endif //FANTASYBATTLE_BASIC_ITEM_H
