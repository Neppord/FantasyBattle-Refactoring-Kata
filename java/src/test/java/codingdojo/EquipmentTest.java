package codingdojo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EquipmentTest {

    @Test
    void map() {
        Equipment<Integer> equipment = new Equipment<>(1, 2, 3, 4, 5, 6);

        Equipment<Integer> result = equipment.map((Integer x) -> x + 1);

        assertEquals(new Equipment<>(2, 3, 4, 5, 6, 7), result);
    }

    @Test
    void reduce() {
        Equipment<Integer> equipment = new Equipment<>(1, 2, 3, 4, 5, 6);

        Integer result = equipment.reduce(Integer::sum);

        assertEquals(21, result);
    }
}
