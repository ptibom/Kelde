/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;
import se.computerscience.kelde.model.worldobjects.IWorldObjects;

public class ItemEntity implements IWorldObjects {
    IPhysicalBody physicalBody;
    IItem item;

    public ItemEntity(float x, float y, IB2DWorld ib2DWorld, IItem item) {
        physicalBody = new PhysicalBodySensor(x, y, 32, 32, ib2DWorld, this);
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
        return physicalBody.getPositionY() - 32;
    }

    @Override
    public float getPositionX() {
        return physicalBody.getPositionX() - 32;
    }
}