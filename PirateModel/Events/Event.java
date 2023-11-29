package PirateModel.Events;

public class Event {
    // Attributes
    private String eventText;
    private ActionTable actions;

    // Constructor
    public Event(String eventText, ActionTable actions) {
        this.eventText = eventText;
        this.actions = actions;
    }

    // Public methods
    public String getEventText() {
        return this.eventText;
    }

    public ActionTable getActionTable() {
        return this.actions;
    }
}