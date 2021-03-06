package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.entities.EntitySmallWorm;
import se.computerscience.kelde.view.entities.EntitySmallWormView;

/**
 * Created by Anders on 2015-04-25.
 *
 * @author Anders Bolin
 */
public class EntityWormController implements IMonsterController {

    //Variables
    private final EntitySmallWorm entitySmallWorm;
    private final EntitySmallWormView entityWormView;

    public EntityWormController(EntitySmallWorm entitySmallWorm, EntitySmallWormView entityWormView) {
        this.entitySmallWorm = entitySmallWorm;
        this.entityWormView = entityWormView;
    }


    public void update(float delta, float x, float y) {
        entityWormView.update(delta);
        entitySmallWorm.update(delta, x,y);
    }

    public void draw(SpriteBatch batch) {
        entityWormView.draw(batch);
    }

}
