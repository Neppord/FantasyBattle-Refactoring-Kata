namespace FantasyBattle
{
    public class BasicBuff : Buff
    {
        public BasicBuff(float soakModifier, float damageModifier)
        {
            SoakModifier = soakModifier;
            DamageModifier = damageModifier;
        }

        public float SoakModifier { get; }
        public float DamageModifier { get; }
    }
}