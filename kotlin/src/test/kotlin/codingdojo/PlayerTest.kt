package codingdojo

import org.junit.Ignore
import org.junit.Test
import org.mockito.Mockito.mock
import kotlin.test.assertEquals

class PlayerTest {

    // choose this one if you are familiar with mocks
    @Ignore("Test is not finished yet")
    @Test
    fun damageCalculationsWithMocks() {
        val inventory = mock(Inventory::class.java)
        val stats = mock(Stats::class.java)
        val target = mock(SimpleEnemy::class.java)

        val damage = Player(inventory, stats).calculateDamage(target)
        assertEquals(10, damage.amount)
    }

    // choose this one if you are not familiar with mocks
    @Ignore("Test is not finished yet")
    @Test
    fun damageCalculations() {
        val inventory = Inventory(null !!)
        val stats = Stats(0)
        val target = SimpleEnemy(null !!, null !!)
        val damage = Player(inventory, stats).calculateDamage(target)
        assertEquals(10, damage.amount)
    }
}
