package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.view.entities.EntityEyeView;

/**
 * Created by Anders on 2015-04-08.
 * @author Anders
 */
public class EntityEyeController implements IMonsterController{

    //Variables
    private final EntityEye entityEye;
    private final EntityEyeView entityEyeView;



    public EntityEyeController(EntityEye entityEye, EntityEyeView entityEyeView) {
        this.entityEye = entityEye;
        this.entityEyeView = entityEyeView;
    }

    @Override
    public void update(float delta,float playerX,float playerY) {
        entityEyeView.update(delta);
        entityEye.update(delta,playerX, playerY);
    }

    public void draw(SpriteBatch batch) {
        entityEyeView.draw(batch);
    }
}
