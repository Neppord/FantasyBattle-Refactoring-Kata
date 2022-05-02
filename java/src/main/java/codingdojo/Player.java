package codingdojo;


class Player extends Target {
    private final Inventory inventory;
    private final Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    Damage calculateDamage(Target other) {
        int baseDamage = inventory.baseDamage();
        float damageModifier = stats.damageModifier() + inventory.damageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = other.getSoak(totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    @Override
    int getSoak(int totalDamage) {
        return totalDamage / 2;
    }
}
