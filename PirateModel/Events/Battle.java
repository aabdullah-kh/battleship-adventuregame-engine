package PirateModel.Events;

import PirateModel.Entities.Entity;

public class Battle extends EventAction {
    public Battle(String label, boolean forcedAction, boolean hidden) {
        super(label, forcedAction, hidden);
    }

    @Override
    public void execute(Entity entity) {

    }
}
