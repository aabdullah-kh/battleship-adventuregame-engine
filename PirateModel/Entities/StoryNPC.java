package PirateModel.Entities;

import PirateModel.MovementMediator;
import PirateModel.Ships.Ship;
import PirateModel.TileContainer;

public class StoryNPC extends NPC {
    /*
    class StoryNPC
    An NPC that progresses the story
     */

    public StoryNPC(String ID, TileContainer currentTile, MovementMediator mover, Ship ship, Entity player)  {
        super(ID, currentTile, mover, ship, player);
    }
}
