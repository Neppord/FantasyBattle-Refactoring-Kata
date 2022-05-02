package codingdojo;


class Player extends Target {
    private Inventory inventory;
    private Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    Damage calculateDamage(Target other) {
        int baseDamage = inventory.baseDamage();
        float damageModifier = getDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = getSoak(other, totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    private float getDamageModifier() {
        return stats.strengthModifier() + inventory.damageModifier();
    }

    private int getSoak(Target other, int totalDamage) {
        int soak = 0;
        if (other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (other instanceof SimpleEnemy enemy) {
            soak = enemy.getSimpleSoak();
        }
        return soak;
    }

}
