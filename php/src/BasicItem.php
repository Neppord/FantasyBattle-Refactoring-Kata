<?php

declare(strict_types=1);

namespace App;

class BasicItem implements Item
{
    private string $name;
    private int $baseDamage;
    private float $damageModifier;

    public function __construct(
        string $name,
        int $baseDamage,
        float $damageModifier
    ) {
        $this->name = $name;
        $this->baseDamage = $baseDamage;
        $this->damageModifier = $damageModifier;
    }

    public function getBaseDamage(): int
    {
        return $this->baseDamage;
    }

    public function getDamageModifier(): float
    {
        return $this->damageModifier;
    }
}