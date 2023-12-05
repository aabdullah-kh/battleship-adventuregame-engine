package PirateModel.Entities;

import PirateModel.Accessibility.TextToSpeech;
import PirateModel.MovementMediator;
import PirateModel.PirateGame;
import PirateModel.Ships.Ship;
import PirateModel.TileContainer;

import java.util.ArrayList;

public class Player extends Entity{

    public ArrayList<Entity> enemies;

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

            String[] command = move.split(" ");

            TextToSpeech tts = new TextToSpeech();

            switch (command[0]) {
                case "MOVE" -> {
                    command_valid = move(command[1]);
                    if (command_valid) {
                        tts.speak("You moved!");
                    } else {
                        tts.speak("Invalid command!");
                    }
                }
                case "FIRE" -> {
                    if (enemies.isEmpty()) {
                        tts.speak("No enemies on board!");
                    }

                    // in BattleController, add line for changing the Player.enemies attribute

                    boolean shoot = this.shoot(enemies.get(0), Integer.parseInt(command[1]), Integer.parseInt(command[2]));

                    if (shoot) {
                        tts.speak("You hit the enemy!");

                    } else {
                        tts.speak("You missed!");
                    }

                }
                case "RETREAT" -> {

                }
            }
        }

    }
}
