package se.computerscience.kelde.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.World;
import se.computerscience.kelde.model.entities.EntityEye;


/**
 * Created by Anders on 2015-04-08.
 */
public class EyeView {


    //Variables
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasE, textureAtlasW;
    private Animation animation,animationN,animationE,animationS,animationW;
    private float ELAPSED_TIME = 0;
    private float BOX2D_SCALE = 0.01f;
    private Vector2 CURRENT_VECTOR, NEXT_VECTOR;
    private final Vector2[] VECTOR_ARRAY;
    private int index = 0;
    Vector2 direction;

    public EyeView(Vector2 startVector, Vector2[] nextVector) {
        camera = new OrthographicCamera();
        CURRENT_VECTOR = startVector;
        VECTOR_ARRAY = nextVector;
        NEXT_VECTOR = VECTOR_ARRAY[index];
        batch = new SpriteBatch();
        createSouthTexture();
        createNorthTexture();
        createEastTexture();
        createWestTexture();

        CURRENT_VECTOR = startVector;
        direction = startVector;
    }

    private void createWestTexture() {
        textureAtlasW = new TextureAtlas(Gdx.files.internal("eyeballWest.atlas"));
        animationW = new Animation(0.15f, textureAtlasW.getRegions());
    }

    private void createSouthTexture() {
        textureAtlasSouth = new TextureAtlas(Gdx.files.internal("eyeballSouth.atlas"));
        animationS = new Animation(0.15f, textureAtlasSouth.getRegions());
    }

    private void createNorthTexture() {
        textureAtlasNorth = new TextureAtlas(Gdx.files.internal("eyeballNorth.atlas"));
        animationN = new Animation(0.15f, textureAtlasNorth.getRegions());
    }

    private void createEastTexture() {
        textureAtlasE = new TextureAtlas(Gdx.files.internal("eyeballEast.atlas"));
        animationE = new Animation(0.15f, textureAtlasE.getRegions());
    }

    public void  render(Vector2 position, OrthographicCamera camera) {
        this.camera = camera;


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
            CURRENT_VECTOR.x -= 0.5;
            animation = animationE;
        } else if (CURRENT_VECTOR.x < NEXT_VECTOR.x) {
            CURRENT_VECTOR.x += 0.5;
            animation = animationW;
        }
        if(CURRENT_VECTOR.y > NEXT_VECTOR.y) {
            CURRENT_VECTOR.y -= 0.5;
            animation = animationS;
        } else if(CURRENT_VECTOR.y < NEXT_VECTOR.y) {
            CURRENT_VECTOR.y += 0.5;
            animation = animationN;
        }

        if(ELAPSED_TIME > 100.0f) { ELAPSED_TIME = 0f; }
        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), direction.x, direction.y);
        batch.end();
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }

}
