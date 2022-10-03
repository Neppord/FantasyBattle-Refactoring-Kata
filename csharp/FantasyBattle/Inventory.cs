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
}