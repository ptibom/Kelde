package se.computerscience.kelde.model.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

/**
 * Created by Anders on 2015-05-30.
 *
 * @author Anders Bolin
 */
public class EntityGhostTest {

    EntityGhost entityGhost;

    @Before
    public void setUp() throws Exception {
        entityGhost = new EntityGhost(100, 100, new B2DWorld());
    }

    @Test
    public void testGetAttackDistance() throws Exception {
        Assert.assertEquals(150, entityGhost.getAttackDistance());
    }

    @Test
    public void testGetHeading() throws Exception {
        Assert.assertEquals(Heading.NORTH, entityGhost.getHeading());
    }

    @Test
    public void testGetPositionX() throws Exception {
        Assert.assertEquals(84, (int) entityGhost.getPositionX());
    }

    @Test
    public void testGetPositionY() throws Exception {
        Assert.assertEquals(84, (int) entityGhost.getPositionY());
    }

    @Test
    public void testSetDamage() throws Exception {
        entityGhost.setDamage(50);
        Assert.assertEquals(50, entityGhost.getHealt());
    }

    @Test
    public void testGetDamage() throws Exception {
        Assert.assertEquals(15, entityGhost.getDamage());
    }

    @Test
    public void testGetHealt() throws Exception {
        Assert.assertEquals(100, entityGhost.getHealt());
    }

    @Test
    public void testIsAlive() throws Exception {
        Assert.assertEquals(true, entityGhost.isAlive());
    }

    @Test
    public void testGetLoot() throws Exception {
        Assert.assertEquals(25, entityGhost.getLoot());
    }
}