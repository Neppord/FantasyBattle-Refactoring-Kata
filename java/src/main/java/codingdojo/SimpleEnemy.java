package codingdojo;

import java.util.Collections;
import java.util.List;

public class SimpleEnemy extends Target {

    private Armor armor;
    private List<Buff> buffs;

    public SimpleEnemy(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    List<Buff> getBuffs() {
        buffs = Collections.emptyList();
        return buffs;
    }

    Armor getArmor() {
        return this.armor;
    }
}
