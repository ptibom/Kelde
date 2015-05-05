package se.computerscience.kelde.model.gameworld;

import com.badlogic.gdx.physics.box2d.BodyDef;
import se.computerscience.kelde.model.encapsulation.box2d.EntiryBodyDynamic;
import se.computerscience.kelde.model.encapsulation.box2d.EntityBody;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IEntityBody;

/**
 * Created by Hossein on 2015-04-27.
 */
public class BarrelModel implements IWorldObjectsModel{

    private final float BODY_WIDTH = 16, BODY_HEIGHT = 16;

    IEntityBody entityBody;

    public BarrelModel(IB2DWorld ib2DWorld,float x,float y, String userdata) {
        entityBody = new EntiryBodyDynamic(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld,userdata);
        //entityBody = new EntityBody(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, BodyDef.BodyType.DynamicBody, userdata,false);
    }
    public float getPositionY() {
        return entityBody.getPositionY()-BODY_HEIGHT;
    }
    public float getPositionX() {
        return entityBody.getPositionX()-BODY_WIDTH;
    }

    public void barrelMovement(){
        entityBody.setVelocity(0, 0);
    }
}
