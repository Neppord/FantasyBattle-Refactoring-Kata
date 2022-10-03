using System;
using System.Linq;

namespace FantasyBattle
{
    public class Player : Target
    {
        public Inventory Inventory { get; }
        public Stats Stats { get; }

        public Player(Inventory inventory, Stats stats)
        {
            Inventory = inventory;
            Stats = stats;
        }

        public Damage CalculateDamage(Target other)
        {
            int baseDamage = CalculateBaseDamage();
            float damageModifier = CalculateDamageModifier();
            int totalDamage = (int)Math.Round(baseDamage * damageModifier, 0);
            int soak = GetSoak(other, totalDamage);
            return new Damage(Math.Max(0, totalDamage - soak));
        }

        private int CalculateBaseDamage()
        {
            Equipment equipment = Inventory.Equipment;
            Item leftHand = equipment.LeftHand;
            Item rightHand = equipment.RightHand;
            Item head = equipment.Head;
            Item feet = equipment.Feet;
            Item chest = equipment.Chest;
            return leftHand.BaseDamage +
                   rightHand.BaseDamage +
                   head.BaseDamage +
                   feet.BaseDamage +
                   chest.BaseDamage;
        }

        private float CalculateDamageModifier()
        {
            Equipment equipment = Inventory.Equipment;
            Item leftHand = equipment.LeftHand;
            Item rightHand = equipment.RightHand;
            Item head = equipment.Head;
            Item feet = equipment.Feet;
            Item chest = equipment.Chest;
            float strengthModifier = Stats.Strength * 0.1f;
            return strengthModifier +
                   leftHand.DamageModifier +
                   rightHand.DamageModifier +
                   head.DamageModifier +
                   feet.DamageModifier +
                   chest.DamageModifier;
        }

        private int GetSoak(Target other, int totalDamage)
        {
            int soak = 0;
            if (other is Player)
            {
                // TODO: Not implemented yet
                //  Add friendly fire
                soak = totalDamage;
            }
            else if (other is SimpleEnemy simpleEnemy)
            {
                soak = (int)Math.Round(
                    simpleEnemy.Armor.DamageSoak *
                    (
                        simpleEnemy.Buffs.Select(x => x.SoakModifier).Sum() + 1
                    ), 0
                );
            }

            return soak;
        }
    }
}