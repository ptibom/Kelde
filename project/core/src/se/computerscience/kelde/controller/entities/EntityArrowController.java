package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.entities.EntityArrow;
import se.computerscience.kelde.view.entities.EntityArrowView;

/**
 * Created by Anders on 2015-05-16.
 */
public class EntityArrowController {

    //Variables
    private final EntityArrow entityArrow;
    private final EntityArrowView entityArrowView;
    private float x = 0f, y = 0f;

    //Constructor
    public EntityArrowController(EntityArrow entityArrow, EntityArrowView entityArrowView) {
        this.entityArrow = entityArrow;
        this.entityArrowView = entityArrowView;
    }

    public void update(float delta, float x, float y) {
        this.x = x;
        this.y = y;
        entityArrowView.update(delta);
        entityArrow.update(delta, x, y);
    }

    public void draw(SpriteBatch batch) {
        entityArrowView.draw(batch);
    }

    public void setKeyDown(int keycode) {
        if(keycode == Input.Keys.ALT_LEFT) {
            entityArrow.setPosition(x,y);
        }
    }

}
