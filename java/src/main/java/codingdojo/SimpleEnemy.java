package codingdojo;

import java.util.List;

public class SimpleEnemy extends Target {

    private final Armor armor;
    // extract class to hold a collection of
    // buffs and methods on that collection
    private final List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    @Override
    int getSoak(int totalDamage) {
        int armorSoak = this.armor.getDamageSoak();
        float buffSoakModifier = ((float) buffs
            .stream()
            .mapToDouble(Buff::soakModifier)
            .sum()
        ) + 1f;
        return Math.round(armorSoak * buffSoakModifier);
    }

}
