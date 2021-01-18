<?php

namespace App;

use Mockery;
use PHPUnit\Framework\TestCase;

class PlayerTest extends TestCase
{
    public function test_damage_calculation_with_mocks()
    {
        $inventory = Mockery::mock(Inventory::class);
        $stats = Mockery::mock(Stats::class);
        $target = Mockery::mock(SimpleEnemy::class);

        $damage = (new Player($inventory, $stats))->calculateDamage($target);

        $this->assertEquals(10, $damage->getAmount());
    }

    // choose this one if you are not familiar with mocks
    public function test_damage_calculation()
    {
        $inventory = new Inventory(null);
        $stats = new Stats(0);
        $target = new SimpleEnemy(null, null);
        $damage = (new Player($inventory, $stats))->calculateDamage($target);

        $this->assertEquals(10, $damage->getAmount());
    }

}
