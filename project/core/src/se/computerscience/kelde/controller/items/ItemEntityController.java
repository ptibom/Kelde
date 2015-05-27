/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.model.worldobjects.ItemEntity;
import se.computerscience.kelde.view.items.ItemEntityView;

public class ItemEntityController implements IWorldObjectsController , ICollisionEventHandler{
    private final ItemEntity itemEntity;
    private final ItemEntityView itemEntityView;

    public ItemEntityController(ItemEntity itemEntity, ItemEntityView itemEntityView) {
        this.itemEntity = itemEntity;
        this.itemEntityView = itemEntityView;
        CollisionEventBus.INSTANCE.register(this);
    }


    @Override
    public void update(float delta) {
        // not used
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != itemEntity){
            return;
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN){
            ItemEventBus.INSTANCE.publish(new ItemEvent(ItemEvent.Tag.DEL_ITEM, this));
            itemEntity.playerPickUp();
        }
    }

    public ItemEntity getItemEntity() {
        return itemEntity;
    }

    public ItemEntityView getItemEntityView() {
        return itemEntityView;
    }
}