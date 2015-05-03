/**
 * Small worm, view class
 * @author: Anders Bolin
 */

package se.computerscience.kelde.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Anders on 2015-04-25.
 */
public class SmallWormView {

    //Variables
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasEast, textureAtlasWest, textureAtlasUp;
    private Animation animation,animationN,animationE,animationS,animationW,animationUp;
    private float ELAPSED_TIME = 0;


    public SmallWormView(Vector2 startVector) {
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        createUpTexture();
    }

    private void createUpTexture() {
        textureAtlasUp = new TextureAtlas(Gdx.files.internal("smallwormUp.atlas"));
        animationUp = new Animation(0.3f, textureAtlasUp.getRegions());
    }

    public void render(Vector2 position) {

        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        batch.begin();
        batch.draw(animationUp.getKeyFrame(ELAPSED_TIME, true), position.x, position.y);
        batch.end();
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }
}
