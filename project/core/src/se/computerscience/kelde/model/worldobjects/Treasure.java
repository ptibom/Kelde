package se.computerscience.kelde.model.worldobjects;

import se.computerscience.kelde.controller.events.ItemEvent;
import se.computerscience.kelde.controller.events.ItemEventBus;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyStatic;
import se.computerscience.kelde.model.items.IItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: a model for a treasure!
 *
 * @author: Hossein Hussain
 */

public class Treasure implements IWorldObjects {

    private final float BODY_WIDTH = 16;
    private final float BODY_HEIGHT = 16;
    private boolean isOpen = false;
    private final List<IItem> itemslist = new ArrayList<>();
    private IPhysicalBody entityBody;

    public Treasure(IB2DWorld ib2DWorld, float x, float y, List<IItem> items) {
        entityBody = new PhysicalBodyStatic(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);

        for (IItem item : items) {
            item.setItemPositionY(y+50);
            item.setItemPositionX(x+=15);
            this.itemslist.add(item);
        }
    }

    public void setIsOpen(boolean isOpen) {
        this.isOpen = isOpen;
        itemslist.clear();
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public float getPositionY() {
        return entityBody.getPositionY() - BODY_HEIGHT;
    }

    @Override
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }

    public List<IItem> getItemslist() {
        return itemslist;
    }
}