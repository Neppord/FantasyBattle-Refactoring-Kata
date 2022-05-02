package codingdojo;

public class Stats {
    // TODO add dexterity that will both help with soak and damage.
    //  but half of what strength gives.
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
