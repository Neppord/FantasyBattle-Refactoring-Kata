import { Inventory } from '../src/Inventory';
import { Stats } from '../src/Stats';
import { SimpleEnemy } from '../src/SimpleEnemy';
import { Player } from '../src/Player';
import { Damage } from '../src/Damage';

describe('Player', () => {
    it('calculates Damage using mocks', () => {
        const inventory = mock(Inventory);
        const stats = mock(Stats);
        const enemy = mock(SimpleEnemy);

        const damage: Damage = new Player(inventory, stats).calculateDamage(enemy);
        expect(damage.amount.toBe())
    });

    it('calculates Damage without mocks', () => {
        const inventory = new Inventory(null);
        const stats = new Stats(0);
        const enemy = new SimpleEnemy(null, null);

        const damage: Damage = new Player(inventory, stats).calculateDamage(enemy);
        expect(damage.amount.toBe())
    });
})