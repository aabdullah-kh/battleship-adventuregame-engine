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

    /**
     * Returns event text
     * @return Event Text
     */
    public String getEventText() {
        return this.eventText;
    }

    /**
     * Returns action table, possible actions for this event
     * @return action table
     */
    public ActionTable getActionTable() {
        return this.actions;
    }
}