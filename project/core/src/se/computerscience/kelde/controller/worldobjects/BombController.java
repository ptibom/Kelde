/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.CollisionEventBus;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.worldobjects.Bomb;
import se.computerscience.kelde.view.worldobjects.BombView;

public class BombController implements  IWorldObjectsController, ICollisionEventHandler{
    private Bomb bomb;
    private BombView bombView;

    public BombController(Bomb bomb, BombView bombView) {
        this.bomb = bomb;
        this.bombView = bombView;
        CollisionEventBus.INSTANCE.register(this);
    }

    @Override
    public void update(float delta) {
        if (bomb.isDetonate()){
            bombView.update(delta);
        }
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != bomb){
            return;
        }
        bomb.setDetonate(true);
    }
}