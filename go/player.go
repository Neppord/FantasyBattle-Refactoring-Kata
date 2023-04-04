package codingdojo

type Player struct {
	inventory Inventory
	stats     Stats
}

func MakePlayer(inventory Inventory, stats Stats) Player {
	return Player{inventory, stats}
}

func (p Player) CalculateDamage(other Target) Damage {
	return MakeDamage(p.inventory.GetTotalDamage(other, p.stats.GetStrength()))
}
