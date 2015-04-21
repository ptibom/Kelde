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
    private float WAITING_TIME = 0;
    private float BOX2D_SCALE = 0.01f;
    private Vector2 CURRENT_VECTOR, FUTURE_VECTOR;

    private EntityEye ent = new EntityEye();


    public EyeView(Vector2 startVector) {
        camera = new OrthographicCamera();
        CURRENT_VECTOR = startVector;
        FUTURE_VECTOR = ent.getWayPoint();
        batch = new SpriteBatch();
        textureAtlasNorth = new TextureAtlas(Gdx.files.internal("eyeballNorth.atlas"));
        animationN = new Animation(0.15f, textureAtlasNorth.getRegions());

        //Bat facing south
        textureAtlasSouth = new TextureAtlas(Gdx.files.internal("eyeballSouth.atlas"));
        animationS = new Animation(0.15f, textureAtlasSouth.getRegions());

        //Bat facing east
        textureAtlasE = new TextureAtlas(Gdx.files.internal("eyeballEast.atlas"));
        animationE = new Animation(0.15f, textureAtlasE.getRegions());

        //Bat facing west
        textureAtlasW = new TextureAtlas(Gdx.files.internal("eyeballWest.atlas"));
        animationW = new Animation(0.15f, textureAtlasW.getRegions());

        CURRENT_VECTOR = startVector;
    }


    public void  render(Vector2 position, OrthographicCamera camera) {
        this.camera = camera;


        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        WAITING_TIME += Gdx.graphics.getDeltaTime();
        batch.begin();

        if(CURRENT_VECTOR.x == FUTURE_VECTOR.x && CURRENT_VECTOR.y == FUTURE_VECTOR.y) {
            if(WAITING_TIME > 100.0f) {
                FUTURE_VECTOR = ent.getWayPoint();
            }
            WAITING_TIME = 0f;
        }
        if(CURRENT_VECTOR.x > FUTURE_VECTOR.x) {
            CURRENT_VECTOR.x -= 0.5;
            animation = animationE;
        } else if (CURRENT_VECTOR.x < FUTURE_VECTOR.x) {
            CURRENT_VECTOR.x += 0.5;
            animation = animationW;
        }
        if(CURRENT_VECTOR.y > FUTURE_VECTOR.y) {
            CURRENT_VECTOR.y -= 0.5;
            animation = animationS;
        } else if(CURRENT_VECTOR.y < FUTURE_VECTOR.y) {
            CURRENT_VECTOR.y += 0.5;
            animation = animationN;
        }
        if(ELAPSED_TIME > 100.0f) { ELAPSED_TIME = 0f; }
        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), CURRENT_VECTOR.x, CURRENT_VECTOR.y);
        batch.end();
    }

    public void resize() {
        batch.setProjectionMatrix(camera.combined);
    }

}
