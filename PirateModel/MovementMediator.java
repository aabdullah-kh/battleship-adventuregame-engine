package PirateModel;

import PirateModel.Entities.Entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Movement Mediator
 * -----------------
 * Contains Entity-TileContainer-Grid relations.
 * Accepts movement requests.
 * Completes operations necessary for movement.
 * Returns move successful/unsuccessful.
 */
public class MovementMediator {

    private HashMap<String, TileContainer> entityTiles; //Entity.ID, TileContainer
    private HashMap<Integer, ArrayList<Entity>> tileEntities; //TileContainer.ID, ArrayList<Entity>

    private HashMap<Integer, Grid> tileGrid; //TileContainer.ID, Grid

    private HashMap<Integer, TileContainer> tileIDMap;

    //temp constructor for testing purposes ONLY

    public MovementMediator() {
        entityTiles = new HashMap<>();
        tileEntities = new HashMap<>();
        tileGrid = new HashMap<>();
        tileIDMap = new HashMap<>();
    }

    public boolean receiveNotification(Entity entity, String dir) {
        TileContainer origin = entityTiles.get(entity.getID());
        TileContainer target = findTarget(origin, tileGrid.get(origin.getID()), dir);

        if (target == null) {
            return false;
        } else if (!target.getTile().isShipAccessible()) {
            return false;
        } else {
            entityTiles.put(entity.getID(), target);
            tileEntities.get(origin.getID()).remove(entity);
            tileEntities.get(target.getID()).add(entity);
            return true;
        }
    }

    private TileContainer findTarget(TileContainer tile, Grid grid, String dir){
        TileContainer targetTile;

        try {
            switch (dir) {
                case "N" -> targetTile = grid.getTileContainer(tile.getXPos(), tile.getYPos() - 1);
                case "NW" -> targetTile = grid.getTileContainer(tile.getXPos() + 1, tile.getYPos() - 1);
                case "W" -> targetTile = grid.getTileContainer(tile.getXPos() + 1, tile.getYPos());
                case "SW" -> targetTile = grid.getTileContainer(tile.getXPos() + 1, tile.getYPos() + 1);
                case "S" -> targetTile = grid.getTileContainer(tile.getXPos(), tile.getYPos() + 1);
                case "SE" -> targetTile = grid.getTileContainer(tile.getXPos() - 1, tile.getYPos() + 1);
                case "E" -> targetTile = grid.getTileContainer(tile.getXPos() - 1, tile.getYPos());
                case "NE" -> targetTile = grid.getTileContainer(tile.getXPos() - 1, tile.getYPos() - 1);
                default -> {
                    return null;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
        return targetTile;
    }

    public TileContainer getEntityTile(Entity entity) {
        return entityTiles.get(entity.getID());
    }

    public HashMap<Integer, ArrayList<Entity>> getTileEntities() {
        return tileEntities;
    }

    public HashMap<Integer, Grid> getTileGrid() {
        return tileGrid;
    }

    public HashMap<String, TileContainer> getEntityTiles() {
        return entityTiles;
    }

    public HashMap<Integer, TileContainer> getTileIDMap() { return tileIDMap; }
}
