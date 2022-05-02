package codingdojo;

public class Inventory {
    private final Equipment<Item> equipment;

    public Inventory(Equipment<Item> equipment1) {
        this.equipment = equipment1;
    }

    public float damageModifier() {
        return equipment.map(Item::getDamageModifier).reduce(Float::sum);
    }

    public int baseDamage() {
        return equipment.map(Item::getBaseDamage).reduce(Integer::sum);
    }

}
