<?php

declare(strict_types=1);

namespace App;

class Player extends Target
{
    private Inventory $inventory;
    private Stats $stats;

    public function __construct(Inventory $inventory, Stats $stats)
    {
        $this->inventory = $inventory;
        $this->stats = $stats;
    }

    public function calculateDamage(Target $other): Damage
    {
        $baseDamage = $this->getBaseDamage();
        $damageModifier = $this->getDamageModifier();
        $totalDamage = intval(round($baseDamage * $damageModifier));
        $soak = $this->getSoak($other, $totalDamage);

        return new Damage(intval(max(0, $totalDamage - $soak)));
    }

    private function getBaseDamage(): int
    {
        $equipment = $this->inventory->getEquipment();
        $leftHand = $equipment->getLeftHand();
        $rightHand = $equipment->getRightHand();
        $head = $equipment->getHead();
        $feet = $equipment->getFeet();
        $chest = $equipment->getChest();

        return $leftHand->getBaseDamage() +
            $rightHand->getBaseDamage() +
            $head->getBaseDamage() +
            $feet->getBaseDamage() +
            $chest->getBaseDamage();
    }

    private function getDamageModifier(): float
    {
        $equipment = $this->inventory->getEquipment();
        $leftHand = $equipment->getLeftHand();
        $rightHand = $equipment->getRightHand();
        $head = $equipment->getHead();
        $feet = $equipment->getFeet();
        $chest = $equipment->getChest();
        $strengthModifier = $this->stats->getStrength() * 0.1;

        return $strengthModifier +
            $leftHand->getDamageModifier() +
            $rightHand->getDamageModifier() +
            $head->getDamageModifier() +
            $feet->getDamageModifier() +
            $chest->getDamageModifier();
    }

    private function getSoak(Target $other, int $totalDamage): int
    {
        $soak = 0;
        if ($other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            $soak = $totalDamage;
        } else {
            if ($other instanceof SimpleEnemy) {
                $simpleEnemy = $other;
                $soak = round(
                    $simpleEnemy->getArmor()->getDamageSoak() *
                    array_reduce(
                        $simpleEnemy->getBuffs(),
                        fn(float $acc, Buff $buff) => $acc + $buff->soakModifier(),
                        1
                    )
                );
            }
        }

        return intval($soak);
    }
}
