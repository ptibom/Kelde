/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.worldobjects.Door;

public class DoorController implements IWorldObjectsController, ICollisionEventHandler {
    private final Door door;

    public DoorController(Door door) {
        this.door = door;
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
    }
}
