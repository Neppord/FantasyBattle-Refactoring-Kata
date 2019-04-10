namespace lod
{
    public class Inventory
    {
        private Equipment equipment;

        public Inventory(Equipment equipment)
        {
            this.equipment = equipment;
        }

        public Equipment getEquipment()
        {
            return equipment;
        }
    }
}