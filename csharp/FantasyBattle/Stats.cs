namespace FantasyBattle
{
    public class Stats
    {
        // TODO add dexterity that will both help with soak and damage.
        //  but half of what strength gives.
        public int Strength { get; }

        public Stats(int strength)
        {
            Strength = strength;
        }
    }
}