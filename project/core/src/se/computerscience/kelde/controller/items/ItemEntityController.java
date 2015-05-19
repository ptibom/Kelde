/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.CollisionEventBus;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.model.worldobjects.ItemEntity;
import se.computerscience.kelde.view.items.ItemEntityView;

public class ItemEntityController implements IWorldObjectsController , ICollisionEventHandler{
    private ItemEntity itemEntity;
    private ItemEntityView itemEntityView;

    public ItemEntityController(ItemEntity itemEntity, ItemEntityView itemEntityView) {
        this.itemEntity = itemEntity;
        this.itemEntityView = itemEntityView;
        CollisionEventBus.INSTANCE.register(this);
    }


    @Override
    public void update(float delta) {

    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        System.out.println("i was h");
        if (event.getObject() != itemEntity){
            return;
        }
        System.out.println("picked");
    }
}