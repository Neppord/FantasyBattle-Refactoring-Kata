package codingdojo;

public class BasicItem implements Item {

    private int baseDamage;
    private int damageModifier;

    public BasicItem(int baseDamage, int damageModifier) {
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
