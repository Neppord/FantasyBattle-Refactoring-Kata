namespace FantasyBattle
{
    public class Stats
    {
        // TODO add dexterity that will both help with soak and damage.
        //  but half of what strength gives.
        public virtual int Strength { get; }

        public Stats()
        {

        }

        public Stats(int strength)
        {
            Strength = strength;
        }
    }
}