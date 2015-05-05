/** Description: A sword item. Used by player to damage enemies.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.box2d.EntitySensor;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IEntityBody;

public class SwordModel implements IItems {
    private boolean isConsumable = false;
    private boolean isWeapon = true;
    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;

    private IEntityBody entityBody;
    public SwordModel(IB2DWorld ib2DWorld,float x, float y,String userdata) {
        entityBody = new EntitySensor(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld,userdata);
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
