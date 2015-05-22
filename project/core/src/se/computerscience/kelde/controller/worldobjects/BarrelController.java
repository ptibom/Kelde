/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.worldobjects.Barrel;
import se.computerscience.kelde.view.worldobjects.BarrelView;


public class BarrelController implements IWorldObjectsController, ICollisionEventHandler {
    private final Barrel barrel;
    private final BarrelView barrelView;
    public BarrelController(Barrel barrel, BarrelView barrelView) {
        this.barrel = barrel;
        this.barrelView = barrelView;
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
