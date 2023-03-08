using System.Collections.Generic;

namespace FantasyBattle
{
    public class SimpleEnemy : Target
    {
        public virtual Armor Armor { get; }
        public virtual List<Buff> Buffs { get; }

        public SimpleEnemy()
        {

        }

        public SimpleEnemy(Armor armor, List<Buff> buffs)
        {
            Armor = armor;
            Buffs = buffs;
        }
    }

    public interface Buff
    {
        float SoakModifier { get; }
        float DamageModifier { get; }
    }

    public interface Armor
    {
        int DamageSoak { get; }
    }
}