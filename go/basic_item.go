package codingdojo

type BasicItem struct {
	name           string
	baseDamage     int32
	damageModifier float64
}

func MakeBasicItem(name string, baseDamage int32, damageModifier float64) BasicItem {
	return BasicItem{name, baseDamage, damageModifier}
}

func (i BasicItem) GetBaseDamage() int32 {
	return i.baseDamage
}

func (i BasicItem) GetDamageModifier() float64 {
	return i.damageModifier
}
