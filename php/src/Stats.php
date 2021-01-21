<?php

declare(strict_types=1);

namespace App;

class Stats
{
    // TODO add dexterity that will both help with soak and damage.
    //  but half of what strength gives.
    private int $strength;

    public function __construct(int $strength)
    {
        $this->strength = $strength;
    }

    public function getStrength(): int
    {
        return $this->strength;
    }
}