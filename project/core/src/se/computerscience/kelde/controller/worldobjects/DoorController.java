/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.services.ScreenChanger;
import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.model.worldobjects.Door;

public class DoorController implements IWorldObjectsController, ICollisionEventHandler {
    private final Door door;
    private final ScreenEvent.ScreenTag screenTag;
    public DoorController(Door door, ScreenEvent.ScreenTag screenTag) {
        this.door = door;
        this.screenTag = screenTag;
        CollisionEventBus.INSTANCE.register(this);
    }

    @Override
    public void update(float delta) {
        // Not used
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != door) {
            return;
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN) {
            ScreenChanger.setNextScreen(screenTag);
        }
    }
    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}
