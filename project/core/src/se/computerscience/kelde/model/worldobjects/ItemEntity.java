/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;
import se.computerscience.kelde.model.items.IItem;

public class ItemEntity implements IWorldObjects {
    private final IItem item;
    private final static float  BODY_WIDTH = 16, BODY_HEIGHT = 16;
    private final IPhysicalBody physicalBody;
    private boolean visible = true;
    public ItemEntity(float x, float y, IB2DWorld ib2DWorld, IItem item) {
        physicalBody = new PhysicalBodySensor(x, y, BODY_WIDTH,BODY_HEIGHT , ib2DWorld, this);
        this.item = item;
    }

    public void playerPickUp() {
        // player.addItem(item);
        physicalBody.destroy();
    }

    public void dispose() {
        physicalBody.destroy();
        // item.dispose();
    }

    public IItem getItem() {
        return item;
    }
    @Override
    public float getPositionY() {
        return physicalBody.getPositionY() - BODY_HEIGHT;
    }

    @Override
    public float getPositionX() {
        return physicalBody.getPositionX() - BODY_WIDTH;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}