/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.controller.services.ScreenChanger;
import se.computerscience.kelde.model.Point;
import se.computerscience.kelde.model.worldobjects.Door;
import se.computerscience.kelde.view.worldobjects.DoorView;


public class DoorController implements IWorldObjectsController, ICollisionEventHandler {
    private final Door door;
    private final DoorView doorView;
    private ScreenEvent.ScreenTag screenTag;

    enum TeleportTo {
        LAVA, BEGINNNER_HOUSE1
    }

    private TeleportTo teleportTo;

    public DoorController(Door door, DoorView doorView) {
        this.door = door;
        this.doorView = doorView;
        CollisionEventBus.INSTANCE.register(this);

        if (door.getLocation().equals("shop1")) {
            teleportTo = TeleportTo.BEGINNNER_HOUSE1;
        } else if (door.getLocation().equals("Lava")) {
            screenTag = ScreenEvent.ScreenTag.LAVA_WORLD;
        } else if (door.getLocation().equals("Start")) {
            screenTag = ScreenEvent.ScreenTag.START_WORLD;
        }
    }

    @Override
    public void update(float delta) {
        doorView.update(delta);
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != door) {
            return;
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN) {

            if (teleportTo == TeleportTo.BEGINNNER_HOUSE1) {
                ModifyPlayerEventBus.INSTANCE.publish(new ModifyPlayerEvent(ModifyPlayerEvent.Tag.CHANGE_POS, new Point(200, 200)));
            } else {
                ScreenChanger.setNextScreen(screenTag);
            }
        }
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}
