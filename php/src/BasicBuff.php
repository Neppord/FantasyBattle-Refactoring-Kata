<?php

declare(strict_types=1);

namespace App;

class BasicBuff implements Buff
{
    private float $soak;
    private float $damage;

    public function __construct(float $soak, float $damage)
    {
        $this->soak = $soak;
        $this->damage = $damage;
    }

    public function soakModifier(): float
    {
        return $this->soak;
    }

    public function damageModifier(): float
    {
        return $this->damage;
    }
}