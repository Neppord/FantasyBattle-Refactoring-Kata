package codingdojo;


class Player implements Target {
    // TODO: add player buffs

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    private Inventory inventory;
    private Stats stats;

    Damage attack (Target other) {
        Equipment equipment = this.inventory.getEquipment();
        Item leftHand = equipment.getLeftHand();
        Item rightHand = equipment.getRightHand();
        Item head = equipment.getHead();
        Item feet = equipment.getFeet();
        Item chest = equipment.getChest();
        int baseDamage = (
            leftHand.getBaseDamage() +
            rightHand.getBaseDamage() +
            head.getBaseDamage() +
            feet.getBaseDamage() +
            chest.getBaseDamage()
        );
        float strengthModifier = stats.getStrength() * 0.1f;
        int totalDamage = Math.round(baseDamage * (
            strengthModifier +
            leftHand.getDamageModifier() +
            rightHand.getDamageModifier() +
            head.getDamageModifier() +
            feet.getDamageModifier() +
            chest.getDamageModifier()
        ));

        if (other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire and player HP
            return new Damage(0);
        } else if (other instanceof SimpleEnemy) {
            SimpleEnemy simpleEnemy = (SimpleEnemy) other;
            int soak = Math.round(
                simpleEnemy.getArmor().getDamageSoak() *
                (
                    ((float) simpleEnemy.getBuffs()
                        .stream()
                        .mapToDouble(Buff::soakModifier)
                        .sum()) +
                    1f
                )
            );
            return new Damage(Math.max(0, totalDamage - soak));
        }
        return new Damage(0);
    }
}
