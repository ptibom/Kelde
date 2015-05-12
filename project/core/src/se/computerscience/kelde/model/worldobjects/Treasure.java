package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyStatic;

/**
 * Description: a model for a treasure!
 * @author: Hossein Hussain
 */

public class Treasure implements IWorldObjects {

    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;
    private boolean isOpen = false;

    IPhysicalBody entityBody;

    public Treasure(IB2DWorld ib2DWorld, float x, float y) {
        entityBody = new PhysicalBodyStatic(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld, this);
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
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