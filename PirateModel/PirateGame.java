package PirateModel;

import PirateModel.Entities.Entity;
import PirateModel.Entities.Player;
import PirateModel.Events.EventAction;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import views.PirateGameView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PirateGame {

    private String directoryName;

    private Grid map;

    private Entity player;

    private MovementMediator movementMediator;

    public static String input;

    public PirateGameView pirateGameView;

    public PirateGame(Grid map, MovementMediator movementMediator, Entity player) {
        this.map = map;
        this.movementMediator = movementMediator;
        this.player = player;
    }

    public void gameLoop(PirateGameView pirateGameView) {
        this.pirateGameView =  pirateGameView;
        updateGridDisplay(map);
//        while (true) {
//            updateGridDisplay(map);

        // player.nextMove();

        //event control
        if (player.getTileContainer().getTile().getEvent() != null) handleEvent();
    }



    public void handleEvent() {
        String eventText = player.getTileContainer().getTile().getEvent().getEventText() + "\nThe following actions are possible:\n";
        this.pirateGameView.prompt.setText(eventText);
        EventAction[] actionList = player.getTileContainer().getTile().getEvent().getActionTable().parseActions(player);

        HashMap<String, EventAction> actionTextMap = new HashMap<>();
        for (EventAction action: actionList) {
            eventText = eventText.concat(action.getLabel() + " ");
            actionTextMap.put(action.getLabel(), action);
        }

        displayText(eventText);

        EventAction action = null;
        while (action == null) {
            String actionInput = PirateGame.input;
            action = actionTextMap.getOrDefault(actionInput, null);
            PirateGame.input = null;
        }
        action.execute(player);

    }

    public Entity getPlayer() {
        return this.player;
    }

    /**
     * Handles input.
     * @return inputted string.
     */
    public static void getInput(String input) {
        //Uses scanner as temporary input reader until FX is implemented
        PirateGame.input = input;
    }   // Temporary Implementation TODO Implement for FX

    public void displayText(String text) {
        PirateGameView.displayTextFX(text);
    }   // Temporary Implementation TODO Implement for FX

    public void updateGridDisplay(Grid grid) {
        //String gridD = "";
        for (int i = 0; i < grid.getSizeY(); i++) {
            for (int j = 0; j < grid.getSizeX(); j++) {
                //gridD = gridD.concat(Character.toString(grid.getTileContainer(j, i).getTile().getSymbol()));
                List<Integer> coordinate = new ArrayList<>();
                coordinate.add(i);
                coordinate.add(j);
                StackPane tile = this.pirateGameView.rectangleHashMap.get(coordinate);
                Text text = new Text(Character.toString(grid.getTileContainer(j, i).getTile().getSymbol()));
                tile.getChildren().remove(1);
                tile.getChildren().add(text);
            }
            //gridD = gridD.concat("\n");
        }

    }

    public Grid getMap() {
        return this.map;
    }
}
