package PirateModel;

public class BattleController {
    /*
    Class BattleController

     */
    private Grid gridMap; // a separate grid map

    private Player player;

    private NPC[] enemies;

    public BattleController(Player player, NPC[] enemies, int x, int y) {
        this.player = player;
        this.enemies = enemies;
        this.gridMap = new Grid(x, y);
    }

    public boolean battle() {
        /*
        Initiates a battle between the Player and an NPC.
        Returns True if the Player wins, otherwise return False.
         */

        // do something with the grid map


        // loop runs until either the Player or NPC dies
        while (true) {
            player.nextMove();
            enemies[0].nextMove();

            if (enemies[0].getShip().getStats().get("Health") <= 0) {
                return true;
            }

            else if (player.getShip().getStats().get("Health") <= 0) {
                return false;
            }

        }
    }

}
