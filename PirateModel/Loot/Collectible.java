package PirateModel.Loot;

public abstract class Collectible extends Loot {

    private double rarity;

    // Constructor
    public Collectible(double rarity) {
        super(); // Call the default constructor of Loot
        this.rarity = rarity;
    }

    // Getter for rarity
    public double getRarity() {
        return this.rarity;
    }

}
