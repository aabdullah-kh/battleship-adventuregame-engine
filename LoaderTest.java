import PirateModel.GameLoader;
import PirateModel.Grid;
import PirateModel.PirateGame;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class LoaderTest {

    @Test
    void loadGridTest() throws IOException, ParseException {
        GameLoader gl = new GameLoader("ExampleGame");
        Grid grid = gl.loadGrid("MainGrid");
        assertEquals("ISLAND", grid.getTileContainer(0, 0).getTile().getName());
        assertEquals("PORT", grid.getTileContainer(0, 1).getTile().getName());
        assertEquals(2, grid.getTileContainer(3, 3).getID());
    }

    @Test
    void loadEntitiesTest() throws IOException, ParseException {
        GameLoader gl = new GameLoader("ExampleGame");
        PirateGame game = gl.loadGame();
        assertEquals(1, gl.getMovementMediator().getTileEntities().get(game.getMap().getTileContainer(3, 3).getID()).size());
    }
}
