using System.Collections.Generic;

namespace lod
{
    internal class SimpleEnemy : Target
    {
        private IArmor armor;
        private List<IBuff> buffs;

        public SimpleEnemy(IArmor armor, List<IBuff> buffs)
        {
            this.armor = armor;
            this.buffs = buffs;
        }

        public List<IBuff> getBuffs()
        {
            return buffs;
        }

        public IArmor getArmor()
        {
            return this.armor;
        }
    }
}