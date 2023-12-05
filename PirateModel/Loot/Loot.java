package PirateModel.Loot;

public abstract class Loot {

    private String name;
    private String description;
    private int value;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getValue() {
        return this.value;
    }

}
