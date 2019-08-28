#include "Player.h"

Player::Player(Inventory &inventory) : inventory(inventory) {
}

Damage * Player::calculateDamage() {
    return  new Damage(32);
}