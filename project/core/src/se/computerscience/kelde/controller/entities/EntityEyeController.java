package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.events.IModifyNPCEventHandler;
import se.computerscience.kelde.controller.events.ModifyNPCEvent;
import se.computerscience.kelde.controller.events.ModifyNPCEventBus;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.view.entities.EntityEyeView;

/**
 * Created by Anders on 2015-04-08.
 *
 * @author Anders
 */
public class EntityEyeController implements IMonsterController, IModifyNPCEventHandler{


    //Variables
    private final EntityEye entityEye;
    private final EntityEyeView entityEyeView;


    public EntityEyeController(EntityEye entityEye, EntityEyeView entityEyeView) {
        this.entityEye = entityEye;
        this.entityEyeView = entityEyeView;
        ModifyNPCEventBus.INSTANCE.register(this);
    }

    @Override
    public void update(float delta,float playerX,float playerY) {
        entityEyeView.update(delta);
        entityEye.update(delta,playerX, playerY);
    }

    public void draw(SpriteBatch batch) {
        entityEyeView.draw(batch);
    }

    @Override
    public void onModifyNPCEvent(ModifyNPCEvent event) {
        if (event.getObject() != entityEye){
            return;
        }
        entityEye.setTakenDamage(event.getDamage());
    }
}
