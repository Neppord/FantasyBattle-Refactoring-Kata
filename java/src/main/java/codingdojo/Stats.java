package codingdojo;

public class Stats {
    // TODO add dexterity that will both help with soak and damage.
    //  but half of what strength gives.
    private final int strength;
    public Stats(int strength) {this.strength = strength;}
    float getDamageModifier() {return strength * 0.1f;}
}
