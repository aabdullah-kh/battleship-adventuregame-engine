package PirateModel.Events;

public class ActionTable {
    // Attribute
    private Action[] actions;

    // Constructor (if needed)
    public ActionTable(Action[] actions) {
        this.actions = actions;
    }

    // Public method
    public Action[] parseActions() {
        // Implementation to parse actions
        return this.actions;
    }
}