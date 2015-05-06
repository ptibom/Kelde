package se.computerscience.kelde.controller.entities;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.model.gameworld.Heading;
import se.computerscience.kelde.view.entities.EntityBatView;

import java.util.Random;


/**
 * Created by Anders on 2015-04-06.
 */
public class EntityBatController {

    //Variables
    private final EntityBat entityBat;
    private final EntityBatView entityBatView;

    public EntityBatController(EntityBat entityBat, EntityBatView entityBatView) {
        this.entityBat = entityBat;
        this.entityBatView = entityBatView;
    }

    public void update(float delta) {
        entityBatView.update(delta);
        entityBat.update(delta);
    }

    public void draw(SpriteBatch batch) {
        entityBatView.draw(batch);
    }
}
