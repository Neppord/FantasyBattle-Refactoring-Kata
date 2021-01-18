<?php


namespace App;


interface Item
{
    public function getBaseDamage(): int;

    public function getDamageModifier(): float;
}