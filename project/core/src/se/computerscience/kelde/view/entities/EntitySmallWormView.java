/**
 * Small worm, view class
 * @author: Anders Bolin
 */

package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.entities.EntitySmallWorm;

/**
 * Created by Anders on 2015-04-25.
 * @author Anders Bolin
 */
public class EntitySmallWormView {

    //Variables
    private final EntitySmallWorm entitySmallWorm;
    private final SpriteBatch batch;
    private TextureAtlas textureAtlasUp;
    private Animation animation,animationUp;
    private float elapsedTime, delta;


    public EntitySmallWormView(EntitySmallWorm entitySmallWorm) {
        this.entitySmallWorm = entitySmallWorm;
        batch = new SpriteBatch();
        createUpTexture();
    }

    private void createUpTexture() {
        textureAtlasUp = new TextureAtlas(Gdx.files.internal("smallwormUp.atlas"));
        animationUp = new Animation(0.3f, textureAtlasUp.getRegions());
    }

    public void draw(Batch batch) {
        final Heading direction = entitySmallWorm.getHeading();
        if(direction == Heading.EAST) {
            animation = animationUp;
        } else if(direction == Heading.NORTH) {
            animation = animationUp;
        } else if(direction == Heading.WEST) {
            animation = animationUp;
        } else if(direction == Heading.SOUTH) {
            animation = animationUp;
        }
        elapsedTime += delta;
        if(elapsedTime > 100.0f) { elapsedTime = 0f; }
        batch.draw(animation.getKeyFrame(elapsedTime, true), entitySmallWorm.getPositionX(), entitySmallWorm.getPositionY());
    }

    public void update(float delta) {
        this.delta = delta;
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }
}
