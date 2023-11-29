package PirateModel.Events;

public class Action {
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
    public void execute(Entity entity) {
        // Implementation of the method
    }

    public String getLabel(Entity entity) {
        // Return label based on entity, if needed
        return this.label;
    }

    public Boolean getForced(Entity entity) {
        // Return forcedAction based on entity, if needed
        return this.forcedAction;
    }

    public Boolean getHidden(Entity entity) {
        // Return hidden based on entity, if needed
        return this.hidden;
    }

    // Private method
    private void changeForced() {
        this.forcedAction = !this.forcedAction;
    }
}

class Entity {
    // Implementation of Entity class
}

