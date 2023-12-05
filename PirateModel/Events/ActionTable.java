package PirateModel.Events;

import PirateModel.Entities.Entity;

import java.util.ArrayList;

public class ActionTable {
    // Attribute
    private EventAction[] actions;

    // Constructor (if needed)
    public ActionTable(EventAction[] actions) {
        this.actions = actions;
    }

    /**
     * Returns action if visible
     * @return applicable actions
     */
    public EventAction[] parseActions(Entity entity) {
        
        EventAction[] actionReturn = null;

        ArrayList<EventAction> actionList = new ArrayList<>();

        for(EventAction action: actions) {
            if (!action.isHidden()) {
                actionList.add(action);
            }

            actionReturn = actionList.toArray(new EventAction[0]);
        }
        
        return actionReturn;
    }
}