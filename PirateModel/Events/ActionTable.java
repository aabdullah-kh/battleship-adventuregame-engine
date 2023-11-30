package PirateModel.Events;

import PirateModel.Entity;

import java.util.ArrayList;

public class ActionTable {
    // Attribute
    private Action[] actions;

    // Constructor (if needed)
    public ActionTable(Action[] actions) {
        this.actions = actions;
    }

    /**
     * Returns action if visible and executes them if forced
     * @return
     */
    public Action[] parseActions(Entity entity) {
        
        Action[] actionReturn = null;

        for(Action action: actions) {
            ArrayList<Action> actionList = new ArrayList<>();
            if (action.isForced()) {
                action.execute(entity);
            }
            if (!action.isHidden()) {
                actionList.add(action);
            }

            actionReturn = actionList.toArray(new Action[0]);
        }
        
        return actionReturn;
    }
}