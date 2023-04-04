package codingdojo

import "math"

type Inventory struct {
	equipment Equipment
}

func MakeInventory(equipment Equipment) Inventory {
	return Inventory{equipment}
}

func max(a int32, b int32) int32 {
	if a >= b {
		return a
	}
	return b
}

func getSoak(other Target, totalDamage int32) int32 {
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

func (i Inventory) GetTotalDamage(other Target, strength int32) int32 {
	baseDamage := i.getBaseDamage()
	damageModifier := i.getDamageModifier(strength)
	totalDamage := int32(math.Round(float64(baseDamage) * damageModifier))
	soak := getSoak(other, totalDamage)

	return max(0, totalDamage-soak)
}

func (i Inventory) getDamageModifier(strength int32) float64 {
	leftHand := i.equipment.GetLeftHand()
	rightHand := i.equipment.GetRightHand()
	head := i.equipment.GetHead()
	feet := i.equipment.GetFeet()
	chest := i.equipment.GetChest()
	strengthModifier := float64(strength) * 0.1
	return strengthModifier +
		leftHand.GetDamageModifier() +
		rightHand.GetDamageModifier() +
		head.GetDamageModifier() +
		feet.GetDamageModifier() +
		chest.GetDamageModifier()
}

func (i Inventory) getBaseDamage() int32 {
	leftHand := i.equipment.GetLeftHand()
	rightHand := i.equipment.GetRightHand()
	head := i.equipment.GetHead()
	feet := i.equipment.GetFeet()
	chest := i.equipment.GetChest()

	return leftHand.GetBaseDamage() +
		rightHand.GetBaseDamage() +
		head.GetBaseDamage() +
		feet.GetBaseDamage() +
		chest.GetBaseDamage()
}
