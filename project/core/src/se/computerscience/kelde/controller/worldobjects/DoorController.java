/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.ChangeScreen;
import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.events.ScreenEvent;
import se.computerscience.kelde.events.ScreenEventBus;
import se.computerscience.kelde.model.worldobjects.Door;
import se.computerscience.kelde.screens.LavaScreen;
import se.computerscience.kelde.view.worldobjects.DoorView;

public class DoorController implements IWorldObjectsController, ICollisionEventHandler {
    private Door door;
    private DoorView doorView;

    public DoorController(Door door, DoorView doorView) {
        this.door = door;
        this.doorView = doorView;
        CollisionEventBus.INSTANCE.register(this);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != door) {
            return;
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN) {
            ChangeScreen.setNextScreen(ScreenEvent.ScreenTag.LAVA_WORLD);
        }
    }
    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}
