/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.CollisionEventBus;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.worldobjects.CampFire;
import se.computerscience.kelde.view.worldobjects.CampFireView;

public class CampFireController implements IWorldObjectsController , ICollisionEventHandler{
    private final CampFire campFire;
    private final CampFireView campFireView;

    public CampFireController(CampFire campFire, CampFireView campFireView) {
        this.campFire = campFire;
        this.campFireView = campFireView;
        CollisionEventBus.INSTANCE.register(this);
    }

    @Override
    public void update(float delta) {
        campFireView.update(delta);
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != campFire){
            return;
        }
        System.out.println("burned");
    }
}