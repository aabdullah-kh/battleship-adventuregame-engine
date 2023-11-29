package PirateModel.Tiles;

import PirateModel.Entity;

public class Island extends Tile {

    private Entity npc;

    public Island() {
        this.SYMBOL = '□';
        this.Name = "ISLAND";
    }

    public void interact() {
        throw new UnsupportedOperationException("Not implemented!");
    }

    @Override
    public void onEnter(Entity entity) {

    }
}
