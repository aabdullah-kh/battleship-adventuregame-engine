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
        int move = r.nextInt(3);

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

            int certainHit = r.nextInt(2);
            if (certainHit == 0) {
                x += r.nextInt(3) - 1;
                y += r.nextInt(3) - 1;
            }

            // CHANGE gridLength TO THE LENGTH OF THE BattleController GRID
            shoot(x, y);
        }
    }
}
