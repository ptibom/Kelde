package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyStatic;

/**
 * Description: a model for a treasure!
 * @author: Hossein Hussain
 */

public class TreasureModell implements IWorldObjectsModel {

    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;

    IPhysicalBody entityBody;

    public TreasureModell(IB2DWorld ib2DWorld,float x,float y,String userdata) {
        entityBody = new PhysicalBodyStatic(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld, userdata);
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