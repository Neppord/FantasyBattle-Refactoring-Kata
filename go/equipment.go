package codingdojo

type (
	Equipment struct{ Items } // TODO add a ring item that may be equipped that may also add damage modifier

	Items struct {
		leftHand  Item
		rightHand Item
		head      Item
		feet      Item
		chest     Item
	}
)

func MakeEquipment(items Items) Equipment {
	return Equipment{items}
}

func (e Equipment) GetLeftHand() Item {
	return e.leftHand
}
func (e Equipment) GetRightHand() Item {
	return e.rightHand
}
func (e Equipment) GetHead() Item {
	return e.head
}
func (e Equipment) GetFeet() Item {
	return e.feet
}
func (e Equipment) GetChest() Item {
	return e.chest
}
