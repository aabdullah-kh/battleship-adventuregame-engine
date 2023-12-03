package PirateModel.Ships;

import PirateModel.Entities.Entity;

public class Ship {

    /**
     * The x-coordinate of the Ship.
     */
    private int xCoord;

    /**
     * The y-coordinate of the Ship.
     */
    private int yCoord;

    /**
     * The name of the Ship.
     */
    private String name;

    /**
     * The Ship's current health.
     */
    private int health;

    /**
     * The Ship cannons damage per shot.
     */
    private int damage;

    /**
     * Return the name of the Ship.
     * @return String representation of the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Add the Ship's health from the health argument.
     * @param health: The health to be increased from the Ship's health
     */
    public void addHealth(int health) {
        this.health += health;
    }

    /**
     * Subtract the Ship's health from the health argument.
     * @param health: The health to be decreased from the Ship's health.
     */
    public void subtractHealth(int health) {
        this.health -= health;
    }

    /**
     * Return the Ship's current health.
     * @return int representation of the Ship's health.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Return the Ship's damage per shot fired.
     * @return int representation of the Ship's damage.
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * Shoot the NPC at the x and y coordinate.
     * Return true if the NPC has been hit and false otherwise.
     * @param entity: The NPC
     * @param x: The x-coordinate.
     * @param y: The y-coordinate.
     * @return boolean depending on if there was a hit or not.
     */
    public boolean shoot(Entity entity, int x, int y) {
        Ship NPCShip = entity.getShip();

        return (NPCShip.getXCoord() == x && NPCShip.getYCoord() == y);
    }

    /**
     * Return the Ship's current x-coordinate.
     * @return int representation of the x-coordinate.
     */
    public int getXCoord() {
        return this.xCoord;
    }

    /**
     * Return the Ship's current y-coordinate.
     * @return int representation of the y-coordinate.
     */
    public int getYCoord() {
        return this.yCoord;
    }
}
