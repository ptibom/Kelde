package se.computerscience.kelde.model.worldobjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

import static org.hamcrest.CoreMatchers.instanceOf;

public class BombTest {
    Bomb bomb;
    int BODY_WIDTH = 12, BODY_HEIGHT = 12;

    @Before
    public void setBomb() {
        bomb = new Bomb(new B2DWorld(), 100, 100);
    }

    @Test
    public void testGetPositionY() throws Exception {
        Assert.assertEquals(100 - BODY_HEIGHT, (int) bomb.getPositionY());
    }

    @Test
    public void testGetPositionX() throws Exception {
        Assert.assertEquals(100 - BODY_WIDTH, (int) bomb.getPositionX());
    }

    @Test
    public void testIsDetonate() throws Exception {
        Assert.assertEquals(false, bomb.isDetonate());
    }

    @Test
    public void testSetDetonate() throws Exception {
        bomb.setDetonate(true);
        Assert.assertEquals(true, bomb.isDetonate());
    }

    @Test
    public void testDestroy() throws Exception {

    }

    @Test
    public void testGetBombArea() throws Exception {
        Assert.assertThat(bomb.getBombArea(), instanceOf(BombArea.class));
    }
}