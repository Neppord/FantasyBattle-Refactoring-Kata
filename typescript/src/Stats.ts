export class Stats {
    // TODO add dexterity that will both help with soak and damage.
    //  but half of what strength gives.
    public constructor(private _strength: number) {
    }

    public get strength(): number {
        return this._strength;
    }
}
