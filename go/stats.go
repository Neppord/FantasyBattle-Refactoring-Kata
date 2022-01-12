package codingdojo

type Stats struct {
	// TODO add dexterity that will both help with soak and damage.
	//  but half of what strength gives.
	strength int32
}

func MakeStats(strength int32) Stats {
	return Stats{strength}
}

func (s Stats) GetStrength() int32 {
	return s.strength
}
