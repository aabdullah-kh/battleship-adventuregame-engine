package PirateModel.Loot;

public abstract class UsableItem extends Loot {

    private int usesLeft;  // For consumable items

    public UsableItem(int initialUses) {
        this.usesLeft = initialUses;
    }

    // Abstract method to use the item
    public abstract void useItem();

    // Method to check if the item can be used
    public boolean canBeUsed() {
        return usesLeft > 0;
    }

    // Method to get the description or effect of the item
    public abstract String getDescription();

    // Method to check remaining uses
    public int getRemainingUses() {
        return usesLeft;
    }

    // Method to decrease the number of uses after the item is used
    protected void decrementUses() {
        if (usesLeft > 0) {
            usesLeft--;
        }
    }
}
