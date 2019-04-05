package codingdojo;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PlayerTest {

    @Ignore("Test is not finished yet")
    @Test
    public void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        SimpleEnemy target = mock(SimpleEnemy.class);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }

    @Ignore("Test is not finished yet")
    @Test
    public void damageCalculations() {
        Inventory inventory = new Inventory(null) {

        };
        Stats stats = new Stats(10) {

        };
        SimpleEnemy target = new SimpleEnemy(null, null) {
            @Override
            List<Buff> getBuffs() {
                return Collections.emptyList();
            }
        };
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }
}