package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.view.entities.EntityEyeView;

import java.util.Random;

/**
 * Created by Anders on 2015-04-08.
 */
public class EntityEyeController {

    //Variables
    private final EntityEye entityEye;
    private final EntityEyeView entityEyeView;



    public EntityEyeController(EntityEye entityEye, EntityEyeView entityEyeView) {
        this.entityEye = entityEye;
        this.entityEyeView = entityEyeView;
    }


    public void update(float delta) {
        entityEyeView.update(delta);
        entityEye.update(delta);
    }

    public void draw(SpriteBatch batch) {
        entityEyeView.draw(batch);
    }
}
