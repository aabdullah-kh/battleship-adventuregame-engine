import PirateModel.GameLoader;
import PirateModel.PirateGame;
import javafx.application.Application;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;
import views.PirateGameView;

import java.io.IOException;

public class Main extends Application {

    PirateGame game;
    PirateGameView pirateGameView;
    public static void main(String[] args) throws Exception {

        launch(args);
    }

    public void start(Stage stage) throws IOException, ParseException {
        GameLoader gl = new GameLoader("ExampleGame");
        game = gl.loadGame();
        this.pirateGameView = new PirateGameView(game, stage);
//        game.gameLoop();
    }

}
