/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;

public class LavaSplash implements IWorldObjects{
    private final float BODY_WIDTH = 13;
    private final float BODY_HEIGHT = 13;
    private boolean splash = false;
    IPhysicalBody entityBody;
    public LavaSplash(IB2DWorld ib2DWorld, float x, float y){
        entityBody = new PhysicalBodySensor(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld,this);
    }

    @Override
    public float getPositionY() {
        return entityBody.getPositionY() - BODY_HEIGHT;
    }

    @Override
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }

    public boolean isSplash() {
        return splash;
    }

    public void setSplash(boolean splash) {
        this.splash = splash;
    }
    public void setVelocity(float x, float y) {
        entityBody.setVelocity(x, y);
    }

}