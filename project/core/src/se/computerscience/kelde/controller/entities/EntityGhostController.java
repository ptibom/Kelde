package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.entities.EntityGhost;
import se.computerscience.kelde.view.entities.EntityGhostView;

/**
 * Created by Anders on 2015-05-16.
 *
 * @author Anders Bolin
 */
public class EntityGhostController implements IMonsterController {

    //Variables
    private final EntityGhost entityGhost;
    private final EntityGhostView entityGhostView;

    public EntityGhostController(EntityGhost entityGhost, EntityGhostView entityGhostView) {
        this.entityGhost = entityGhost;
        this.entityGhostView = entityGhostView;
    }

    @Override
    public void update(float delta) {
        entityGhostView.update(delta);
        entityGhost.update(delta);
    }

    public void draw(SpriteBatch batch) {
        entityGhostView.draw(batch);
    }

}
