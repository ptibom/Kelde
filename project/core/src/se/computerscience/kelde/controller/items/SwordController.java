/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.model.items.Sword;
import se.computerscience.kelde.view.items.SwordView;


public class SwordController implements IItemController, ICollisionEventHandler,IItemEventHandler {
    //private Sword sword;
    //private SwordView swordView;
    private boolean destroyed = false;

    public SwordController(Sword sword, SwordView swordView) {
        //this.sword = sword;
        //this.swordView = swordView;
        CollisionEventBus.INSTANCE.register(this);
        ItemEventBus.INSTANCE.register(this);
    }
    public void update(float delta) {
        /*if (destroyed) {
            sword.destroy();
            destroyed = false;
        }*/
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        /*if (event.getObject() != sword) {
            return;
        }
        if (sword.isVisible()) {
            sword.setPicked(true);
            destroyed = true;
        }*/
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }

    @Override
    public void onEvent(ItemEvent event) {
        /*if (event.getObject() != sword){
            return;
        }
        //sword.setVisible(true);*/
    }
}