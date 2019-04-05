package codingdojo;


class Player extends Target {
    // TODO: add player buffs

    private Inventory inventory;
    private Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    Damage attack (Target other) {
        int baseDamage = getBaseDamage();
        float damageModifier = getDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);

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

    private float getDamageModifier() {
        Equipment equipment = this.inventory.getEquipment();
        Item leftHand = equipment.getLeftHand();
        Item rightHand = equipment.getRightHand();
        Item head = equipment.getHead();
        Item feet = equipment.getFeet();
        Item chest = equipment.getChest();
        float strengthModifier = stats.getStrength() * 0.1f;
        return strengthModifier +
            leftHand.getDamageModifier() +
            rightHand.getDamageModifier() +
            head.getDamageModifier() +
            feet.getDamageModifier() +
            chest.getDamageModifier();
    }

    private int getBaseDamage() {
        Equipment equipment = this.inventory.getEquipment();
        Item leftHand = equipment.getLeftHand();
        Item rightHand = equipment.getRightHand();
        Item head = equipment.getHead();
        Item feet = equipment.getFeet();
        Item chest = equipment.getChest();
        return leftHand.getBaseDamage() +
        rightHand.getBaseDamage() +
        head.getBaseDamage() +
        feet.getBaseDamage() +
        chest.getBaseDamage();
    }
}
