package se.computerscience.kelde.model.entities;

import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */
public class EntityPlayerKeldeTest {

    EntityPlayerKelde entityPlayerKelde;

    @Before
    public void setUp() throws Exception {
        entityPlayerKelde = new EntityPlayerKelde(new B2DWorld(), 1,1);
    }

    @Test
    public void testTakeDamage() throws Exception {
        entityPlayerKelde.setHealth(100);
        entityPlayerKelde.takeDamage(4);
        assertEquals(96, entityPlayerKelde.getHealth());
    }

    @Test
    public void testSetVelocity() throws Exception {

        entityPlayerKelde.setVelocity(10,10);
        assertEquals(true, entityPlayerKelde.isWalking());
    }

    @Test
    public void testIsWalking() throws Exception {

        entityPlayerKelde.setVelocity(10,10);
        assertEquals(true, entityPlayerKelde.isWalking());
    }

    @Test
    public void testGetPositionY() throws Exception {
        assertEquals(-31, entityPlayerKelde.getPositionX());

    }

    @Test
    public void testGetPositionX() throws Exception {
        assertEquals(-7, entityPlayerKelde.getPositionY());
    }

    @Test
    public void testSetIsShooting() throws Exception {
        entityPlayerKelde.setIsShooting(true);
        assertEquals(true, entityPlayerKelde.getIsShooting());

    }

    @Test
    public void testGetIsShooting() throws Exception {
        assertEquals(false, entityPlayerKelde.getIsShooting());
    }

    @Test
    public void testSetIsSlashing() throws Exception {
        entityPlayerKelde.setIsSlashing(true);
        assertEquals(true, entityPlayerKelde.isSlashing());
    }

    @Test
    public void testIsSlashing() throws Exception {
        assertEquals(false, entityPlayerKelde.isSlashing());
    }

    @Test
    public void testSetPosition() throws Exception {
        entityPlayerKelde.setPosition(1,1);
        assertEquals(-38, entityPlayerKelde.getPositionX()+entityPlayerKelde.getPositionY());

    }
}