#include <cmath>

#include "Player.h"
#include "Target.h"
#include "SimpleEnemy.h"

Player::Player(Inventory &inventory, Stats & stats) : inventory(inventory), stats(stats) {
}

const bool Player::isPlayer() {
    return true;
}

Damage * Player::calculateDamage(Target & target) {
    int baseDamage = getBaseDamage();
    float damageModifier = getDamageModifier();
    int totalDamage = round(baseDamage * damageModifier);
    int soak = getSoak(target, totalDamage);
    return new Damage(max(0, totalDamage - soak));
}

float Player::getDamageModifier() {
    Equipment equipment = inventory.getEquipment();
    Item* leftHand = equipment.getLeftHand();
    Item* rightHand = equipment.getRightHand();
    Item* head = equipment.getHead();
    Item* feet = equipment.getFeet();
    Item* chest = equipment.getChest();
    float strengthModifier = stats.getStrength() * 0.1f;
    return strengthModifier +
           leftHand->getDamageModifier() +
           rightHand->getDamageModifier() +
           head->getDamageModifier() +
           feet->getDamageModifier() +
           chest->getDamageModifier();
}

int Player::getBaseDamage() {
    Equipment equipment = inventory.getEquipment();
    Item* leftHand = equipment.getLeftHand();
    Item* rightHand = equipment.getRightHand();
    Item* head = equipment.getHead();
    Item* feet = equipment.getFeet();
    Item* chest = equipment.getChest();
    return leftHand->getBaseDamage() +
           rightHand->getBaseDamage() +
           head->getBaseDamage() +
           feet->getBaseDamage() +
           chest->getBaseDamage();
}

int Player::getSoak(Target & other, int totalDamage) {
    int soak = 0;
    if (other.isPlayer()) {
        // TODO: Not implemented yet
        //  Add friendly fire
        soak = totalDamage;
    } else {
        SimpleEnemy& enemy = static_cast<SimpleEnemy&>(other);
        float buffs = 1;
        for(Buff* buff: enemy.getBuffs()) {
            buffs += buff->getSoakModifier();
        }
        soak = round(
                enemy.getArmor()->getDamageSoak() * buffs
        );
    }
    return soak;
}