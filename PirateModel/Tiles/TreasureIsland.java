package PirateModel.Tiles;

import PirateModel.Entity;
import PirateModel.Loot;

public class TreasureIsland extends Island {

    private Loot treasure;

    public TreasureIsland() {
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
