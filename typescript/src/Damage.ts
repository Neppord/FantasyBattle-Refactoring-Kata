export class Damage {

    constructor(private _amount: number){}

    get amount():number {
        return this._amount;
    }

    set amount(amount: number) {
        this._amount = amount;
    }
}
