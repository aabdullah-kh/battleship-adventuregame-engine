package PirateModel.Loot;

import PirateModel.Ships.Ship;

public class DamageBuffPowerUp extends PowerUp {

    private int damageBoostAmount;

    public DamageBuffPowerUp(int damageBoostAmount) {
        this.damageBoostAmount += damageBoostAmount;
    }

    @Override
    public void applyEffect(Ship ship) {
        if (ship != null) {
            ship.addDamage(damageBoostAmount);
        } else {
            throw new IllegalArgumentException("Ship is null in DamageBoostPowerUp");
        }
    }
}
