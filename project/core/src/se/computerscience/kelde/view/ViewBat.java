package se.computerscience.kelde.view;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.controller.ControlBat;
import se.computerscience.kelde.model.EntityBat;

import java.awt.*;

/**
 * Created by Anders on 2015-04-06.
 */
public class ViewBat {

    //Variables
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasE, textureAtlasW;
    private Animation animationN, animationS, animationE, animationW;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TextureAtlas textureAtlas;
    private Animation animation;
    private int x = 0;
    private int y = 0;
    private float ELAPSED_TIME = 0;
    private float WAITING_TIME = 0;
    private Vector2 CURRENT_VECTOR, FUTURE_VECTOR;

    private EntityBat bat = new EntityBat();

    /**
     * Public constructor
     */
    public ViewBat() {
        batch = new SpriteBatch();
        camera = new OrthographicCamera();
        batch = new SpriteBatch();
        textureAtlasNorth = new TextureAtlas(Gdx.files.internal("bat.atlas"));
        animationN = new Animation(0.15f, textureAtlasNorth.getRegions());

        //Bat facing south
        textureAtlasSouth = new TextureAtlas(Gdx.files.internal("batSouth.atlas"));
        animationS = new Animation(0.15f, textureAtlasSouth.getRegions());

        //Bat facing east
        textureAtlasE = new TextureAtlas(Gdx.files.internal("batEast.atlas"));
        animationE = new Animation(0.15f, textureAtlasE.getRegions());

        //Bat facing west
        textureAtlasW = new TextureAtlas(Gdx.files.internal("batWest.atlas"));
        animationW = new Animation(0.15f, textureAtlasW.getRegions());
    }

    public void  render(Vector2 position, OrthographicCamera camera) {
        this.camera = camera;


        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        WAITING_TIME += Gdx.graphics.getDeltaTime();
        batch.begin();

        if(CURRENT_VECTOR.x == FUTURE_VECTOR.x && CURRENT_VECTOR.y == FUTURE_VECTOR.y) {
            if(WAITING_TIME > 100.0f) {
                FUTURE_VECTOR = bat.getWayPoint();
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
