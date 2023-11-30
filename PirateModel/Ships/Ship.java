package PirateModel.Ships;

import PirateModel.Entities.Entity;

public class Ship {

    private int xCoord;

    private int yCoord;

    private String name;

    private int health;

    private int damage;

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public boolean shoot(Entity entity, int x, int y) {
        Ship NPCShip = entity.getShip();

        return (NPCShip.getXCoord() == x && NPCShip.getYCoord() == y);
    }

    public int getXCoord() {
        return this.xCoord;
    }

    public int getYCoord() {
        return this.yCoord;
    }
}
