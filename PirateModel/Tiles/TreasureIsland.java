package PirateModel.Tiles;

import PirateModel.Entities.Entity;
import PirateModel.Events.Event;
import PirateModel.Loot.Loot;

public class TreasureIsland extends Island {

    private Loot treasure;

    public TreasureIsland(Event event) {
        super(event);
        this.SYMBOL = '☆';
        this.Name = "TREASURE ISLAND";
    }

    public boolean fight(Entity entity) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    public boolean takeTreasure(Entity entity) {
        throw new UnsupportedOperationException("Not implemented!");
    }
}
