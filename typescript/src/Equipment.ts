import {Item} from './Item';

export class Equipment {

    // TODO add a ring item that may be equipped
    // that may also add damage modifier
    public constructor(private _leftHand: Item,
                private _rightHand: Item,
                private _head: Item,
                private _feet: Item,
                private _chest: Item) {}

    public get leftHand(): Item {
        return this._leftHand;
    }

    public get rightHand(): Item {
        return this._rightHand;
    }

    public get head(): Item {
        return this._head;
    }

    public get feet(): Item {
        return this._feet;
    }

    public get chest(): Item {
        return this._chest;
    }
}
