package codingdojo;

public class Enchantments extends Equipment<Enchantment> {

    Enchantments(
        Enchantment leftHand,
        Enchantment rightHand,
        Enchantment head,
        Enchantment feet,
        Enchantment chest,
        Enchantment ring
    ) {
        super(leftHand, rightHand, head, feet, chest, ring);
    }

    public int additionalDamage() {
        return map( e -> e.additionalDamage).reduce(Integer::sum);
    }
}
