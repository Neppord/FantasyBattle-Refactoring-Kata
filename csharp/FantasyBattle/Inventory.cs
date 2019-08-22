namespace FantasyBattle
{
    public class Inventory
    {
        public Equipment Equipment { get; }

        public Inventory(Equipment equipment)
        {
            Equipment = equipment;
        }
    }

    public class Equipment
    {
        // TODO add a ring item that may be equipped
        //  that may also add damage modifier
        public Item LeftHand { get; }
        public Item RightHand { get; }
        public Item Head { get; }
        public Item Feet { get; }
        public Item Chest { get; }

        public Equipment(Item leftHand, Item rightHand, Item head, Item feet, Item chest)
        {
            LeftHand = leftHand;
            RightHand = rightHand;
            Head = head;
            Feet = feet;
            Chest = chest;
        }
    }

    public interface Item
    {
        int BaseDamage { get; }
        float DamageModifier { get; }
    }
}