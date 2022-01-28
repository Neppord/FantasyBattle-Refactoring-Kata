package codingdojo

type Damage struct {
	amount int32
}

func MakeDamage(amount int32) Damage {
	return Damage{amount}
}

func (d *Damage) GetAmount() int32 {
	return d.amount
}

func (d *Damage) SetAmount(amount int32) {
	d.amount = amount
}
