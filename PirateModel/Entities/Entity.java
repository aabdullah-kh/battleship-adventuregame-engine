package PirateModel.Entities;

import PirateModel.MovementMediator;
import PirateModel.Ships.Ship;
import PirateModel.TileContainer;

public abstract class Entity {

    private String ID;

    private Inventory inventory;

    private Ship ship;

    private TileContainer currentTile;

    private MovementMediator mover;

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
        return (boolean) mover.receiveNotification(this, dir);
    }

    public abstract void nextMove();
}
