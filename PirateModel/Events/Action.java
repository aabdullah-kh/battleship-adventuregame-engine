package PirateModel.Events;

import PirateModel.Entity;

public abstract class Action {
    // Attributes
    private String label;
    private boolean forcedAction;
    private boolean hidden;

    // Constructor (optional, depending on your needs)
    public Action(String label, boolean forcedAction, boolean hidden) {
        this.label = label;
        this.forcedAction = forcedAction;
        this.hidden = hidden;
    }

    // Public methods
    public abstract void execute(Entity entity);

    public String getLabel() {
        // Return label based on entity, if needed
        return this.label;
    }

    public Boolean isForced() {
        // Return forcedAction based on entity, if needed
        return this.forcedAction;
    }

    public Boolean isHidden() {
        // Return hidden based on entity, if needed
        return this.hidden;
    }

    // Private method
    private void changeForced() {
        this.forcedAction = !this.forcedAction;
    }
}

