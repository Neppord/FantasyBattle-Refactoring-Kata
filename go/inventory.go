package codingdojo

type Inventory struct {
	equipment Equipment
}

func MakeInventory(equipment Equipment) Inventory {
	return Inventory{equipment}
}

func (i Inventory) GetEquipment() Equipment {
	return i.equipment
}
