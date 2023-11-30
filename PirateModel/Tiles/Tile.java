package PirateModel.Tiles;

import PirateModel.Entity;
import PirateModel.Events.Event;

public abstract class Tile {

    protected char SYMBOL;

    protected String Name;

    protected Event event;

    public Tile(char SYMBOL, String Name, Event event) {
        this.Name = Name;
        this.SYMBOL = SYMBOL;
        this.event = event;
    }

    public void onEnter(Entity entity) {
        return;
    }
}
