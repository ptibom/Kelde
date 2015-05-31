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
public class EntityEyeTest {

    EntityEye entityEye;

    @Before
    public void setUp() throws Exception {
        entityEye = new EntityEye(100, 100, new B2DWorld());
    }

    @Test
    public void testGetHEALTH() throws Exception {
        Assert.assertEquals(100, entityEye.getHEALTH());
    }

    @Test
    public void testAttackDistance() {
        Assert.assertEquals(150, entityEye.getAttackDistance());
    }

    @Test
    public void testgetLoot() {
        Assert.assertEquals(25, entityEye.getLoot());
    }

    @Test
    public void testTakenDamage() {
        entityEye.setTakenDamage(50);
        Assert.assertEquals(50, entityEye.getHEALTH());
    }

    @Test
    public void testPositionX() {
        Assert.assertEquals(84, (int) entityEye.getPositionX());
    }

    @Test
    public void testPositionY() {
        Assert.assertEquals(78, (int) entityEye.getPositionY());
    }

    @Test
    public void testHeading() {
        Assert.assertEquals(entityEye.getHeading(), Heading.NORTH);
    }
}