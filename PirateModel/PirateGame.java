package PirateModel;

import PirateModel.Entities.Entity;
import PirateModel.Entities.Player;
import PirateModel.Events.EventAction;

import java.util.HashMap;
import java.util.Scanner;

public class PirateGame {

    private String directoryName;

    private Grid map;

    private Entity player;

    private MovementMediator movementMediator;

    public PirateGame(Grid map, MovementMediator movementMediator) {
        this.map = map;
        this.movementMediator = movementMediator;
        this.player = new Player("PLAYER", movementMediator);
    }

    public void gameLoop() {
        while (true) {
            player.nextMove();

            //event control
            if (player.getTileContainer().getTile().getEvent() != null) handleEvent();

            updateGridDisplay(map);
        }
    }

    public void handleEvent() {
        String eventText = player.getTileContainer().getTile().getEvent().getEventText() + "\nThe following actions are possible:\n";
        EventAction[] actionList = player.getTileContainer().getTile().getEvent().getActionTable().parseActions(player);

        HashMap<String, EventAction> actionTextMap = new HashMap<>();
        for (EventAction action: actionList) {
            eventText = eventText.concat(action.getLabel() + " ");
            actionTextMap.put(action.getLabel(), action);
        }

        displayText(eventText);

        EventAction action = null;
        while (action == null) {
            String actionInput = getInput();
            action = actionTextMap.getOrDefault(actionInput, null);
        }
        action.execute(player);

    }

    /**
     * Handles input.
     * @return inputted string.
     */
    public static String getInput() {
        //Uses scanner as temporary input reader until FX is implemented
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }   // Temporary Implementation TODO Implement for FX

    public void displayText(String text) {
        System.out.println(text);
    }   // Temporary Implementation TODO Implement for FX

    public void updateGridDisplay(Grid grid) {
        String gridD = "";
        for(int i = 0; i < grid.getSizeY(); i++) {
            for(int j = 0; j < grid.getSizeX(); j++) {
                gridD = gridD.concat(Character.toString(grid.getTileContainer(j, i).getTile().getSymbol()));
            }
            gridD = gridD.concat("\n");
        }

        System.out.println(gridD);
    }   // Temporary Implementation TODO Implement for FX

    public Grid getMap() {
        return map;
    }

}
