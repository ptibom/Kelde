package se.computerscience.kelde.model.entities;

import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.constants.Direction;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */


public class EntityPlayerTest {

    public EntityPlayer entityPlayer;


    @Before
    public void setUp() throws Exception {
        entityPlayer = new EntityPlayer();

    }

    @Test
    public void testGetHealth() throws Exception {
        assertEquals(100, entityPlayer.getHealth());

    }

    @Test
    public void testGetMana() throws Exception {
        assertEquals(100, entityPlayer.getMana());
    }

    @Test
    public void testGetStrength() throws Exception {

        assertEquals(10, entityPlayer.getStrength());
    }

    @Test
    public void testGetMagic() throws Exception {

        assertEquals(10, entityPlayer.getMagic());
    }

    @Test
    public void testSetHealth() throws Exception {

        entityPlayer.setHealth(115);
        assertEquals(115, entityPlayer.getHealth());
    }

    @Test
    public void testSetMana() throws Exception {
        entityPlayer.setMana(120);
        assertEquals(120, entityPlayer.getMana());
    }

    @Test
    public void testSetStrength() throws Exception {
        entityPlayer.setStrength(12);
        assertEquals(12, entityPlayer.getStrength());
    }

    @Test
    public void testSetMagic() throws Exception {
        entityPlayer.setMagic(42);
        assertEquals(42, entityPlayer.getMagic());
    }

    @Test
    public void testGetDirection() throws Exception {
        assertEquals(Direction.SOUTH, entityPlayer.getDirection());
    }

    @Test
    public void testSetDirection() throws Exception {
        entityPlayer.setDirection(Direction.WEST);
        assertEquals(Direction.WEST, entityPlayer.getDirection());

    }
}