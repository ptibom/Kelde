package se.computerscience.kelde.model.items;

import com.badlogic.gdx.physics.box2d.BodyDef;
import se.computerscience.kelde.model.encapsulation.box2d.EntityBody;
import se.computerscience.kelde.model.encapsulation.box2d.EntitySensor;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IEntityBody;
import se.computerscience.kelde.model.gameworld.IWorldObjectsModel;

/**
 * @author hossein on 2015-05-04.
 */
public class AxeModel implements IItems , IWorldObjectsModel{
    public boolean isConsumable = false;
    public boolean isWeapon = true;


    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;

    IEntityBody entityBody;

    public AxeModel(IB2DWorld ib2DWorld,float x, float y,String userdata) {
        entityBody = new EntitySensor(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld,userdata);
        //entityBody = new EntityBody(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, BodyDef.BodyType.StaticBody, userdata,true);
    }

    public void setVelocity(float x, float y) {
        entityBody.setVelocity(x, y);
    }

    public float getPositionY() {
        return entityBody.getPositionY()-BODY_HEIGHT;
    }
    public float getPositionX() {
        return entityBody.getPositionX()-BODY_WIDTH;
    }

    @Override
    public boolean isConsumable() {
        return isConsumable;
    }

    @Override
    public boolean isWeapon() {
        return isWeapon;
    }
}
