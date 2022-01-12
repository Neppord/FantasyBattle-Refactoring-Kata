package codingdojo

type Stats struct {
	// TODO add dexterity that will both help with soak and damage.
	//  but half of what strength gives.
	strength int32
}

func makeStats(strength int32) Stats {
	return Stats{strength}
}

func (this Stats) getStrength() int32 {
	return this.strength
}
