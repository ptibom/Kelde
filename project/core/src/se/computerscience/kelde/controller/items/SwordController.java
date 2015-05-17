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
import se.computerscience.kelde.model.items.Sword;
import se.computerscience.kelde.view.items.SwordView;


public class SwordController implements IItemController, ICollisionEventHandler {
    private Sword sword;
    private SwordView swordView;
    private boolean picked = false;

    public SwordController(Sword sword, SwordView swordView) {
        this.sword = sword;
        this.swordView = swordView;
        CollisionEventBus.INSTANCE.register(this);
    }

    @Override
    public void setVisible(boolean visble) {
        swordView.setVisible(visble);
    }

    @Override
    public boolean isVisible() {
        return swordView.isVisible();
    }

    @Override
    public boolean isPicked() {
        return picked;
    }

    @Override
    public void setPicked(boolean picked) {
        this.picked = picked;
    }
    
    public void update(float delta) {
        if (sword.isVisible()) {
            if (!this.isPicked()) {
                this.setVisible(true);
            }
        }
        if (sword.isPicked()) {
            this.setPicked(true);
            this.setVisible(false);
        }
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != sword) {
            return;
        }
        if (sword.isVisible()) {
            sword.setPicked(true);
        }
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}