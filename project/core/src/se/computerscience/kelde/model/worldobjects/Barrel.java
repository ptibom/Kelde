package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class Barrel implements IWorldObjects {
    private final static float BODY_WIDTH = 16, BODY_HEIGHT = 16;
    private final IPhysicalBody entityBody;

    public Barrel(IB2DWorld ib2DWorld, float x, float y) {
        entityBody = new PhysicalBody(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
        entityBody.setDampening(15f);
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






