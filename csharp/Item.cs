using System;
using System.Collections.Generic;
using System.Threading;
using System.Threading.Tasks;

namespace lod
{
    public interface Item
    {
        int getBaseDamage();

        float getDamageModifier();
    }
}
