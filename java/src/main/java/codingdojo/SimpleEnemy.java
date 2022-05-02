package codingdojo;

import java.util.List;

public class SimpleEnemy extends Target {

    private final Armor armor;
    private final List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    List<Buff> getBuffs() {
        return buffs;
    }

    Armor getArmor() {
        return this.armor;
    }

    @Override
    int getSoak(int totalDamage) {
        return Math.round(getArmor().getDamageSoak() * 
            (((float) getBuffs().stream().mapToDouble(Buff::soakModifier).sum()) + 1f)
        );
    }
}
