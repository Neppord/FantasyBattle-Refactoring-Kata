namespace FantasyBattle
{
    public class Inventory
    {
        public virtual Equipment Equipment { get; }

        public Inventory()
        {

        }


        public Inventory(Equipment equipment)
        {
            Equipment = equipment;
        }
    }
}