/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;
import se.computerscience.kelde.model.items.IItem;

public class ItemEntity implements IWorldObjects {
    private final IPhysicalBody physicalBody;
    private final IItem item;
    private boolean visible = true;
    public ItemEntity(float x, float y, IB2DWorld ib2DWorld, IItem item) {
        physicalBody = new PhysicalBody(x, y, 16, 16, ib2DWorld, this);
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
        return physicalBody.getPositionY() - 16;
    }

    @Override
    public float getPositionX() {
        return physicalBody.getPositionX() - 16;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}