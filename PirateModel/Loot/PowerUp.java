package PirateModel.Loot;

public abstract class PowerUp extends UsableItem {

    // Additional fields specific to PowerUp, if any
    // Example: private int powerLevel;

    public PowerUp(String name, String description, int value) {
        super(value);
    }

    @Override
    public abstract void useItem();
}
