package se.computerscience.kelde.model.worldobjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

import static org.junit.Assert.*;

public class BarrelTest {

    Barrel barrel;
    int BODY_WIDTH = 16, BODY_HEIGHT = 16;
    @Before
    public void setBarrel(){
         barrel = new Barrel(new B2DWorld(),100,100);
    }

    @Test
    public void testGetPositionY() throws Exception {
        Assert.assertEquals(100-BODY_HEIGHT, (int)barrel.getPositionY());
    }

    @Test
    public void testGetPositionX() throws Exception {
        Assert.assertEquals(100-BODY_WIDTH,(int)barrel.getPositionX());
    }
}