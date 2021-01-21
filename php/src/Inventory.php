<?php

declare(strict_types=1);

namespace App;

class Inventory
{
    private Equipment $equipment;

    public function __construct(Equipment $equipment)
    {
        $this->equipment = $equipment;
    }

    public function getEquipment(): Equipment
    {
        return $this->equipment;
    }
}