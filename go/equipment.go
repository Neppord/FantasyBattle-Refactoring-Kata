package codingdojo

type Equipment struct {
	// TODO add a ring item that may be equipped
	//  that may also add damage modifier
	leftHand  Item
	rightHand Item
	head      Item
	feet      Item
	chest     Item
}

func MakeEquipment(leftHand Item, rightHand Item, head Item, feet Item, chest Item) Equipment {
	return Equipment{leftHand, rightHand, head, feet, chest}
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
