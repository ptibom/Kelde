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
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.entities.EntitySmallWorm;

/**
 * Created by Anders on 2015-04-25.
 * @author Anders Bolin
 */
public class EntitySmallWormView {

    //Variables
    private final EntitySmallWorm entitySmallWorm;
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasEast, textureAtlasWest, textureAtlasUp;
    private Animation animation,animationN,animationE,animationS,animationW,animationUp;
    private float elapsedTime = 0;
    private float delta = 0;


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
        Heading direction = entitySmallWorm.getHeading();
        if(direction == Heading.EAST) {
            animation = animationE;
        } else if(direction == Heading.NORTH) {
            animation = animationN;
        } else if(direction == Heading.WEST) {
            animation = animationW;
        } else if(direction == Heading.SOUTH) {
            animation = animationS;
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
