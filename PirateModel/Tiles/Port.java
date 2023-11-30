package PirateModel.Tiles;

import PirateModel.Entity;
import PirateModel.Events.Event;
import PirateModel.Inventory;
import PirateModel.Ship;

import java.util.HashMap;

public class Port extends Island {

    protected HashMap<String, Ship> upgradeShop;

    public Port(Event event) {
        super(event);
        this.Name = "PORT";
        this.SYMBOL = '#';
    }

}
