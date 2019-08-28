#ifndef FANTASYBATTLE_ITEM_H
#define FANTASYBATTLE_ITEM_H

#include <string>

class Item {
public:
    Item(std::string & name, int baseDamage, float damageModifier);
    const int getBaseDamage();
    const float getDamageModifier();
protected:
    std::string name;
    int baseDamage;
    float damageModifier;
};


#endif //FANTASYBATTLE_ITEM_H
