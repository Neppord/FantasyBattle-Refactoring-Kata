package codingdojo

type SimpleEnemy struct {
	armor Armor
	buffs []Buff
}

func MakeSimpleEnemy(armor Armor, buffs []Buff) SimpleEnemy {
	return SimpleEnemy{armor, buffs}
}

func (e SimpleEnemy) GetBuffs() []Buff {
	return e.buffs
}

func (e SimpleEnemy) GetArmor() Armor {
	return e.armor
}
