package codingdojo

type Equipment struct {
	// TODO add a ring item that may be equipped
	// that may also add damage modifier
	leftHand  Item
	rightHand Item
	head      Item
	feet      Item
	chest     Item
}

func makeEquipment(leftHand Item, rightHand Item, head Item, feet Item, chest Item) Equipment {
	return Equipment{leftHand, rightHand, head, feet, chest}
}

func (this Equipment) getLeftHand() Item {
	return this.leftHand
}
func (this Equipment) getRightHand() Item {
	return this.rightHand
}
func (this Equipment) getHead() Item {
	return this.head
}
func (this Equipment) getFeet() Item {
	return this.feet
}
func (this Equipment) getChest() Item {
	return this.chest
}
