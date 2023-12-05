package PirateModel.Ships;

public abstract class Ship {

    protected int xCoord;

    protected int yCoord;

    protected String name;

    protected int health;

    protected int damage;

    public String getStats() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    public abstract boolean shoot(int x, int y);

    public void modifyDamage(int damageBoostAmount) {
        this.damage += damageBoostAmount;
    }

    public void modifyHealth(int healthIncrease) {
        this.health += healthIncrease;
    }

    public int getHealth() {
        return  this.health;
    }
}
