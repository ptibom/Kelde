package se.computerscience.kelde.model.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

import static org.junit.Assert.*;

/**
 * Created by Anders on 2015-05-30.
 *
 * @author Anders Bolin
 */
public class EntityBatTest {

    EntityBat entityBat;

    @Before
    public void setUp() throws Exception {
        entityBat = new EntityBat(100,100, new B2DWorld());
    }

    @Test
    public void testGetHealth() throws Exception {
        Assert.assertEquals(100, entityBat.getHealth());
    }

    @Test
    public void testGetLoot() throws Exception {
        Assert.assertEquals(15, entityBat.getLoot());
    }

    @Test
    public void testSetTakenDamage() throws Exception {
        entityBat.setTakenDamage(25);
        Assert.assertEquals(75, entityBat.getHealth());
    }

    @Test
    public void testGetPositionX() throws Exception {
        Assert.assertEquals(84, entityBat.getPositionX());
    }

    @Test
    public void testGetPositionY() throws Exception {
        Assert.assertEquals(84, entityBat.getPositionY());
    }

    @Test
    public void testGetHeading() throws Exception {
        Assert.assertEquals(Heading.NORTH, entityBat.getHeading());
    }
}