/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyStatic;

import java.util.LinkedList;

public class LavaRing implements IWorldObjects {
    private final float BODY_WIDTH = 41;
    private final float BODY_HEIGHT = 39;
    IPhysicalBody entityBody;

    private LavaSplash[] lavaSplash = new LavaSplash[10];
    public LavaRing(IB2DWorld ib2DWorld, float x, float y){
        entityBody = new PhysicalBodyStatic(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld,this);
        for (int i = 0; i <lavaSplash.length ; i++) {
            lavaSplash[i] = new LavaSplash(ib2DWorld,x,y);
        }
    }

    @Override
    public float getPositionY() {
        return entityBody.getPositionY() - BODY_HEIGHT;
    }

    @Override
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }



    public LavaSplash[] getLavaSplash() {
        return lavaSplash;
    }

    /*public LavaSplash getLavaSplash() {
        return lavaSplash;
    }*/
}