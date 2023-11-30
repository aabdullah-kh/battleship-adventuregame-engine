package PirateModel;

/**
 * Class Battlecontroller
 * ---------------------
 *
 */
public class BattleController {

    private Grid gridMap; // a separate grid map

    private Player player;

    private NPC[] enemies;

    public BattleController(Player player, NPC[] enemies, int x, int y) {
        this.player = player;
        this.enemies = enemies;
        this.gridMap = new Grid(x, y);
    }

    /**
     * Initiates a battle between the Player and an NPC.
     * Returns True if the Player wins, otherwise return False.
     * @return boolean - True if Player wins, False otherwise
     */
    public boolean battle() {

        // do something with the grid map


        // loop runs until either the Player or NPC dies
        while (true) {
            player.nextMove();
            enemies[0].nextMove();

            if (enemies[0].getShip().getHealth() <= 0) {
                return true;
            }

            else if (player.getShip().getHealth() <= 0) {
                return false;
            }

        }
    }

}
