package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IEntityBody;

/**
 * Description:
 *
 * @author: Hossein Hussain
 */
public class BarrelModel implements IWorldObjectsModel{
    private final float BODY_WIDTH = 16, BODY_HEIGHT = 4;

    IEntityBody entityBody;

    public BarrelModel(IB2DWorld ib2DWorld,float x,float y, String userdata) {
        //entityBody = new EntityBodyDynamic(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld,userdata);
    }
    @Override
    public float getPositionY() {
        return entityBody.getPositionY()-BODY_HEIGHT;
    }
    @Override
    public float getPositionX() {
        return entityBody.getPositionX()-BODY_WIDTH;
    }

    public void barrelMovement(){
        entityBody.setVelocity(0, 0);
    }
}
