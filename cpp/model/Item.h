#ifndef FANTASYBATTLE_ITEM_H
#define FANTASYBATTLE_ITEM_H


class Item {
public:
    virtual const int getBaseDamage() = 0;
    virtual const float getDamageModifier() = 0;
};


#endif //FANTASYBATTLE_ITEM_H
