package codingdojo;

public class Stats {
    private final int strength;
    private final int dexterity;

    public Stats(int strength, int dexterity) {
        this.strength = strength;
        this.dexterity = dexterity;
    }

    public float damageModifier() {
        return strength * 0.1f + dexterity * 0.05f;
    }
}
