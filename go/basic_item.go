package codingdojo

type BasicItem struct {
	name           string
	baseDamage     int32
	damageModifier float32
}

func makeBasicItem(name string, baseDamage int32, damageModifier float32) BasicItem {
	return BasicItem{name, baseDamage, damageModifier}
}

func (this BasicItem) getBaseDamage() int32 {
	return this.baseDamage
}

func (this BasicItem) getDamageModifier() float32 {
	return this.damageModifier
}
