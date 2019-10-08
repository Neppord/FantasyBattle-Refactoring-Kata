package codingdojo

class BasicItem(
    private val name: String,
    override val baseDamage: Int,
    override val damageModifier: Float
): Item
