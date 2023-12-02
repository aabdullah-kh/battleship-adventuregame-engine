package PirateModel;

/**
 * Class Grid
 * Container for the game grid.
*/
public class Grid {

    private TileContainer[][] grid;


    /**
     * Grid Constructor
     * --------------------
     * Initializes grid 2D Array with Tile data
     * @param tileData 2D Array of TileContainer Objects
     */
    public Grid(TileContainer[][] tileData) {
        grid = tileData;
    }

    /**
     * Grid Alternate Constructor
     * --------------------
     * Initializes empty grid 2D Array
     * @param x The width of the grid, in Tiles
     * @param y The height of the grid, in Tiles
     */
    public Grid(int x, int y) {
        grid = new TileContainer[x][y];
    }

    /**
     * Returns a TileContainer at (x, y)
     *
     * @param x Position x of TileContainer
     * @param y Position y of TileContainer
     *
     * @return The TileContainer at position (x, y)
     */
    public TileContainer getTileContainer(int x, int y) {
        return grid[x][y];
    }

}
