import {Equipment} from './Equipment';

export class Inventory {
    public constructor(private _equipment: Equipment) {
    }

    public get equipment(): Equipment {
        return this._equipment;
    }
}
