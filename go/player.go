package codingdojo

import "math"

type Player struct {
	inventory Inventory
	stats     Stats
}

func MakePlayer(inventory Inventory, stats Stats) Player {
	return Player{inventory, stats}
}

func (p Player) CalculateDamage(other Target) Damage {
	baseDamage := p.getBaseDamage()
	damageModifier := p.getDamageModifier()
	totalDamage := int32(math.Round(float64(baseDamage) * damageModifier))
	soak := p.getSoak(other, totalDamage)
	return MakeDamage(max(0, totalDamage-soak))
}

func max(a int32, b int32) int32 {
	if a >= b {
		return a
	}
	return b
}

func (p Player) getSoak(other Target, totalDamage int32) int32 {
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
			for _, buff := range simpleEnemy.GetBuffs() {
				sum += buff.SoakModifier()
			}
			soak = int32(math.Round(float64(simpleEnemy.GetArmor().GetDamageSoak()) * (sum + 1.0)))
		}
	}

	return soak
}

func (p Player) getDamageModifier() float64 {
	equipment := p.inventory.GetEquipment()
	leftHand := equipment.GetLeftHand()
	rightHand := equipment.GetRightHand()
	head := equipment.GetHead()
	feet := equipment.GetFeet()
	chest := equipment.GetChest()
	strengthModifier := float64(p.stats.GetStrength()) * 0.1
	return strengthModifier +
		leftHand.GetDamageModifier() +
		rightHand.GetDamageModifier() +
		head.GetDamageModifier() +
		feet.GetDamageModifier() +
		chest.GetDamageModifier()
}

func (p Player) getBaseDamage() int32 {
	equipment := p.inventory.GetEquipment()
	leftHand := equipment.GetLeftHand()
	rightHand := equipment.GetRightHand()
	head := equipment.GetHead()
	feet := equipment.GetFeet()
	chest := equipment.GetChest()
	return leftHand.GetBaseDamage() +
		rightHand.GetBaseDamage() +
		head.GetBaseDamage() +
		feet.GetBaseDamage() +
		chest.GetBaseDamage()
}
