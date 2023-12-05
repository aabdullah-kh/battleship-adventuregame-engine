package PirateModel.Loot;

import PirateModel.Ships.Ship;

public abstract class PowerUp {

    public PowerUp() {
        // Constructor logic if needed
    }

    // Abstract method to apply the power-up effect on a ship
    public abstract void applyEffect(Ship ship);
}

