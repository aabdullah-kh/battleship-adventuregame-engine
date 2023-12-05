package PirateModel.Entities;

import PirateModel.Grid;
import PirateModel.MovementMediator;
import PirateModel.Ships.Caravel;
import PirateModel.Ships.Ship;
import PirateModel.TileContainer;

import java.util.ArrayList;

public abstract class Entity {

    private String ID; //must be unique

    private Inventory inventory;

    private Ship ship;

    private MovementMediator mover;

    public Entity(String ID, MovementMediator mover) {
        this.ID = ID;
        this.mover = mover;
        this.inventory = new Inventory();
        //ship = new Caravel();
    }

    public Entity(String ID, MovementMediator mover, Inventory inventory, Ship ship) {
        this.ID = ID;
        this.mover = mover;
        this.inventory = inventory;
        this.ship = ship;
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

    public abstract void nextMove();


    public TileContainer getTileContainer() {
        return mover.getEntityTiles().get(ID);
    }

    /**
     * Shoot the NPC at the x and y coordinate.
     * Return true if the NPC has been hit and false otherwise.
     *
     * @param entity: The NPC
     * @param x:      The x-coordinate.
     * @param y:      The y-coordinate.
     * @return boolean depending on if there was a hit or not.
     */
    public boolean shoot(Entity entity, int x, int y) {
        Grid grid = entity.mover.getTileGrid().get(getTileContainer().getID());
        ArrayList<Entity> entityList = mover.getTileEntities().get(grid.getTileContainer(x, y).getID());

        if (!entityList.isEmpty()) {
            entityList.get(0).getShip().subtractHealth(ship.getDamage());
            return true;
        }
        else {
            return false;
        }

    }
}
