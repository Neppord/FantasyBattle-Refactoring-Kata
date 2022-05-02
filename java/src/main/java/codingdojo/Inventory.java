package codingdojo;

public class Inventory {
    private Equipment equipment;

    public Inventory(Equipment equipment) {
        this.equipment = equipment;
    }

    public float damageModifier() {
        return equipment.damageModifier();
    }

    public int baseDamage() {
        Equipment equipment = this.equipment;
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
