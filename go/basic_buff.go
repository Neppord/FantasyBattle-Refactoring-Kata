package codingdojo

type BasicBuff struct {
	soak   float32
	damage float32
}

func makeBasicBuff(soak float32, damage float32) BasicBuff {
	return BasicBuff{soak, damage}
}

func (this BasicBuff) soakModifier() float32 {
	return this.soak
}

func (this BasicBuff) damageModifier() float32 {
	return this.damage
}
