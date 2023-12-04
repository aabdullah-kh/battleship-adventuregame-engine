package PirateModel.Entities;

import PirateModel.MovementMediator;
import PirateModel.PirateGame;
import PirateModel.Ships.Ship;
import PirateModel.TileContainer;

public class Player extends Entity{


    public Player(String ID, MovementMediator mover) {
        super(ID, mover);
    }

    public Player(String ID, MovementMediator mover, Inventory inventory, Ship ship) {
        super(ID, mover, inventory, ship);
    }

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
