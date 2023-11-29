package PirateModel;

public class Caravel extends Ship {

    private int xCoord;

    private int yCoord;

    private final String name;

    private final int health;

    private final int damage;

    public Caravel(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }
}
