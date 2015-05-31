/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;

public class LavaSplash implements IWorldObjects {
    private final static float BODY_WIDTH = 13;
    private final static float BODY_HEIGHT = 13;
    private final IPhysicalBody entityBody;

    public LavaSplash(IB2DWorld ib2DWorld, float x, float y) {
        entityBody = new PhysicalBodySensor(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
    }

    @Override
    public float getPositionY() {
        return entityBody.getPositionY() - BODY_HEIGHT;
    }

    @Override
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }

    public void setPosition(float x, float y) {
        entityBody.setPosition(x, y);
    }

    public void setVelocity(float x, float y) {
        entityBody.setVelocity(x, y);
    }

}