package PirateModel.Tiles;

import PirateModel.Entity;

public abstract class Tile {

    protected char SYMBOL;

    protected String Name;

    public abstract void onEnter(Entity entity);
}
