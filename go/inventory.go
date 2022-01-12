package codingdojo

type Inventory struct {
	equipment Equipment
}

func makeInventory(equipment Equipment) Inventory {
	return Inventory{equipment}
}

func (this Inventory) getEquipment() Equipment {
	return this.equipment
}
