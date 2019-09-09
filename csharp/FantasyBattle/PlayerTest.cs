using System.Collections.Generic;
using System.Text;
using Moq;
using Xunit;

namespace FantasyBattle
{
    public class PlayerTest
    {
        
        // choose this one if you are familiar with mocks
        [Fact(Skip = "Test is not finished yet")]
        public void DamageCalculationsWithMocks() {
            var inventory = new Mock<Inventory>();
            var stats = new Mock<Stats>();
            var target = new Mock<SimpleEnemy>();

            var damage = new Player(inventory.Object, stats.Object).CalculateDamage(target.Object);
            Assert.Equal(10, damage.Amount);
        }

        // choose this one if you are not familiar with mocks
        [Fact(Skip = "Test is not finished yet")]
        public void DamageCalculations() {
            Inventory inventory = new Inventory(null);
            Stats stats = new Stats(0);
            SimpleEnemy target = new SimpleEnemy(null, null);
            Damage damage = new Player(inventory, stats).CalculateDamage(target);
            Assert.Equal(10, damage.Amount);
        }
    }
}
