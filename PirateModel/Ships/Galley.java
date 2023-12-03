package PirateModel.Ships;

public class Galley extends Ship {

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

    public Galley() {
        this.name = "Galley";
        this.health = 125;
        this.damage = 80;
    }
}
