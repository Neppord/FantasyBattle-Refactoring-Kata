#ifndef CPP_INVENTORY_H
#define CPP_INVENTORY_H


#include "Equipment.h"

class Inventory {
public:
    explicit Inventory(Equipment & equipment);

    Equipment & getEquipment();
private:
    Equipment equipment;
};


#endif //CPP_INVENTORY_H
