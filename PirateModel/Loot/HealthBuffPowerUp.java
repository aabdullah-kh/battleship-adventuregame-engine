package PirateModel.Loot;

import PirateModel.Ships.Ship;

public class HealthBuffPowerUp extends PowerUp {

    private int healthBoostPercentage;

    public HealthBuffPowerUp(int healthBoostPercentage) {
        this.healthBoostPercentage = healthBoostPercentage;
    }

    @Override
    public void applyEffect(Ship ship) {
        if (ship != null) {
            int currentHealth = ship.getHealth();
            int healthIncrease = currentHealth * healthBoostPercentage / 100;
            ship.modifyHealth(healthIncrease);
        } else {
            throw new IllegalArgumentException("Ship is null in HealthBoostPowerUp");
        }
    }
}
