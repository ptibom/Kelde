/**
 * Created by
 * @author: Anders Bolin
 */

package se.computerscience.kelde.controller.entities;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.view.entities.EntityBatView;


public class EntityBatController implements ICollisionEventHandler {

    //Variables
    private final EntityBat entityBat;
    private final EntityBatView entityBatView;

    public EntityBatController(EntityBat entityBat, EntityBatView entityBatView) {
        this.entityBat = entityBat;
        this.entityBatView = entityBatView;
    }

    public void update(float delta) {
        entityBatView.update(delta);
        entityBat.update(delta);
    }

    public void draw(SpriteBatch batch) {
        entityBatView.draw(batch);
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != entityBat){
            return;
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN) {
            entityBatView.showHit();
        }
    }
}
