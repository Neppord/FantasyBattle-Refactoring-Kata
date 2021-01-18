<?php

declare(strict_types=1);

namespace App;

class Equipment
{
    // TODO add a ring item that may be equipped
    //  that may also add damage modifier
    private Item $leftHand;
    private Item $rightHand;
    private Item $head;
    private Item $feet;
    private Item $chest;

    public function __construct(
        Item $leftHand,
        Item $rightHand,
        Item $head,
        Item $feet,
        Item $chest
    ) {
        $this->leftHand = $leftHand;
        $this->rightHand = $rightHand;
        $this->head = $head;
        $this->feet = $feet;
        $this->chest = $chest;
    }

    public function getLeftHand(): Item
    {
        return $this->leftHand;
    }

    public function getRightHand(): Item
    {
        return $this->rightHand;
    }

    public function getHead(): Item
    {
        return $this->head;
    }

    public function getFeet(): Item
    {
        return $this->feet;
    }

    public function getChest(): Item
    {
        return $this->chest;
    }
}