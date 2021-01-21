<?php

declare(strict_types=1);

namespace App;

interface Buff
{
    public function soakModifier(): float;

    public function damageModifier(): float;

}