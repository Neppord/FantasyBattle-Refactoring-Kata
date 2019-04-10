using System.Collections.Generic;

namespace lod
{
    internal class SimpleEnemy : Target
    {
        public IArmor Armor { get; set; }
        public List<IBuff> Buffs { get; set; }

    }
}