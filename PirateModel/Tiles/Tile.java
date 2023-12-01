package PirateModel.Tiles;

import PirateModel.Entities.Entity;
import PirateModel.Events.Event;

public abstract class Tile {

    protected char SYMBOL;

    protected String Name;

    protected Event event;

    protected boolean shipAccessible;

    public Tile(char SYMBOL, String Name, Event event) {
        this.Name = Name;
        this.SYMBOL = SYMBOL;
        this.event = event;
        shipAccessible = true;
    }

    public void onEnter(Entity entity) {
    }

    public boolean isShipAccessible() {
        return shipAccessible;
    }
}
