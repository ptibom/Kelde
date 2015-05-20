package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;
import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.CollisionEventBus;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.entities.EntityArrow;
import se.computerscience.kelde.view.entities.EntityArrowView;

/**
 * Created by Anders on 2015-05-16.
 * @author Anders
 */
public class EntityArrowController implements ICollisionEventHandler {

    //Variables
    private final EntityArrow entityArrow;
    private final EntityArrowView entityArrowView;
    private float x = 0f, y = 0f;
    private Heading heading;
    private int n = 0;

    //Constructor
    public EntityArrowController(EntityArrow entityArrow, EntityArrowView entityArrowView) {
        this.entityArrow = entityArrow;
        this.entityArrowView = entityArrowView;
        heading = Heading.NORTH;
        CollisionEventBus.INSTANCE.register(this);
    }

    public void update(float delta, float x, float y, Heading heading) {
        this.x = x;
        this.y = y;
        entityArrowView.update(delta);
        entityArrow.update(delta, x, y, heading);
    }

    public void draw(SpriteBatch batch) {
        entityArrowView.draw(batch);
    }

    public void setKeyDown(int keycode) {
        if(keycode == Input.Keys.ALT_LEFT) {
            entityArrow.setPosition(x,y);
        }
    }

    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != entityArrow){
            return;
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN) {
            System.out.println("hit!" + n++);
        }
        if (event.getTag() == CollisionEvent.Tag.BEGIN) {

        }
    }
}
