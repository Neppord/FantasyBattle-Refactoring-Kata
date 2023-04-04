package codingdojo

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

type (
	mockArmor          func() int32
	mockSoakModifier   func() float64
	mockDamageModifier func() float64
	mockBuff           struct {
		mockSoakModifier
		mockDamageModifier
	}
	mockGetBaseDamage     func() int32
	mockGetDamageModifier func() float64
	mockItem              struct {
		mockGetBaseDamage
		mockGetDamageModifier
	}
)

// GetDamageSoak is a mock.
func (m mockArmor) GetDamageSoak() int32 {
	return m()
}

// SoakModifier is a mock.
func (m mockBuff) SoakModifier() float64 {
	return m.mockSoakModifier()
}

// DamageModifier is a mock.
func (m mockBuff) DamageModifier() float64 {
	return m.mockSoakModifier()
}

// GetBaseDamage is a mock.
func (m mockItem) GetBaseDamage() int32 {
	return m.mockGetBaseDamage()
}

// GetDamageModifier is a mock.
func (m mockItem) GetDamageModifier() float64 {
	return m.mockGetDamageModifier()
}

func TestDamageCalculations(t *testing.T) {
	armorStub := mockArmor(func() int32 { return 5 })
	buffStub := mockBuff{
		mockSoakModifier:   mockSoakModifier(func() float64 { return 1.0 }),
		mockDamageModifier: mockDamageModifier(func() float64 { return 1.0 }),
	}
	leftHandItem := mockItem{
		mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 0 }),
		mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.4 }),
	}
	feetItem := mockItem{
		mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 0 }),
		mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 0.1 }),
	}
	headItem := mockItem{
		mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 0 }),
		mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.2 }),
	}
	chestItem := mockItem{
		mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 0 }),
		mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.4 }),
	}

	tests := map[string]struct {
		expectedDamage int32
		armor          Armor
		buff           Buff
		equipment      struct {
			rightHand Item
			leftHand  Item
			head      Item
			feet      Item
			chest     Item
		}
	}{
		"the right hand with flashy sword of danger": {
			expectedDamage: 41,
			armor:          armorStub,
			buff:           buffStub,
			equipment: struct {
				rightHand Item
				leftHand  Item
				head      Item
				feet      Item
				chest     Item
			}{
				rightHand: mockItem{
					mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 10 }),
					mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.0 }),
				},
				leftHand: leftHandItem,
				head:     headItem,
				feet:     feetItem,
				chest:    chestItem,
			},
		},
		"the right hand with excalibur": {
			expectedDamage: 102,
			armor:          armorStub,
			buff:           buffStub,
			equipment: struct {
				rightHand Item
				leftHand  Item
				head      Item
				feet      Item
				chest     Item
			}{
				rightHand: mockItem{
					mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 20 }),
					mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.5 }),
				},
				leftHand: leftHandItem,
				head:     headItem,
				feet:     feetItem,
				chest:    chestItem,
			},
		},
	}

	for name, testCase := range tests {
		t.Run(name, func(t *testing.T) {
			equipment := MakeEquipment(
				testCase.equipment.leftHand,
				testCase.equipment.rightHand,
				testCase.equipment.head,
				testCase.equipment.feet,
				testCase.equipment.chest,
			)
			inventory := MakeInventory(equipment)

			stats := MakeStats(0)
			target := MakeSimpleEnemy(testCase.armor, []Buff{testCase.buff})
			damage := MakePlayer(inventory, stats).CalculateDamage(target)

			assert.EqualValues(t, testCase.expectedDamage, damage.GetAmount())
		})
	}
}
