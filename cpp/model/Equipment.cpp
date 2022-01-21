#include "Equipment.h"

Equipment::Equipment(Item &leftHand, Item &rightHand, Item &head, Item &feet, Item &chest) : leftHand(leftHand), rightHand(rightHand), head(head), feet(feet), chest(chest) {

}

// TODO add a ring item that may be equipped
//  that may also add damage modifier

const Item Equipment::getLeftHand() {
    return leftHand;
}

const Item Equipment::getRightHand() {
    return rightHand;
}

const Item Equipment::getHead() {
    return head;
}

const Item Equipment::getFeet() {
    return feet;
}

const Item Equipment::getChest() {
    return chest;
}
