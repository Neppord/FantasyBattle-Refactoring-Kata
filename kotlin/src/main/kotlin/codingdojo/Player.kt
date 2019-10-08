package codingdojo

import kotlin.math.max
import kotlin.math.roundToInt

class Player(private val inventory: Inventory, private val stats: Stats): Target() {

    private val damageModifier: Float
        get() {
            val equipment = this.inventory.equipment
            val leftHand = equipment.leftHand
            val rightHand = equipment.rightHand
            val head = equipment.head
            val feet = equipment.feet
            val chest = equipment.chest
            val strengthModifier = stats.strength * 0.1f
            return strengthModifier +
                    leftHand.damageModifier +
                    rightHand.damageModifier +
                    head.damageModifier +
                    feet.damageModifier +
                    chest.damageModifier
        }

    private val baseDamage: Int
        get() {
            val equipment = this.inventory.equipment
            val leftHand = equipment.leftHand
            val rightHand = equipment.rightHand
            val head = equipment.head
            val feet = equipment.feet
            val chest = equipment.chest
            return leftHand.baseDamage +
                    rightHand.baseDamage +
                    head.baseDamage +
                    feet.baseDamage +
                    chest.baseDamage
        }

    fun calculateDamage(other: Target): Damage {
        val baseDamage = baseDamage
        val damageModifier = damageModifier
        val totalDamage = (baseDamage * damageModifier).roundToInt()
        val soak = getSoak(other, totalDamage)
        return Damage(max(0, totalDamage - soak))
    }

    private fun getSoak(other: Target, totalDamage: Int): Int {
        var soak = 0
        if (other is Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage
        } else if (other is SimpleEnemy) {
            val simpleEnemy = other
            soak = (simpleEnemy.armor.damageSoak *
                    (simpleEnemy.buffs
                        .stream()
                        .mapToDouble { it.soakModifier().toDouble() }
                        .sum()) + 1f
                    ).roundToInt()
        }
        return soak
    }
}
