package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.events.IMonsterEventHandler;
import se.computerscience.kelde.controller.events.MonsterEvent;
import se.computerscience.kelde.controller.events.MonsterEventBus;
import se.computerscience.kelde.model.entities.EntityArrow;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.view.entities.EntityEyeView;

/**
 * Created by Anders on 2015-04-08.
 * @author Anders
 */
public class EntityEyeController implements IMonsterEventHandler {

    //Variables
    private final EntityEye entityEye;
    private final EntityEyeView entityEyeView;



    public EntityEyeController(EntityEye entityEye, EntityEyeView entityEyeView) {
        this.entityEye = entityEye;
        this.entityEyeView = entityEyeView;
        MonsterEventBus.INSTANCE.register(this);
    }


    public void update(float delta) {
        entityEyeView.update(delta);
        entityEye.update(delta);
    }

    public void draw(SpriteBatch batch) {
        entityEyeView.draw(batch);
    }

    @Override
    public void onMonsterEvent(MonsterEvent event) {
        /*if(event.getObject() instanceof EntityArrow) {
            System.out.println("entityEyecontroller: onMonsterEvent");
        }*/
        if (event.getObject() != entityEye){
            return;
        }
        System.out.println("eye hit");
    }
}
