#ifndef FANTASYBATTLE_EQUIPMENT_H
#define FANTASYBATTLE_EQUIPMENT_H


#include "Item.h"

class Equipment {
public:
    Equipment(Item* leftHand, Item* rightHand, Item* head, Item* feet, Item* chest);

    Item* getLeftHand();
    Item* getRightHand();
    Item* getHead();
    Item* getFeet();
    Item* getChest();

protected:
    Item* leftHand;
    Item* rightHand;
    Item* head;
    Item* feet;
    Item* chest;
};


#endif //FANTASYBATTLE_EQUIPMENT_H
