package codingdojo

class BasicBuff(private val soak: Float, private val damage: Float): Buff {

    override fun soakModifier(): Float = soak

    override fun damageModifier(): Float = damage
}
