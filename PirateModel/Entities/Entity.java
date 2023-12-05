package PirateModel.Entities;

import PirateModel.MovementMediator;
import PirateModel.Ships.Caravel;
import PirateModel.Ships.Ship;
import PirateModel.TileContainer;

public abstract class Entity {

    private String ID; //must be unique

    private Inventory inventory;

    private Ship ship;

    private MovementMediator mover;

    public Entity(String ID, MovementMediator mover) {
        this.ID = ID;
        this.mover = mover;
        inventory = new Inventory();
        //ship = new Caravel();
    }

    public Entity(String ID, MovementMediator mover, Inventory inventory, Ship ship) {
        this.ID = ID;
        this.mover = mover;
    }

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
        boolean moved = false;
        while (!moved) moved = mover.receiveNotification(this, dir);
        return true;
    }

    public abstract void nextMove();

    public TileContainer getTileContainer() {
        return mover.getEntityTiles().get(ID);
    }
}
