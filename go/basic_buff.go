package codingdojo

type BasicBuff struct {
	soak   float64
	damage float64
}

func makeBasicBuff(soak float64, damage float64) BasicBuff {
	return BasicBuff{soak, damage}
}

func (this BasicBuff) soakModifier() float64 {
	return this.soak
}

func (this BasicBuff) damageModifier() float64 {
	return this.damage
}
