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
    private float BOX2D_SCALE = 0.01f;
    private Vector2 CURRENT_VECTOR, NEXT_VECTOR;
    private Vector2[] VECTOR_ARRAY;
    private Random rnd;
    private int INDEX = 0;
    private int END_INDEX = 9;
    private float DELAY = 5;
    private float END_DELAY = 7;

    public SmallWormView(Vector2 startVector, Vector2[] nextVector) {
        rnd = new Random();
        camera = new OrthographicCamera();
        CURRENT_VECTOR = startVector;
        VECTOR_ARRAY = nextVector;
        NEXT_VECTOR = VECTOR_ARRAY[INDEX];
        batch = new SpriteBatch();
        createUpTexture();
        CURRENT_VECTOR = startVector;
    }

    private void createUpTexture() {
        textureAtlasUp = new TextureAtlas(Gdx.files.internal("smallwormUp.atlas"));
        animationUp = new Animation(0.3f, textureAtlasUp.getRegions());
    }

    public void  render(OrthographicCamera camera) {
        this.camera = camera;

        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        batch.begin();
        if(ELAPSED_TIME > DELAY) {

            batch.draw(animationUp.getKeyFrame(ELAPSED_TIME, true), VECTOR_ARRAY[INDEX].x, VECTOR_ARRAY[INDEX].y);

            if(ELAPSED_TIME > END_DELAY) {
                INDEX++;
                if(INDEX == END_INDEX) {
                    INDEX = 0;
                }
                ELAPSED_TIME = 0;
            }
        }
        batch.end();
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }
}
