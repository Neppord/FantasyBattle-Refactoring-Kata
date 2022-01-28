export class Damage {

    constructor(private _amount: number) { }

    public get amount(): number {
        return this._amount;
    }

    public set amount(amount: number) {
        this._amount = amount;
    }
}
