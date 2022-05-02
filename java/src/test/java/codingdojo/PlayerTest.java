package codingdojo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    // choose this one if you are familiar with mocks
    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }

    @Test
    void damageCalculations() {
        final Equipment<Item> equipment = new Equipment<>(
                new BasicItem("Left Hand", 1, 2),
                new BasicItem("Right Hand", 3, 4),
                new BasicItem("Head", 5, 6),
                new BasicItem("Feet", 7, 8),
                new BasicItem("Chest", 9, 10), new BasicItem("ring", 0, 0)
        );
        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(10, 8);
        SimpleEnemy target = new SimpleEnemy(new SimpleArmor(5), List.of());
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(780, damage.getAmount());
    }
    @Test
    void damageCalculationsAgainstPlayer() {
        final Equipment<Item> equipment = new Equipment<>(
                new BasicItem("Left Hand", 1, 2),
                new BasicItem("Right Hand", 3, 4),
                new BasicItem("Head", 5, 6),
                new BasicItem("Feet", 7, 8),
                new BasicItem("Chest", 9, 10), new BasicItem("ring", 0, 0)
        );
        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(10, 8);
        Player target = new Player(inventory, stats);
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(0, damage.getAmount());
    }
}
