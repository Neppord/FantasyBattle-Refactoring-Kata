using System;
using System.Linq;

namespace lod
{
    public class Player : Target
    {
        public Inventory Inventory { get; set; }
        public Stats Stats { get; set; }

        public Damage CalculateDamage(Target other)
        {
            var baseDamage = GetBaseDamage();
            var damageModifier = GetDamageModifier();
            var totalDamage = (int) Math.Round(baseDamage * damageModifier, MidpointRounding.AwayFromZero);
            var soak = GetSoak(other, totalDamage);
            return new Damage{Amount = Math.Max(0, totalDamage - soak)};
        }

        private int GetSoak(Target other, int totalDamage)
        {
            var soak = 0;
            if (other is Player) {
                // TODO: Not implemented yet
                //  Add friendly fire
                soak = totalDamage;
            } else if (other is SimpleEnemy) {
                SimpleEnemy simpleEnemy = (SimpleEnemy)other;
                soak = (int)Math.Round(
                    simpleEnemy.Armor.GetDamageSoak() *
                    (
                        ((float)simpleEnemy.Buffs
                             .Select(buff => buff.SoakModifier())
                             .Sum() + 1f)
                    )
                );
            }
            return soak;
        }

        private float GetDamageModifier()
        {
            var equipment = this.Inventory.Equipment;
            var leftHand = equipment.LeftHand;
            var rightHand = equipment.RightHand;
            var head = equipment.Head;
            var feet = equipment.Feet;
            var chest = equipment.Chest;
            float strengthModifier = Stats.Strength * 0.1f;
            return strengthModifier +
                leftHand.GetDamageModifier() +
                rightHand.GetDamageModifier() +
                head.GetDamageModifier() +
                feet.GetDamageModifier() +
                chest.GetDamageModifier();
        }

        private int GetBaseDamage()
        {
            var equipment = this.Inventory.Equipment;
            var leftHand = equipment.LeftHand;
            var rightHand = equipment.RightHand;
            var head = equipment.Head;
            var feet = equipment.Feet;
            var chest = equipment.Chest;
            return leftHand.GetBaseDamage() +
            rightHand.GetBaseDamage() +
            head.GetBaseDamage() +
            feet.GetBaseDamage() +
            chest.GetBaseDamage();
        }
    }
}