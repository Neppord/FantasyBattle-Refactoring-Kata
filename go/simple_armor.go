package codingdojo

type SimpleArmor struct {
	soak int32
}

func MakeSimpleArmor(soak int32) SimpleArmor {
	return SimpleArmor{soak}
}

func (a SimpleArmor) GetDamageSoak() int32 {
	return a.soak
}
