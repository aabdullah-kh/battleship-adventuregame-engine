package PirateModel.Entities;

import PirateModel.MovementMediator;
import PirateModel.Ships.Caravel;
import PirateModel.Ships.Ship;
import PirateModel.TileContainer;

public abstract class Entity {

    private String ID; //must be unique

    private Inventory inventory;

    private Ship ship;

    private TileContainer currentTile;

    private MovementMediator mover;

    public Entity(String ID, TileContainer currentTile, MovementMediator mover) {
        this.ID = ID;
        this.currentTile = currentTile;
        this.mover = mover;
        inventory = new Inventory();
        //ship = new Caravel();
    }

    public Entity(String ID, TileContainer currentTile, MovementMediator mover, Inventory inventory, Ship ship) {
        this.ID = ID;
        this.currentTile = currentTile;
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
        this.ship = ship;
        return true;
    }

    public boolean move(String dir) {
        return (boolean) mover.receiveNotification(this, dir);
    }

    public abstract void nextMove(Entity entity);
}
