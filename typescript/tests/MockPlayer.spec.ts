// use this test if you are familiar with mocks.

import { Inventory } from '../src/Inventory';
import { Stats } from '../src/Stats';
import { SimpleEnemy } from '../src/SimpleEnemy';
import { Damage } from '../src/Damage';
import { Player } from '../src/Player';

jest.mock('../src/Inventory', () => {
    return {
        Inventory: jest.fn().mockImplementation(() => {
            return {/* TODO */}
        }),
    };
});

jest.mock('../src/Stats', () => {
    return {
        Stats: jest.fn().mockImplementation(() => {
            return {/* TODO */};
        }),
    };
});

jest.mock('../src/SimpleEnemy', () => {
    return {
        SimpleEnemy: jest.fn().mockImplementation(() => {
            return {/* TODO */};
        }),
    };
});


describe('Player', () => {
    beforeEach(() => {
        /* TODO: clear mocks */
    });
    
    it('calculates damage using mocks', () => {

        // TODO: test is not finished!

        // const damage: Damage = new Player(mockInventory, mockStats).calculateDamage(mockEnemy);
        // expect(damage.amount).toBe(10);
    });
})