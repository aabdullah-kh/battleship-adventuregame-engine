package PirateModel.Entities;
import PirateModel.Ships.Galleon;
import PirateModel.Ships.Ship;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestNPC {
    /*
    Testing for the NPC class
     */

    @Test
    public void nextMoveBasicTest() {
        Galleon ship = new Galleon("G", 1, 1);
        Player player = new Player();
        player.changeShip(ship);
        NPC npc = new NPC();
        npc.changeShip(ship);
        // npc.nextMove(player); need to merge

    }


}
