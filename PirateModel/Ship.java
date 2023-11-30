package PirateModel;

import java.util.HashMap;

public class Ship {

    private int xCoord;

    private int yCoord;

    private String name;

    private int health;

    private int damage;

    public HashMap<String, Object> getStats() {
        HashMap<String, Object> stats = new HashMap<>();

        stats.put("Name", this.name);
        stats.put("Health", this.health);
        stats.put("Damage", this.damage);

        return stats;
    }

    public boolean shoot(Entity entity, int x, int y) {
        Ship NPCShip = entity.getShip();

        return (NPCShip.getXCoord() == x && NPCShip.getYCoord() == y);
    }

    public int getXCoord() {
        return this.xCoord;
    }

    public int getYCoord() {
        return this.yCoord;
    }
}
