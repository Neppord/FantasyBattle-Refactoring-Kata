package codingdojo

type Damage struct {
	amount int32
}

func makeDamage(amount int32) Damage {
	return Damage{amount}
}

func (this *Damage) getAmount() int32 {
	return this.amount
}

func (this *Damage) setAmount(amount int32) {
	this.amount = amount
}
