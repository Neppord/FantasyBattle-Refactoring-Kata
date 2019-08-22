namespace FantasyBattle
{
    public class BasicItem : Item
    {
        public BasicItem(string name, int baseDamage, float damageModifier)
        {
            BaseDamage = baseDamage;
            DamageModifier = damageModifier;
        }

        public int BaseDamage { get; }
        public float DamageModifier { get; }
    }
}