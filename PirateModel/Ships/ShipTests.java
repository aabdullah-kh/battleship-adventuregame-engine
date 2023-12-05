package PirateModel.Ships;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShipTests {

    @Test
    void caravelTest() {
        Ship caravel = new Caravel();
        assertEquals("CARAVEL", caravel.getName());
        assertEquals(100, caravel.getHealth());
        assertEquals(65, caravel.getDamage());

        caravel.subtractHealth(25);
        assertEquals(75, caravel.getHealth());
        caravel.addHealth(25);
        assertEquals(100, caravel.getHealth());
    }

    @Test
    void galleyTest() {
        Ship galley = new Galley();
        assertEquals("GALLEY", galley.getName());
        assertEquals(125, galley.getHealth());
        assertEquals(80, galley.getDamage());

        galley.subtractHealth(25);
        assertEquals(100, galley.getHealth());
        galley.addHealth(25);
        assertEquals(125, galley.getHealth());
    }

    @Test
    void barqueTest() {
        Ship barque = new Barque();
        assertEquals("BARQUE", barque.getName());
        assertEquals(180, barque.getHealth());
        assertEquals(110, barque.getDamage());

        barque.subtractHealth(25);
        assertEquals(155, barque.getHealth());
        barque.addHealth(25);
        assertEquals(180, barque.getHealth());
    }

    @Test
    void galleonTest() {
        Ship galleon = new Galleon();
        assertEquals("GALLEON", galleon.getName());
        assertEquals(245, galleon.getHealth());
        assertEquals(155, galleon.getDamage());

        galleon.subtractHealth(25);
        assertEquals(220, galleon.getHealth());
        galleon.addHealth(25);
        assertEquals(245, galleon.getHealth());
    }

}
