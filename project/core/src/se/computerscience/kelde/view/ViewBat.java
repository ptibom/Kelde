package se.computerscience.kelde.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityBat;

/**
 * Created by Anders on 2015-04-06.
 */
public class ViewBat {

    //Variables
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasE, textureAtlasW;
    private Animation animationN, animationS, animationE, animationW;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private Animation animation;
    private float ELAPSED_TIME = 0;
    private Vector2 CURRENT_VECTOR, NEXT_VECTOR;
    private final Vector2[] VECTOR_ARRAY;
    private int index = 0;

    /**
     * Public constructor
     */
    public ViewBat(Vector2 startVector, Vector2[] nextVector) {
        CURRENT_VECTOR = startVector;
        VECTOR_ARRAY = nextVector;
        NEXT_VECTOR = VECTOR_ARRAY[index];
        batch = new SpriteBatch();
        camera = new OrthographicCamera();

        createNorthTexture();
        createSouthTexture();
        createEastTexture();
        createWestTexture();
    }

    private void createWestTexture() {
        textureAtlasW = new TextureAtlas(Gdx.files.internal("batWest.atlas"));
        animationW = new Animation(0.15f, textureAtlasW.getRegions());
    }

    private void createEastTexture() {
        textureAtlasE = new TextureAtlas(Gdx.files.internal("batEast.atlas"));
        animationE = new Animation(0.15f, textureAtlasE.getRegions());
    }

    private void createNorthTexture() {
        textureAtlasNorth = new TextureAtlas(Gdx.files.internal("bat.atlas"));
        animationN = new Animation(0.15f, textureAtlasNorth.getRegions());
    }

    public void createSouthTexture() {
        textureAtlasSouth = new TextureAtlas(Gdx.files.internal("batSouth.atlas"));
        animationS = new Animation(0.15f, textureAtlasSouth.getRegions());
    }

    public void render(Vector2 position, OrthographicCamera camera) {
        this.camera = camera;
        CURRENT_VECTOR = position;

        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        batch.begin();

        if(CURRENT_VECTOR.x == NEXT_VECTOR.x && CURRENT_VECTOR.y == NEXT_VECTOR.y) {
            NEXT_VECTOR = VECTOR_ARRAY[index];
            index++;
            if(index == 9) {
                index = 0;
            }
        }
        if(CURRENT_VECTOR.x > NEXT_VECTOR.x) {
            CURRENT_VECTOR.x -= 1;
            animation = animationE;
        } else if (CURRENT_VECTOR.x < NEXT_VECTOR.x) {
            CURRENT_VECTOR.x += 1;
            animation = animationW;
        }
        if(CURRENT_VECTOR.y > NEXT_VECTOR.y) {
            CURRENT_VECTOR.y -= 1;
            animation = animationS;
        } else if(CURRENT_VECTOR.y < NEXT_VECTOR.y) {
            CURRENT_VECTOR.y += 1;
            animation = animationN;
        }
        if(ELAPSED_TIME > 100.0f) { ELAPSED_TIME = 0f; }
        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), CURRENT_VECTOR.x, CURRENT_VECTOR.y);
        batch.end();
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }

}
