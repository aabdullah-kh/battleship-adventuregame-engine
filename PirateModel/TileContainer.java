package PirateModel;

import PirateModel.Entities.Entity;
import PirateModel.Tiles.Tile;

import java.util.ArrayList;

public class TileContainer {

    private Tile tile;

    private int ID; //will be unique when loading

    private int xPos;

    private int yPos;

    /**
     * TileContainer Constructor
     * --------------------
     * Initializes TileContainer with a Terrain Tile and an empty list Entity(entities)
     * @param tile the tile which this tileContainer will contain
     * @param x x-pos of this tileContainer on its Grid
     * @param y y-pos of this tileContainer on its Grid
     */
    public TileContainer (Tile tile, int x, int y) {
        this.tile = tile;
        xPos = x;
        yPos = y;
    }

    public int getXPos() { return xPos; }
    public int getYPos() {return yPos; }

    public Tile getTile() { return tile; }

    public int getID() { return ID; }
}
