package PirateModel.Ships;

import PirateModel.Entities.Entity;

public class Ship {

    /**
     * The name of the Ship.
     */
    private final String name;

    /**
     * The Ship's current health.
     */
    private int health;

    /**
     * The Ship cannons damage per shot.
     */
    private final int damage;


    /**
     * Ship constructor.
     * __________________________
     * Initializes attributes.
     *
     * @param name:   the Ship's name.
     * @param health: the Ship's health.
     * @param damage: the Ship's damage.
     */
    public Ship(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    /**
     * Return the name of the Ship.
     *
     * @return String representation of the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Add the Ship's health from the health argument.
     *
     * @param health: The health to be increased from the Ship's health
     */
    public void addHealth(int health) {
        this.health += health;
    }

    /**
     * Subtract the Ship's health from the health argument.
     *
     * @param health: The health to be decreased from the Ship's health.
     */
    public void subtractHealth(int health) {
        this.health -= health;
    }

    /**
     * Return the Ship's current health.
     *
     * @return int representation of the Ship's health.
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Return the Ship's damage per shot fired.
     *
     * @return int representation of the Ship's damage.
     */
    public int getDamage() {
        return this.damage;
    }

}
