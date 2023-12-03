package PirateModel.Ships;

public class Caravel extends Ship {

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

    public Caravel() {
        this.name = "Caravel";
        this.health = 100;
        this.damage = 65;
    }
}
