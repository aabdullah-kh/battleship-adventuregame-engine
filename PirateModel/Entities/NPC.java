package PirateModel.Entities;

import PirateModel.MovementMediator;
import PirateModel.Ships.Ship;
import PirateModel.TileContainer;
import PirateModel.Tiles.Tile;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
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
    private Entity player;

    public NPC(String ID, MovementMediator mover, Ship ship, Entity player) {
        super(ID, mover, new Inventory(), ship);
        this.player = player;
    }

    public void nextMove() {
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

            // get player tile xy pos
            TileContainer playerTile = player.getTileContainer();

            int x = playerTile.getXPos();
            int y = playerTile.getYPos();

            // NPC shoots relative to where the Player currently is (since Player and NPC can see each other)

            x += r.nextInt(3) - 1;
            y += r.nextInt(3) - 1;

            // CHANGE gridLength TO THE LENGTH OF THE BattleController GRID
            int grindLength = 10;

            if (x > grindLength) {
                x = 10;
            }
            if (y > grindLength) {
                y = 10;
            }
            if (x < 0) {
                x = 0;
            }

            if (y < 0) {
                y = 0;
            }

            // CHANGE THIS LINE IF SHOOT IS CHANGED
            //this.getShip().shoot(player, x, y);


//                OLD IMPLEMENTATION WITH CLASSIC BATTLESHIP IDEA (PLAYER AND NPC CANNOT SEE EACH OTHER)
//                else {
//
//            if (lastHit.isEmpty()) {  // if the NPC has never hit the player
//                int x = r.nextInt(11);
//                int y = r.nextInt(11);
//                boolean hit = this.getShip().shoot(player, x, y);
//                if (hit) {
//                    lastHit.add(x);
//                    lastHit.add(y);
//                    turns = 0;
//                }
//            } else {
//                turns += 1;
//                // gets the maximum and minimum x distance the player could have gone
//                int maxX = lastHit.get(0) + turns;
//                int minX = lastHit.get(0) - turns;
//
//                // so we don't go off the grid
//                if (maxX > 10) {
//                    maxX = 10;
//                }
//                if (minX < 0) {
//                    minX = 0;
//                }
//
//                // same for y
//                int maxY = lastHit.get(1) + turns;
//                int minY = lastHit.get(1)- turns;
//
//                if (maxY - 10 > 0) {
//                    maxY = 10;
//                }
//                if (minY < 0) {
//                    minY = 0;
//                }
//
//                int x = r.nextInt(maxX - minX + 1) + minX;
//                int y = r.nextInt(maxY - minY + 1) + minY;
//
//                boolean hit = this.getShip().shoot(player, x, y);
//                if (hit) {
//                    lastHit = new ArrayList<>();
//                    lastHit.add(x);
//                    lastHit.add(y);
//                    turns = 0;
//                }
        }
    }
}
