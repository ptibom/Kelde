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

public class BombController implements IWorldObjectsController, ICollisionEventHandler {
    private final Bomb bomb;
    private final BombView bombView;
    private final BombAreaController bombAreaController;

    public BombController(Bomb bomb, BombView bombView) {
        this.bomb = bomb;
        this.bombView = bombView;
        bombAreaController = new BombAreaController(bomb.getBombArea());
        CollisionEventBus.INSTANCE.register(this);
    }

    @Override
    public void update(float delta) {
        bombAreaController.update(delta);
        if (bomb.isDetonate()) {
            bombView.update(delta);
        }
        bombAreaController.updatePos(bomb.getPositionX(), bomb.getPositionY());
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != bomb) {
            return;
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN) {
            bomb.setDetonate(true);
            bombAreaController.setBlow(true);
        }
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}