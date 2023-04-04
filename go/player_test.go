package codingdojo

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

type (
	mockArmor             func() int32
	mockSoakModifier      func() float64
	mockDamageModifier    func() float64
	mockGetBaseDamage     func() int32
	mockGetDamageModifier func() float64

	mockBuff struct {
		mockSoakModifier
		mockDamageModifier
	}
	mockItem struct {
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

	mockItems := Items{
		leftHand: mockItem{
			mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 0 }),
			mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.4 }),
		},
		head: mockItem{
			mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 0 }),
			mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.2 }),
		},
		feet: mockItem{
			mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 0 }),
			mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 0.1 }),
		},
		chest: mockItem{
			mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 0 }),
			mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.4 }),
		},
	}

	tests := map[string]struct {
		expectedDamage int32
		armor          Armor
		buff           Buff
		equipmentItems Items
	}{
		"the right hand with flashy sword of danger": {
			expectedDamage: 41,
			armor:          armorStub,
			buff:           buffStub,
			equipmentItems: func() Items {
				mockItems.rightHand = mockItem{
					mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 10 }),
					mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.0 }),
				}
				return mockItems
			}(),
		},
		"the right hand with excalibur": {
			expectedDamage: 102,
			armor:          armorStub,
			buff:           buffStub,
			equipmentItems: func() Items {
				mockItems.rightHand = mockItem{
					mockGetBaseDamage:     mockGetBaseDamage(func() int32 { return 20 }),
					mockGetDamageModifier: mockGetDamageModifier(func() float64 { return 1.5 }),
				}
				return mockItems
			}(),
		},
	}

	for name, testCase := range tests {
		t.Run(name, func(t *testing.T) {
			equipment := MakeEquipment(
				Items{
					leftHand:  testCase.equipmentItems.leftHand,
					rightHand: testCase.equipmentItems.rightHand,
					head:      testCase.equipmentItems.head,
					feet:      testCase.equipmentItems.feet,
					chest:     testCase.equipmentItems.chest,
				},
			)
			inventory := MakeInventory(equipment)

			stats := MakeStats(0)
			target := MakeSimpleEnemy(testCase.armor, []Buff{testCase.buff})
			damage := MakePlayer(inventory, stats).CalculateDamage(target)

			assert.EqualValues(t, testCase.expectedDamage, damage.GetAmount())
		})
	}
}
