<?php

declare(strict_types=1);

namespace App;

class SimpleEnemy extends Target
{
    private Armor $armor;

    /**
     * @var array<Buff>
     */
    private array $buffs;

    /**
     * SimpleEnemy constructor.
     * @param Armor $armor
     * @param array<Buff> $buffs
     */
    public function __construct(Armor $armor, array $buffs)
    {
        $this->armor = $armor;
        $this->buffs = $buffs;
    }

    public function getArmor(): Armor
    {
        return $this->armor;
    }

    /**
     * @return array<Buff>
     */
    public function getBuffs(): array
    {
        return $this->buffs;
    }


}