package codingdojo;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void attack() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        Damage damage = new Player(inventory, stats).attack(target);
        assertEquals(10, damage.getAmount());
    }
}