package codingdojo;

abstract class Target {
    int getSoak(int totalDamage) {
        int soak = 0;
        if (this instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (this instanceof SimpleEnemy enemy) {
            soak = enemy.getSimpleSoak();
        }
        return soak;
    }
}
