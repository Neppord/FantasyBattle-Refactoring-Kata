package codingdojo;

public class SimpleArmor implements Armor {

    private int soak;

    public SimpleArmor(int soak) {
        this.soak = soak;
    }

    @Override
    public int getDamageSoak() {
        return soak;
    }
}
