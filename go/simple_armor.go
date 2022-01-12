package codingdojo

type SimpleArmor struct {
	soak int32
}

func makeSimpleArmor(soak int32) SimpleArmor {
	return SimpleArmor{soak}
}

func (this SimpleArmor) getDamageSoak() int32 {
	return this.soak
}
