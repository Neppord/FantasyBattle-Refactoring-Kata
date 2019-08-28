#include "Inventory.h"
#include "Equipment.h"

Inventory::Inventory(Equipment & equipment) : equipment(equipment) {}

Equipment& Inventory::getEquipment() {
    return equipment;
}

