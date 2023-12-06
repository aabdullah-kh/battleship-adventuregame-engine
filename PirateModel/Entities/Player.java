package PirateModel.Entities;

import PirateModel.Accessibility.TextToSpeech;
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
        boolean command_valid = false;
        while (!command_valid) {
            String move = PirateGame.getInput();
            TextToSpeech tts = new TextToSpeech();

            String[] command = move.split(" ");

            switch (command[0]) {
                case "MOVE" -> {
                    command_valid = move(command[1]);

                    if (command_valid) {
                        tts.speak("You moved!");
                    } else {
                        tts.speak("Invalid command!");
                    }

                }
                case "SHOOT" -> {
                    boolean shoot = shoot(Integer.parseInt(command[1]), Integer.parseInt(command[2]));
                    command_valid = true;

                    if (shoot) {
                        tts.speak("You hit the enemy!");

                    } else {
                        tts.speak("You missed!");
                    }

                }
                case "WAIT" -> {
                    command_valid = true;
                }
                default -> {

                }
            }
        }

    }
}
