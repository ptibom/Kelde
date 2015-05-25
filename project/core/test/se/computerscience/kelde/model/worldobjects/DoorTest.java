package se.computerscience.kelde.model.worldobjects;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;

import static org.junit.Assert.*;

public class DoorTest {
    Door door;
    int BODY_WIDTH = 16, BODY_HEIGHT = 24;
    @Before
    public void setDoor(){
        door = new Door(new B2DWorld(), 100, 100, "Start");
    }

    @Test
    public void testGetPositionY() throws Exception {
        Assert.assertEquals(100-BODY_HEIGHT,(int) door.getPositionY());
    }

    @Test
    public void testGetPositionX() throws Exception {
        Assert.assertEquals(100-BODY_WIDTH, (int)door.getPositionX());
    }
}