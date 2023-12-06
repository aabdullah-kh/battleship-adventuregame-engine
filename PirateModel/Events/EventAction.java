package PirateModel.Events;

import PirateModel.Entities.Entity;
import PirateModel.PirateGame;
import PirateModel.TileContainer;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public abstract class EventAction {
    // Attributes
    private String label;

    private boolean forcedAction;

    private boolean hidden;

    protected PirateGame gameController;

    protected TileContainer tileContainer;

    // Constructor (optional, depending on your needs)
    public EventAction(String label, boolean forcedAction, boolean hidden, PirateGame gameController) {
        this.label = label;
        this.forcedAction = forcedAction;
        this.hidden = hidden;
        this.gameController = gameController;
        this.tileContainer = tileContainer;
    }

    // Public methods
    public abstract void execute(Entity entity) throws IOException, ParseException;

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

