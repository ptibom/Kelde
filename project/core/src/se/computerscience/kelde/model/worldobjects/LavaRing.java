/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyStatic;

import java.util.ArrayList;
import java.util.List;


public class LavaRing implements IWorldObjects {
    private final static float BODY_WIDTH = 41;
    private final static float BODY_HEIGHT = 39;
    private final IPhysicalBody entityBody;
    private final List<LavaSplash> lavaSplashs = new ArrayList<>();
    public LavaRing(IB2DWorld ib2DWorld, float x, float y){
        entityBody = new PhysicalBodyStatic(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld,this);
        lavaSplashs.add(new LavaSplash(ib2DWorld,x,y));
        lavaSplashs.add(new LavaSplash(ib2DWorld,x,y));
        lavaSplashs.add(new LavaSplash(ib2DWorld,x,y));
        lavaSplashs.add(new LavaSplash(ib2DWorld,x,y));
        lavaSplashs.add(new LavaSplash(ib2DWorld,x,y));
        lavaSplashs.add(new LavaSplash(ib2DWorld,x,y));
    }

    @Override
    public float getPositionY() {
        return entityBody.getPositionY() - BODY_HEIGHT;
    }

    @Override
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }

    public List<LavaSplash> getLavaSplashs() {
        return lavaSplashs;
    }
}