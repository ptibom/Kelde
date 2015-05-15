/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.worldobjects.Door;
import se.computerscience.kelde.view.worldobjects.DoorView;

public class DoorController implements IWorldObjectsController, ICollisionEventHandler {
    Door door;
    DoorView doorView;

    public DoorController(Door door, DoorView doorView) {
        this.door = door;
        this.doorView = doorView;
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != door) {
            return;
        }
    }
}
