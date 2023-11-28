package PirateModel;

import java.util.ArrayList;

public class TileContainer {

    private ArrayList<Entity> entities;

    private Tile tile;

    /**
     * TileContainer Constructor
     * --------------------
     * Initializes TileContainer with a Terrain Tile and an empty list Entity(entities)
     * @param tile the tile which this tileContainer will contain
     */
    public TileContainer (Tile tile) {
        this.tile = tile;
        entities = new ArrayList<>();
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
     * Returns an array of Entities on the Tile
     *
     * @return An Array of Entities located on the Tile
     */
    public Entity[] getEntities () {
        return entities.toArray(new Entity[0]);
    }
}
