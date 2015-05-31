/**
 * Created by
 *
 * @author: Anders Bolin
 */

package se.computerscience.kelde.controller.entities;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.events.IModifyNPCEventHandler;
import se.computerscience.kelde.controller.events.ModifyNPCEvent;
import se.computerscience.kelde.controller.events.ModifyNPCEventBus;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.view.entities.EntityBatView;


public class EntityBatController implements IMonsterController , IModifyNPCEventHandler{

    //Variables
    private final EntityBat entityBat;
    private final EntityBatView entityBatView;

    public EntityBatController(EntityBat entityBat, EntityBatView entityBatView) {
        this.entityBat = entityBat;
        this.entityBatView = entityBatView;
        ModifyNPCEventBus.INSTANCE.register(this);
    }

    @Override
    public void update(float delta, float x , float y) {
        entityBatView.update(delta);
        entityBat.update(delta, x ,y);
    }

    public void draw(SpriteBatch batch) {
        entityBatView.draw(batch);
    }

    @Override
    public void onModifyNPCEvent(ModifyNPCEvent event) {
        if (event.getObject() != entityBat) {
            return;
        }
        entityBat.setTakenDamage(event.getDamage());
    }
}
