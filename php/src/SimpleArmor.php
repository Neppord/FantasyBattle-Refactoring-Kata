<?php

declare(strict_types=1);

namespace App;

class SimpleArmor implements Armor
{
    private int $soak;

    public function __construct(int $soak)
    {
        $this->soak = $soak;
    }

    public function getDamageSoak(): int
    {
        return $this->soak;
    }
}