package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.events.IModifyNPCEventHandler;
import se.computerscience.kelde.controller.events.ModifyNPCEvent;
import se.computerscience.kelde.controller.events.ModifyNPCEventBus;
import se.computerscience.kelde.model.entities.EntityGhost;
import se.computerscience.kelde.view.entities.EntityGhostView;

/**
 * Created by Anders on 2015-05-16.
 *
 * @author Anders Bolin
 */
public class EntityGhostController implements IMonsterController,IModifyNPCEventHandler {

    //Variables
    private final EntityGhost entityGhost;
    private final EntityGhostView entityGhostView;

    public EntityGhostController(EntityGhost entityGhost, EntityGhostView entityGhostView) {
        this.entityGhost = entityGhost;
        this.entityGhostView = entityGhostView;
        ModifyNPCEventBus.INSTANCE.register(this);
    }

    @Override
    public void update(float delta, float x, float y) {
        entityGhostView.update(delta);
        entityGhost.update(delta, x,y);
    }

    public void draw(SpriteBatch batch) {
        entityGhostView.draw(batch);
    }

    @Override
    public void onModifyNPCEvent(ModifyNPCEvent event) {
        if (event.getObject() != entityGhost){
            return;
        }
        entityGhost.setDamage(event.getDamage());
    }
}
