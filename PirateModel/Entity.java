package PirateModel;

public class Entity {

    private String ID;

    private Inventory inventory;

    private Ship ship;

    public String getID() {
        return this.ID;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public Ship getShip() {
        return this.ship;
    }

    public boolean changeShip(Ship ship) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    public boolean move(String position) {
        throw new UnsupportedOperationException("Not implemented!");
    }
}
