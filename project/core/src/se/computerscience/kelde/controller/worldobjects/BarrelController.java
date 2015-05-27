/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.worldobjects.Barrel;


public class BarrelController implements IWorldObjectsController, ICollisionEventHandler {
    private final Barrel barrel;
    public BarrelController(Barrel barrel) {
        this.barrel = barrel;
    }

    @Override
    public void update(float delta){
        // Not used
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != barrel) {
            return;
        }
    }
}
