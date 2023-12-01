package PirateModel.Entities;

import PirateModel.PirateGame;

public class Player extends Entity{
    @Override
    public void nextMove() {
        String move = PirateGame.getInput();

        String[] command = move.split(" ");

        switch (command[0]) {
            case "MOVE" -> {
                move(command[1]);
            }
            case "FIRE" -> {

            }
            case "RETREAT" -> {

            }
            default -> {

            }
        }

    }
}
