<?php

declare(strict_types=1);

namespace App;

interface Armor
{
    public function getDamageSoak(): int;
}