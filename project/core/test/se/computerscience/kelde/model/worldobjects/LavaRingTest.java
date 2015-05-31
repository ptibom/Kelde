package se.computerscience.kelde.model.worldobjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

import java.util.List;

public class LavaRingTest {
    LavaRing lavaRing;
    int BODY_WIDTH = 41;
    int BODY_HEIGHT = 39;

    @Before
    public void setUp() throws Exception {
        lavaRing = new LavaRing(new B2DWorld(), 100, 100);
    }

    @Test
    public void testGetPositionY() throws Exception {
        Assert.assertEquals(100 - BODY_HEIGHT, (int) lavaRing.getPositionY());
    }

    @Test
    public void testGetPositionX() throws Exception {
        Assert.assertEquals(100 - BODY_WIDTH, (int) lavaRing.getPositionX());
    }

    @Test
    public void testGetLavaSplashs() throws Exception {
        // test somehting else
        Assert.assertTrue(lavaRing.getLavaSplashs() instanceof List);
    }
}