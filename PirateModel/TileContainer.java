package PirateModel;

import PirateModel.Entities.Entity;
import PirateModel.Tiles.Tile;

import java.util.ArrayList;

public class TileContainer {

    private ArrayList<Entity> entities;

    private Tile tile;

    private int x_pos;

    private int y_pos;

    private Grid grid; //the grid in which this tileContainer is located

    /**
     * TileContainer Constructor
     * --------------------
     * Initializes TileContainer with a Terrain Tile and an empty list Entity(entities)
     * @param tile the tile which this tileContainer will contain
     * @param grid the grid in which this tileContainer is located
     * @param x x-pos of this tileContainer on the Grid
     * @param y y-pos of this tileContainer on the Grid
     */
    public TileContainer (Tile tile, Grid grid, int x, int y) {
        this.tile = tile;
        entities = new ArrayList<>();
        x_pos = x;
        y_pos = y;
        this.grid = grid;
    }

    /**
     * Adds an Enity to the list of entities on the Tile
     *
     * @param entity the Entity to be added to the Tile
     */
    public void addEntity (Entity entity) {
        entities.add(entity);
    }

    /**
     * Removes an Enity from the list of entities on this Tile
     *
     * @param entity the Entity to be removed from the Tile
     */
    public void removeEntity (Entity entity) {
        entities.remove(entity);
    }

    /**
     * Moves an Entity in the specified direction on the grid.
     *
     * @param entity the Entity to be moved from the Tile
     * @param dir Can be N, NW, W, SW, S, SE, E, NE
     * @return [Whether the move was successful, new TileContainer]
     */
    public Object[] moveEntity(Entity entity, String dir){
        TileContainer targetTile;

        try {
            switch (dir) {
                case "N" -> {
                    targetTile = grid.getTileContainer(x_pos, y_pos + 1);
                }
                case "NW" -> {
                    targetTile = grid.getTileContainer(x_pos + 1, y_pos + 1);
                }
                case "W" -> {
                    targetTile = grid.getTileContainer(x_pos + 1, y_pos);
                }
                case "SW" -> {
                    targetTile = grid.getTileContainer(x_pos + 1, y_pos - 1);
                }
                case "S" -> {
                    targetTile = grid.getTileContainer(x_pos, y_pos - 1);
                }
                case "SE" -> {
                    targetTile = grid.getTileContainer(x_pos - 1, y_pos - 1);
                }
                case "E" -> {
                    targetTile = grid.getTileContainer(x_pos - 1, y_pos);
                }
                case "NE" -> {
                    targetTile = grid.getTileContainer(x_pos - 1, y_pos + 1);
                }
                default -> {
                    return new Object[] {false, null};
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return new Object[] {false, null};
        }

        if (targetTile.tile.isShipAccessible()) {
            removeEntity(entity);
            targetTile.addEntity(entity);
            return new Object[] {true, targetTile};
        }
        else {
            return new Object[] {false, null};
        }
    }

    /**
     * Returns an array of Entities on the Tile
     *
     * @return An Array of Entities located on the Tile
     */
    public Entity[] getEntities () {
        return entities.toArray(new Entity[0]);
    }
}
