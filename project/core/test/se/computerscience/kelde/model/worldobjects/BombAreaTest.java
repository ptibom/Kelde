package se.computerscience.kelde.model.worldobjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

public class BombAreaTest {
    BombArea bombArea;

    int BODY_WIDTH = 40;
    int BODY_HEIGHT = 40;

    @Before
    public void setUp() throws Exception {
        bombArea = new BombArea(new B2DWorld(), 100, 100);
    }

    @Test
    public void testGetPositionY() throws Exception {
        Assert.assertEquals(100 - BODY_HEIGHT, (int) bombArea.getPositionY());
    }

    @Test
    public void testGetPositionX() throws Exception {
        Assert.assertEquals(100 - BODY_WIDTH, (int) bombArea.getPositionX());
    }

    @Test
    public void testUpdatePos() throws Exception {
        bombArea.updatePos(50, 50);
        Assert.assertEquals(50 - BODY_WIDTH, (int) bombArea.getPositionX());
        Assert.assertEquals(50 - BODY_HEIGHT, (int) bombArea.getPositionY());
    }
}