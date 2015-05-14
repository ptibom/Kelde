package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensorStatic;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class Door implements IWorldObjects {
    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 24;
    IPhysicalBody entityBody;

    public Door(IB2DWorld ib2DWorld, float x, float y) {
        entityBody = new PhysicalBodySensorStatic(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
    }
    @Override
    public float getPositionY() {
        return entityBody.getPositionY() - BODY_HEIGHT;
    }
    @Override
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }
}