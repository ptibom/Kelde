package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class Door implements IWorldObjects {
    private final static float BODY_WIDTH = 16;
    private final static float BODY_HEIGHT = 24;
    private final IPhysicalBody entityBody;
    private final String world;

    public Door(IB2DWorld ib2DWorld, float x, float y, String world) {
        entityBody = new PhysicalBodySensor(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
        this.world = world;
    }
    @Override
    public float getPositionY() {
        return entityBody.getPositionY() - BODY_HEIGHT;
    }
    @Override
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }

    public String getWorld() {
        return world;
    }
}