package codingdojo;


class Player extends Target {
    private final Inventory inventory;
    private final Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    Damage calculateDamage(Target other) {
        int baseDamage = inventory.getBaseDamage();
        float damageModifier
            = stats.getDamageModifier()
            + inventory.getDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = other.getSoak(totalDamage);
        int damage = totalDamage - soak;
        int absoluteDamage = Math.max(0, damage);
        return new Damage(absoluteDamage);
    }

    @Override
    int getSoak(int totalDamage) {
        // TODO: Not implemented yet
        //  Add friendly fire
        return totalDamage;
    }
}
