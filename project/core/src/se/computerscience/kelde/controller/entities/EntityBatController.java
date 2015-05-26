/**
 * Created by
 * @author: Anders Bolin
 */

package se.computerscience.kelde.controller.entities;


import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.model.entities.EntityArrow;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.view.entities.EntityBatView;


public class EntityBatController implements IMonsterEventHandler {

    //Variables
    private final EntityBat entityBat;
    private final EntityBatView entityBatView;
    private boolean destroyed;

    public EntityBatController(EntityBat entityBat, EntityBatView entityBatView) {
        this.entityBat = entityBat;
        this.entityBatView = entityBatView;
        MonsterEventBus.INSTANCE.register(this);
    }

    public void update(float delta) {
        entityBatView.update(delta);
        entityBat.update(delta);
    }

    public void draw(SpriteBatch batch) {
        entityBatView.draw(batch);
    }

    /*
    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != entityBat){
            return;
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN) {
            entityBatView.showHit();
        }
    } */

    @Override
    public void onMonsterEvent(MonsterEvent event) {
        /*if(event.getObject() instanceof EntityArrow) {
            System.out.println("entityBatcontroller: onMonsterEvent");
        }*/
        if(!destroyed) {
            if (event.getObject() != entityBat) {
                return;
            }
            if (!entityBat.getAlive()) {
                entityBat.destroyBody();
                destroyed = true;
            }
            System.out.println("new Bat healt: " + entityBat.getHealth());
            System.out.println("bat hit: Lost 25hp");
            entityBat.setTakenDamage(25);
        }else {
            return;
        }

    }

}
