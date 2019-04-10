using System;
using System.Linq;

namespace lod
{
    public class Player : Target
    {

        private Inventory inventory;
        private Stats stats;

        public Player(Inventory inventory, Stats stats)
        {
            this.inventory = inventory;
            this.stats = stats;
        }

        public Damage calculateDamage(Target other)
        {
            int baseDamage = getBaseDamage();
            float damageModifier = getDamageModifier();
            int totalDamage = (int) Math.Round(baseDamage * damageModifier, MidpointRounding.AwayFromZero);
            int soak = getSoak(other, totalDamage);
            return new Damage(Math.Max(0, totalDamage - soak));
        }

        private int getSoak(Target other, int totalDamage)
        {
            int soak = 0;
            if (other is Player) {
                // TODO: Not implemented yet
                //  Add friendly fire
                soak = totalDamage;
            } else if (other is SimpleEnemy) {
                SimpleEnemy simpleEnemy = (SimpleEnemy)other;
                soak = (int)Math.Round(
                    simpleEnemy.getArmor().getDamageSoak() *
                    (
                        ((float)simpleEnemy.getBuffs()
                             .Select(buff => buff.soakModifier())
                             .Sum() + 1f)
                    )
                );
            }
            return soak;
        }

        private float getDamageModifier()
        {
            Equipment equipment = this.inventory.getEquipment();
            Item leftHand = equipment.getLeftHand();
            Item rightHand = equipment.getRightHand();
            Item head = equipment.getHead();
            Item feet = equipment.getFeet();
            Item chest = equipment.getChest();
            float strengthModifier = stats.getStrength() * 0.1f;
            return strengthModifier +
                leftHand.getDamageModifier() +
                rightHand.getDamageModifier() +
                head.getDamageModifier() +
                feet.getDamageModifier() +
                chest.getDamageModifier();
        }

        private int getBaseDamage()
        {
            Equipment equipment = this.inventory.getEquipment();
            Item leftHand = equipment.getLeftHand();
            Item rightHand = equipment.getRightHand();
            Item head = equipment.getHead();
            Item feet = equipment.getFeet();
            Item chest = equipment.getChest();
            return leftHand.getBaseDamage() +
            rightHand.getBaseDamage() +
            head.getBaseDamage() +
            feet.getBaseDamage() +
            chest.getBaseDamage();
        }
    }
}