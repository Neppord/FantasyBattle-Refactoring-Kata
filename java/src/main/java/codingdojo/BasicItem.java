package codingdojo;

public class BasicItem implements Item {

    private String name;
    private int baseDamage;
    private float damageModifier;

    public BasicItem(String name, int baseDamage, float damageModifier) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.damageModifier = damageModifier;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}
