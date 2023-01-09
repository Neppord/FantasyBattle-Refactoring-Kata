package codingdojo;

public class Inventory {
    private final Equipment equipment;
    public Inventory(Equipment equipment) {this.equipment = equipment;}
    int getBaseDamage() {return equipment.getBaseDamage();}
    float getDamageModifier() {return equipment.getDamageModifier();}

}
