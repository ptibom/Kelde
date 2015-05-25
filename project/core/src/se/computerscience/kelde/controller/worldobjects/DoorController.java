/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.services.ScreenChanger;
import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.model.worldobjects.Door;
import se.computerscience.kelde.view.worldobjects.DoorView;

public class DoorController implements IWorldObjectsController, ICollisionEventHandler {
    private final Door door;
    private final DoorView doorView;
    private ScreenEvent.ScreenTag screenTag;
    public DoorController(Door door, DoorView doorView) {
        this.door = door;
        this.doorView = doorView;
        CollisionEventBus.INSTANCE.register(this);
        if (door.getWorld().equals("Lava")){
           screenTag = ScreenEvent.ScreenTag.LAVA_WORLD;
        }else if (door.getWorld().equals("Start")){
            screenTag = ScreenEvent.ScreenTag.START_WORLD;
        }
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
