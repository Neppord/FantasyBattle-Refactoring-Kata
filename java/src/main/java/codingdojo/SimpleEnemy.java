package codingdojo;

import java.util.Collections;
import java.util.List;

public class SimpleEnemy implements Target{

    private int hitPoints;
    private Armor armor;
    private List<Buff> buffs;

    public SimpleEnemy(int hitPoints, Armor armor, List<Buff> buffs) {
        this.hitPoints = hitPoints;
        this.armor = armor;
        this.buffs = buffs;
    }

    public List<Buff> getBuffs() {
        buffs = Collections.emptyList();
        return buffs;
    }

    public Armor getArmor() {
        return this.armor;
    }

    public int getHP() {
        return this.hitPoints;
    }

    public void setHP(int hitPoints) {
        this.hitPoints = hitPoints;
    }
}
