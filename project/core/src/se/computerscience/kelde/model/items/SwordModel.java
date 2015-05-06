/** Description: A sword item. Used by player to damage enemies.
 *  @author: Philip Tibom
 *  @co-author Hossein Husain
 */

package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;
import se.computerscience.kelde.model.gameworld.IWorldObjectsModel;

public class SwordModel implements IItems,IWorldObjectsModel {
    private boolean isConsumable = false;
    private boolean isWeapon = true;
    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;
    private final int damage = 10;

    IPhysicalBody entityBody;
    public SwordModel(IB2DWorld ib2DWorld,float x, float y,String userdata) {
        entityBody = new PhysicalBodySensor(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld,userdata);
    }
    @Override
    public float getPositionY() {
        return entityBody.getPositionY()-BODY_HEIGHT;
    }
    @Override
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

    @Override
    public String itemName() {
        return "sword 1";
    }

    public int getDamage() {
        return damage;
    }
}
