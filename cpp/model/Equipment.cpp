#include "Equipment.h"

Equipment::Equipment(Item* leftHand, Item* rightHand, Item* head, Item* feet, Item* chest) : leftHand(leftHand), rightHand(rightHand), head(head), feet(feet), chest(chest) {

}

// TODO add a ring item that may be equipped
//  that may also add damage modifier

Item* Equipment::getLeftHand() {
    return leftHand;
}

Item* Equipment::getRightHand() {
    return rightHand;
}

Item* Equipment::getHead() {
    return head;
}

Item* Equipment::getFeet() {
    return feet;
}

Item* Equipment::getChest() {
    return chest;
}
