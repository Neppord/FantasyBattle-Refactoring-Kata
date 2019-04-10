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

            var damage = new Player(inventory.Object, stats.Object).calculateDamage(target.Object);
            Assert.AreEqual(10, damage.getAmount());
        }

        // choose this one if you are not familiar with mocks
        [TestMethod]
        [Ignore]
        public void DamageCalculations()
        {
            var inventory = new Inventory(null);
            var stats = new Stats(0);
            var target = new SimpleEnemy(null, null);
            var damage = new Player(inventory, stats).calculateDamage(target);
            Assert.AreEqual(10, damage.getAmount());
        }
}
}
