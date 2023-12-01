package PirateModel.Entities;

import PirateModel.Ships.Ship;
import PirateModel.TileContainer;

public abstract class Entity {

    private String ID;

    private Inventory inventory;

    private Ship ship;

    private TileContainer currentTile;

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

    public boolean move(String dir) {
        return (boolean) currentTile.moveEntity(this, dir)[0];
    }

    public abstract void nextMove();
}
