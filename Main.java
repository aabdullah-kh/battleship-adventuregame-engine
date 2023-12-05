import PirateModel.GameLoader;
import PirateModel.PirateGame;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, ParseException {
        GameLoader gl = new GameLoader("ExampleGame");
        PirateGame game = gl.loadGame();
        game.gameLoop();
    }

}
