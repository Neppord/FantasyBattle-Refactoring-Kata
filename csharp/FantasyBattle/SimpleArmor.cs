namespace FantasyBattle
{
    public class SimpleArmor : Armor
    {
        public SimpleArmor(int damageSoak)
        {
            DamageSoak = damageSoak;
        }

        public int DamageSoak { get; }
    }
}