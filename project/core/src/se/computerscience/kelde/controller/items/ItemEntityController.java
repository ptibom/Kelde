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
    private ItemEntity itemEntity;
    private ItemEntityView itemEntityView;
    private boolean picked = true;

    public ItemEntityController(ItemEntity itemEntity, ItemEntityView itemEntityView) {
        this.itemEntity = itemEntity;
        this.itemEntityView = itemEntityView;
        CollisionEventBus.INSTANCE.register(this);
    }


    @Override
    public void update(float delta) {
    }
    public void delete(){
        if (picked){
            itemEntity.setVisible(false);
            itemEntityView.setDelete(true);
            //itemEntity.playerPickUp();
            picked = false;
            System.out.println("deleted");
        }
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != itemEntity){
            return;
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN){
            //ItemEventBus.INSTANCE.publish(new ItemEvent(ItemEvent.Tag.ITEM_CTRL,itemEntity));
            //ItemEventBus.INSTANCE.publish(new ItemEvent(ItemEvent.Tag.ITEM_VIEW,itemEntityView));
            delete();
        }
    }
}