#include "Stats.h"

Stats::Stats(int strength) : strength(strength) {

}

// TODO add dexterity that will both help with soak and damage.
//  but half of what strength gives.

int Stats::getStrength() {
    return strength;
}
