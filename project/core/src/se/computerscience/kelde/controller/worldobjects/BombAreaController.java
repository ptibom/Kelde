/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.CollisionEventBus;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.worldobjects.BombArea;

public class BombAreaController implements IWorldObjectsController, ICollisionEventHandler {
    private final BombArea bombArea;
    private boolean blow;
    ;

    public BombAreaController(BombArea bombArea) {
        this.bombArea = bombArea;
        CollisionEventBus.INSTANCE.register(this);
    }

    @Override
    public void update(float delta) {
        // not used
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != bombArea) {
            return;
        }
        if (blow) {
            //make damage on kelde
            return;
        }
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }

    public void updatePos(float x, float y) {
        bombArea.updatePos(x + 15, y + 15);
    }

    public void setBlow(boolean blow) {
        this.blow = blow;
    }
}