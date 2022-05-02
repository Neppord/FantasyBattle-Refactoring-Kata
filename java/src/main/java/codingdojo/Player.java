package codingdojo;


class Player extends Target {
    private final Inventory inventory;
    private final Stats stats;
    private Enchantments enchantments;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
        this.enchantments = new Enchantments(
            new Enchantment(0),
            new Enchantment(0),
            new Enchantment(0),
            new Enchantment(0),
            new Enchantment(0),
            new Enchantment(0)
        );
    }
    Player(Inventory inventory, Stats stats, Enchantments enchantments) {
        this.inventory = inventory;
        this.stats = stats;
        this.enchantments = enchantments;
    }

    Damage calculateDamage(Target other) {
        int baseDamage = inventory.baseDamage();
        float damageModifier = stats.damageModifier() + inventory.damageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = other.getSoak(totalDamage);
        return new Damage(Math.max(0,
            totalDamage - soak + enchantments.additionalDamage()));
    }

    @Override
    int getSoak(int totalDamage) {
        return totalDamage / 2;
    }
}
