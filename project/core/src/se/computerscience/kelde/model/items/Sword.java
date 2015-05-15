/** Description: A sword item. Used by player to damage enemies.
 *  @author: Philip Tibom
 *  @co-author Hossein Husain
 */

package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;

public class Sword implements  IItems {
    private boolean isConsumable = false;
    private boolean isWeapon = true;
    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;
    private final int DAMAGE = 10;
    private boolean visible;
    private boolean picked;

    IPhysicalBody entityBody;
    public Sword(IB2DWorld ib2DWorld, float x, float y) {
        entityBody = new PhysicalBodySensor(x,y,BODY_WIDTH,BODY_HEIGHT,ib2DWorld,this);
    }

    @Override
    public float getPositionY() {
        return entityBody.getPositionY()-BODY_HEIGHT;
    }
    @Override
    public float getPositionX() {
        return entityBody.getPositionX()-BODY_WIDTH;
    }

    public int getDamage() {
        return DAMAGE;
    }

    @Override
    public boolean isConsumable() {
        return isConsumable;
    }

    @Override
    public boolean isWeapon() {
        return isWeapon;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public boolean isPicked() {
        return picked;
    }

    public void setPicked(boolean picked) {
        this.picked = picked;
    }

    public void destroy(){
        entityBody.destroy();
    }
}
