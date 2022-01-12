package codingdojo

type SimpleEnemy struct {
	// base Target
	armor Armor
	buffs []Buff
}

func makeSimpleEnemy(armor Armor, buffs []Buff) SimpleEnemy {
	return SimpleEnemy{armor, buffs}
}

func (this SimpleEnemy) getBuffs() []Buff {
	return this.buffs
}

func (this SimpleEnemy) getArmor() Armor {
	return this.armor
}
