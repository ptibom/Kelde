/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;

public class KeldeDmgArea implements IWorldObjects {

    private final static float BODY_WIDTH = 16;
    private final static float BODY_HEIGHT = 8;
    private final IPhysicalBody entityBody;
    public KeldeDmgArea(IB2DWorld ib2DWorld, float x, float y) {
        entityBody = new PhysicalBodySensor(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
    }
    @Override
    public float getPositionY() {
        return entityBody.getPositionY()-BODY_HEIGHT;

    }
    @Override
    public float getPositionX() {
        return entityBody.getPositionX()-BODY_WIDTH;
    }
    public void updatePos(float x,float y){
        entityBody.setPosition(x, y);
    }
    public void destroy(){
        entityBody.destroy();
    }
    public boolean isActive(){
        return entityBody.getBody().isActive();
    }
    public void setActive(boolean flag){
        entityBody.getBody().setActive(flag);
    }
}