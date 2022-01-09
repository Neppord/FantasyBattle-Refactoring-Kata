import {Target} from './Target';
import {Inventory} from './Inventory';
import {Stats} from './Stats';
import {Damage} from './Damage';
import {SimpleEnemy} from './SimpleEnemy';
import {Equipment} from './Equipment';
import {Item} from './Item';

export class Player extends Target {
    public constructor(private inventory: Inventory, private stats: Stats) {
        super();
    }

    calculateDamage(other: Target): Damage {
        const baseDamage = this.getBaseDamage();
        const damageModifier = this.getDamageModifier();
        const totalDamage = Math.round(baseDamage * damageModifier);
        const soak = this.getSoak(other, totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    private getSoak(other: Target, totalDamage: number): number {
        let soak = 0;
        if(other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (other instanceof SimpleEnemy) {
            const simpleEnemy: SimpleEnemy = other;
            soak = Math.round(simpleEnemy.armor.damageSoak *
                (simpleEnemy.buffs
                    .reduce(
                    (sum, buff) => sum + buff.soakModifier, 0)
                ) + 1
            );
        }
        return soak;
    }

    private getDamageModifier(): number {
        const equipment: Equipment = this.inventory.equipment;
        const leftHand: Item = equipment.leftHand;
        const rightHand: Item = equipment.rightHand;
        const head: Item = equipment.head;
        const feet: Item = equipment.feet;
        const chest: Item = equipment.chest;
        const strengthModifier: number = this.stats.strength * 0.1;
        return (
            strengthModifier +
            leftHand.damageModifier +
            rightHand.damageModifier +
            head.damageModifier +
            feet.damageModifier +
            chest.damageModifier
        );
    }

    private getBaseDamage() {
        const inventory: Inventory = this.inventory;
        const equipment: Equipment = inventory.equipment;
        const leftHand: Item = equipment.leftHand;
        const rightHand: Item = equipment.rightHand;
        const head: Item = equipment.head;
        const feat: Item = equipment.feet;
        const chest: Item = equipment.chest;
        return (
            leftHand.baseDamage +
            rightHand.baseDamage +
            head.baseDamage +
            feat.baseDamage +
            chest.baseDamage
        );
    }
}
