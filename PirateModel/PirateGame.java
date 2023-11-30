package PirateModel;

import PirateModel.Entities.Entity;

import java.util.Scanner;

public class PirateGame {

    private String directoryName;

    private Grid map;

    private Entity player;

    public void setUpGame(){
        throw new UnsupportedOperationException("Not implemented!");
    }

    public void gameLoop(String input) {

    }

    /**
     * Handles input.
     * @return inputted string.
     */
    public static String getInput() {
        //Uses scanner as temporary input reader until FX is implemented
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
