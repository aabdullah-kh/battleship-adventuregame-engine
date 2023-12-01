package PirateModel.Entities;

import java.util.ArrayList;
import java.util.Random;
import java.util.SplittableRandom;

public class NPC extends Entity{
    /*
    Class NPC
    The AI for an NPC in a battle
     */
    private ArrayList<Integer> lastHit;  // keeps track of the last successful hit's coordinate
    private int turns;  // the number of turns since the last successful hit
    private String[] moves = {"N", "S", "E", "W",
                            "NE", "NW", "SE", "SW"}; // the possible moves that an NPC can make

    public void nextMove(Entity player) {
        /*
        Determines and makes a move for the NPC in combat.
         */

        // randomly decide whether to shoot or move
        Random r = new Random();
        int move = r.nextInt(2);

        // the NPC moves ship
        if (move == 0) {
            boolean made_move = this.move(moves[r.nextInt(8)]);

            while (!made_move) {
                made_move = this.move(moves[r.nextInt(8)]);
            }
        }

        // the NPC attacks
        else {

            if (lastHit.isEmpty()) {  // if the NPC has never hit the player
                int x = r.nextInt(11);
                int y = r.nextInt(11);
                boolean hit = this.getShip().shoot(player, x, y);
                if (hit) {
                    lastHit.add(x);
                    lastHit.add(y);
                    turns = 0;
                }
            }

            else {  // if the NPC hit the player n turns ago

                turns += 1;
                // gets the maximum and minimum x distance the player could have gone
                int maxX = lastHit.get(0) + turns;
                int minX = lastHit.get(0) - turns;

                // so we don't go off the grid
                if (maxX > 10) {
                    maxX = 10;
                }
                if (minX < 0) {
                    minX = 0;
                }

                // same for y
                int maxY = lastHit.get(1) + turns;
                int minY = lastHit.get(1)- turns;

                if (maxY - 10 > 0) {
                    maxY = 10;
                }
                if (minY < 0) {
                    minY = 0;
                }

                int x = r.nextInt(maxX - minX + 1) + minX;
                int y = r.nextInt(maxY - minY + 1) + minY;

                boolean hit = this.getShip().shoot(player, x, y);
                if (hit) {
                    lastHit = new ArrayList<>();
                    lastHit.add(x);
                    lastHit.add(y);
                    turns = 0;
                }
            }
        }
    }
}
