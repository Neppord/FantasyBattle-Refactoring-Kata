import {Item} from './Item';

export class BasicItem implements Item {

    public constructor(private name: string,
                       private _baseDamage: number,
                       private _damageModifier: number) {
    }

    public get baseDamage(): number {
        return this._baseDamage;
    }

    public get damageModifier(): number {
        return this._damageModifier;
    }
}
