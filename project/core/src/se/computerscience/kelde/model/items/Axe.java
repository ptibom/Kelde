package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;

/**
 * Description: An axe-item, used by player to damage enemies.
 *
 * @author: Hossein Hussain
 */
public class Axe implements IItems {
    private final boolean isConsumable = false;
    private final boolean isWeapon = true;
    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;
    private final int DAMAGE = 10;
    private boolean visible;
    private boolean picked;

    IPhysicalBody entityBody;

    public Axe(IB2DWorld ib2DWorld, float x, float y) {
        entityBody = new PhysicalBodySensor(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
    }

    @Override
    public float getPositionY() {
        return entityBody.getPositionY() - BODY_HEIGHT;
    }

    @Override
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }

    @Override
    public boolean isConsumable() {
        return isConsumable;
    }

    @Override
    public boolean isWeapon() {
        return isWeapon;
    }

    public int getDamage() {
        return DAMAGE;
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
}
