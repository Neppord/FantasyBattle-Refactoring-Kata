package codingdojo

import "math"

type Player struct {
	// base Target
	inventory Inventory
	stats     Stats
}

func makePlayer(inventory Inventory, stats Stats) Player {
	return Player{inventory, stats}
}

func (this Player) calculateDamage(other Target) Damage {
	baseDamage := this.getBaseDamage()
	damageModifier := this.getDamageModifier()
	totalDamage := int32(math.Round(float64(baseDamage) * damageModifier))
	soak := this.getSoak(other, totalDamage)
	return makeDamage(Max(0, totalDamage-soak))
}

func Max(a int32, b int32) int32 {
	if a >= b {
		return a
	}
	return b
}

func (this Player) getSoak(other Target, totalDamage int32) int32 {
	soak := int32(0)

	_, ok := other.(Player)
	if ok {
		// TODO: Not implemented yet
		// Add friendly fire
		soak = totalDamage
	} else {
		simpleEnemy, ok := other.(SimpleEnemy)
		if ok {
			sum := 0.0
			for _, buff := range simpleEnemy.getBuffs() {
				sum += buff.soakModifier()
			}
			soak = int32(math.Round(float64(simpleEnemy.getArmor().getDamageSoak()) * (sum + 1.0)))
		}
	}

	return soak
}

func (this Player) getDamageModifier() float64 {
	equipment := this.inventory.getEquipment()
	leftHand := equipment.getLeftHand()
	rightHand := equipment.getRightHand()
	head := equipment.getHead()
	feet := equipment.getFeet()
	chest := equipment.getChest()
	strengthModifier := float64(this.stats.getStrength()) * 0.1
	return strengthModifier +
		leftHand.getDamageModifier() +
		rightHand.getDamageModifier() +
		head.getDamageModifier() +
		feet.getDamageModifier() +
		chest.getDamageModifier()
}

func (this Player) getBaseDamage() int32 {
	equipment := this.inventory.getEquipment()
	leftHand := equipment.getLeftHand()
	rightHand := equipment.getRightHand()
	head := equipment.getHead()
	feet := equipment.getFeet()
	chest := equipment.getChest()
	return leftHand.getBaseDamage() +
		rightHand.getBaseDamage() +
		head.getBaseDamage() +
		feet.getBaseDamage() +
		chest.getBaseDamage()
}
