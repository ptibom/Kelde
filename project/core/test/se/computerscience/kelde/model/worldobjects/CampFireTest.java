package se.computerscience.kelde.model.worldobjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

import static org.junit.Assert.*;

public class CampFireTest {
    CampFire campFire;
    int BODY_WIDTH = 32, BODY_HEIGHT = 8;
    @Before
    public void setCampFire(){
        campFire = new CampFire(new B2DWorld(),100,100);
    }

    @Test
    public void testGetPositionY() throws Exception {
        Assert.assertEquals(100-BODY_HEIGHT,(int)campFire.getPositionY());
    }

    @Test
    public void testGetPositionX() throws Exception {
        Assert.assertEquals(100-BODY_WIDTH,(int)campFire.getPositionX());
    }
}