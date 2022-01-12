package codingdojo

type BasicBuff struct {
	soak   float64
	damage float64
}

func MakeBasicBuff(soak float64, damage float64) BasicBuff {
	return BasicBuff{soak, damage}
}

func (b BasicBuff) SoakModifier() float64 {
	return b.soak
}

func (b BasicBuff) DamageModifier() float64 {
	return b.damage
}
