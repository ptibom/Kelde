package se.computerscience.kelde.model.entities;

import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */

public class EntitySmallWormTest {

   private  EntitySmallWorm smallWormTest;

    @Before
    public void setUp() throws Exception {
        smallWormTest = new EntitySmallWorm(1,1,new B2DWorld());
    }

    @Test
    public void testGetHealth() throws Exception {

        assertEquals(100, smallWormTest.getHealth());
    }

    @Test
    public void testGetDamage() throws Exception {

        assertEquals(10, smallWormTest.getDamage());
    }

    @Test
    public void testGetAttackDistance() throws Exception {

        assertEquals(10, smallWormTest.getAttackDistance());
    }

    @Test
    public void testGetLoot() throws Exception {

        assertEquals(20, smallWormTest.getLoot());
    }

    @Test
    public void testSetTakenDamage() throws Exception {
        smallWormTest.setTakenDamage(55);
        assertEquals(45, smallWormTest.getHealth());
    }

    @Test
    public void testIsAlive() throws Exception {
        assertEquals(true, smallWormTest.isAlive());
    }

    @Test
    public void testUpdate() throws Exception {
        final int sum = smallWormTest.getPositionX() + smallWormTest.getPositionY();
        smallWormTest.update(0.5f, 20,20);
        final int sum2 = smallWormTest.getPositionX() + smallWormTest.getPositionX();
        assertEquals(sum, sum2);
    }

    @Test
    public void testGetPositionX() throws Exception {

        assertEquals(-15, smallWormTest.getPositionX());
    }

    @Test
    public void testGetPositionY() throws Exception {

        assertEquals(-15, smallWormTest.getPositionY());
    }

    @Test
    public void testGetHeading() throws Exception {
        assertEquals(Heading.NORTH, smallWormTest.getHeading());

    }
}