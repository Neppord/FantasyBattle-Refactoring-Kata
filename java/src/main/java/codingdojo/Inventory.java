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
        return equipment.baseDamage();
    }

}
