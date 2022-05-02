package codingdojo;


import java.util.List;

class Equipment {
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private final Item leftHand;
    private final Item rightHand;
    private final Item head;
    private final Item feet;
    private final Item chest;

    Equipment(Item leftHand, Item rightHand, Item head, Item feet, Item chest) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
        this.head = head;
        this.feet = feet;
        this.chest = chest;
    }

    public float damageModifier() {
        return (float) allItems().stream().mapToDouble(Item::getDamageModifier).sum();
    }

    public int baseDamage() {
        return allItems().stream().mapToInt(Item::getBaseDamage).sum();
    }

    private List<Item> allItems() {
        return List.of(leftHand, rightHand, head, feet, chest);
    }
}
