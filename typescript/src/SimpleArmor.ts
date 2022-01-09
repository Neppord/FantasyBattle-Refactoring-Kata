import {Armor} from './Armor';

export class SimpleArmor implements Armor {
    public constructor(private _soak: number){
    }

    public get damageSoak(): number {
        return this._soak;
    }
}
