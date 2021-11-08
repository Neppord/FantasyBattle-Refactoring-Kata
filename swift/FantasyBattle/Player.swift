struct Player: Target {
    let inventory: Inventory, stats: Stats
    init(inventory: Inventory, stats: Stats) {
        self.inventory = inventory
        self.stats = stats
    }
    
    func calculateDamage(other: Target) -> Damage {
        let baseDamage = getBaseDamage()
        let damageModifier = getDamageModifier()
        let totalDamage = baseDamage * damageModifier
        let soak = getSoak(other: other, totalDamage: totalDamage)
        return Damage(amount: max(0, totalDamage - soak))
    }
    
    func getBaseDamage() -> Double {
        let equipment = inventory.equipment
        let leftHand = equipment.leftHand
        let rightHand = equipment.rightHand
        let head = equipment.head
        let feet = equipment.feet
        let chest = equipment.chest
        return leftHand.getBaseDamage() +
                rightHand.getBaseDamage() +
                head.getBaseDamage() +
                feet.getBaseDamage() +
                chest.getBaseDamage()
    }
    
    func getDamageModifier() -> Double {
        let equipment = inventory.equipment
        let leftHand = equipment.leftHand
        let rightHand = equipment.rightHand
        let head = equipment.head
        let feet = equipment.feet
        let chest = equipment.chest
        let strengthModifier = stats.strength * 0.1
        return strengthModifier +
                leftHand.getDamageModifier() +
                rightHand.getDamageModifier() +
                head.getDamageModifier() +
                feet.getDamageModifier() +
                chest.getDamageModifier()
    }
    
    func getSoak(other: Target, totalDamage: Double) -> Double {
        var soak = 0.0
        if let player = other as? Player {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage
        } else if let simpleEnemy = other as? SimpleEnemy {
            soak =
                simpleEnemy.getArmor().getDamageSoak() *
                simpleEnemy.getBuffs().map {$0.soakModifier()}.reduce(1, +)
        }
        return soak
    }
    
}
