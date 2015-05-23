/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;

public class Bomb implements IWorldObjects {
    private final float BODY_WIDTH = 12, BODY_HEIGHT = 12;
    private IPhysicalBody entityBody;
    private boolean detonate = false;
    private BombArea bombArea;
    public Bomb(IB2DWorld ib2DWorld, float x, float y) {
        entityBody = new PhysicalBody(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
        entityBody.setDampening(15f);
        bombArea = new BombArea(ib2DWorld,entityBody.getPositionX(),entityBody.getPositionY());
    }
    @Override
    public float getPositionY() {
        return entityBody.getPositionY()-BODY_HEIGHT ;
    }
    @Override
    public float getPositionX() {
        return entityBody.getPositionX()-BODY_WIDTH ;
    }

    public boolean isDetonate() {
        return detonate;
    }

    public void setDetonate(boolean detonate) {
        this.detonate = detonate;
    }
    public void destroy(){
        entityBody.destroy();
    }

    public BombArea getBombArea() {
        return bombArea;
    }
}