package se.computerscience.kelde.model.worldobjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

import static org.junit.Assert.*;


public class LavaSplashTest {
    LavaSplash lavaSplash;
    int BODY_WIDTH = 13;
    int BODY_HEIGHT = 13;

    @Before
    public void setUp() throws Exception {
        lavaSplash = new LavaSplash(new B2DWorld(),100,100);
    }


    @Test
    public void testGetPositionY() throws Exception {
        Assert.assertEquals(100-BODY_HEIGHT, (int)lavaSplash.getPositionY());
    }

    @Test
    public void testGetPositionX() throws Exception {
        Assert.assertEquals(100-BODY_WIDTH, (int)lavaSplash.getPositionX());
    }

    @Test
    public void testSetPosition() throws Exception {
        lavaSplash.setPosition(50,50);
        Assert.assertEquals(50-BODY_HEIGHT, (int)lavaSplash.getPositionY());
        Assert.assertEquals(50-BODY_WIDTH, (int)lavaSplash.getPositionX());
    }
}