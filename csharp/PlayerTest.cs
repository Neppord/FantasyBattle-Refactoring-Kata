using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Moq;

namespace lod
{
    [TestClass]
    public class PlayerTest
    {
        [TestMethod]
        [Ignore]
        // choose this one if you are familiar with mocks
        public void DamageCalculationsWithMocks()
        {
            var inventory = new Mock<Inventory>();
            var stats = new Mock<Stats>();
            var target = new Mock<SimpleEnemy>();

            var damage = new Player{Inventory = inventory.Object, Stats = stats.Object}.CalculateDamage(target.Object);
            Assert.AreEqual(10, damage.Amount);
        }

        // choose this one if you are not familiar with mocks
        [TestMethod]
        [Ignore]
        public void DamageCalculations()
        {
            var inventory = new Inventory{Equipment = null};
            var stats = new Stats(){Strength = 0};
            var target = new SimpleEnemy{Armor = null, Buffs = null};
            var damage = new Player{Inventory = inventory, Stats = stats}.CalculateDamage(target);
            Assert.AreEqual(10, damage.Amount);
        }
}
}
