package PirateModel;

import PirateModel.Entities.Entity;
import PirateModel.Entities.NPC;
import PirateModel.Entities.Player;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class Battlecontroller
 * ---------------------
 *
 */
public class BattleController {

    private Grid gridMap; // a separate grid map

    private Entity player;

    private ArrayList<Entity> enemies;

    private PirateGame gameController;

    public BattleController(PirateGame gameController, Entity player, ArrayList<Entity> enemies) throws IOException, ParseException {
        this.player = player;
        this.enemies = enemies;
        GameLoader gl = new GameLoader("ExampleGame");
        this.gridMap = gl.loadGrid("BattleGrid");

        gl.getMovementMediator().getTileEntities().get(1).add(player);
        gl.getMovementMediator().getEntityTiles().put(player.getID(), gl.getMovementMediator().getTileIDMap().get(1));

        enemies.remove(player);

        for (Entity enemy: enemies) {
            enemy.setMover(gl.getMovementMediator());
            gl.getMovementMediator().getTileEntities().get(2).add(enemy);
            gl.getMovementMediator().getEntityTiles().put(enemy.getID(), gl.getMovementMediator().getTileIDMap().get(2));
        }

        this.gameController = gameController;

        player.setMover(gl.getMovementMediator());

    }

    /**
     * Initiates a battle between the Player and an NPC.
     * Returns True if the Player wins, otherwise return False.
     * @return boolean - True if Player wins, False otherwise
     */
    public boolean battle() {

        while (!enemies.isEmpty()) {
            gameController.updateGridDisplay(gridMap);

            player.nextMove();

            ArrayList<Entity> deadEnemy = new ArrayList<>();

            for(int i = 0; i < enemies.size(); i++) {
                if (enemies.get(i).getShip().getHealth() <= 0) deadEnemy.add(enemies.get(i));
                else enemies.get(i).nextMove();
            }

            for (Entity enemy: deadEnemy) {
                enemies.remove(enemy);
            }

            if (player.getShip().getHealth() <= 0) return false;

        }

        player.setMover(gameController.getMovementMediator());
        return true;

    }

}
