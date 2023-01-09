package codingdojo;

public class BasicBuff implements Buff {

    private final float soak;
    private final float damage;

    public BasicBuff(float soak, float damage) {
        this.soak = soak;
        this.damage = damage;
    }

    @Override
    public float soakModifier() {
        return soak;
    }

    @Override
    public float damageModifier() {
        return damage;
    }
}
