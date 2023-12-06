package PirateModel.Events;

import PirateModel.BattleController;
import PirateModel.Entities.Entity;
import PirateModel.PirateGame;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Battle extends EventAction {


    public Battle(String label, boolean forcedAction, boolean hidden, PirateGame gameController) {
        super(label, forcedAction, hidden, gameController);
    }

    @Override
    public void execute(Entity entity) throws IOException, ParseException {
        BattleController bc = new BattleController(this.gameController, this.gameController.getPlayer(), this.gameController.getPlayer().getMover().getTileEntities().get(this.gameController.getPlayer().getTileContainer().getID()));
        if (!bc.battle()) {
            this.gameController.gameOver();
        }
    }
}
