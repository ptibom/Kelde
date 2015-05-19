/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.controller.items.AxeController;
import se.computerscience.kelde.controller.items.SwordController;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.model.worldobjects.Treasure;
import se.computerscience.kelde.view.worldobjects.TreasureView;

public class TreasureController implements IWorldObjectsController, ICollisionEventHandler {
    private Treasure treasure;
    private TreasureView treasureView;
    public TreasureController(Treasure treasure, TreasureView treasureView) {
        this.treasure = treasure;
        this.treasureView = treasureView;
        CollisionEventBus.INSTANCE.register(this);
    }

    public void update(float delta) {
        treasureView.update(delta);
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != treasure) { // Check if it is the same object
            return;
        }
        // Contact start
        if (event.getTag() == CollisionEvent.Tag.BEGIN) {
            treasure.setIsOpen(true);
            for (IItem item : treasure.getItemslist()){
                ItemEventBus.INSTANCE.publish(new ItemEvent(ItemEvent.Tag.ITEM,item));
            }
            //ItemEventBus.INSTANCE.publish(new ItemEvent(ItemEvent.Tag.ITEM, treasure.getAxe()));
            //ItemEventBus.INSTANCE.publish(new ItemEvent(ItemEvent.Tag.ITEM, treasure.getSword()));
        }
        // Contact end
        else if (event.getTag() == CollisionEvent.Tag.END) {
            treasure.setIsOpen(false);
        }
    }

    public void dispose() { // TODO: Fix all disposes in code
        CollisionEventBus.INSTANCE.unregister(this);
    }
}