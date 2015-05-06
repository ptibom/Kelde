package se.computerscience.kelde.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;


/**
 * Created by Anders on 2015-04-08.
 */
public class EyeView {


    //Variables
    private Batch batch;
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasE, textureAtlasW;
    private Animation animation,animationN,animationE,animationS,animationW;
    private float ELAPSED_TIME = 0;
    private Vector2 CURRENT_VECTOR, OLD_POSITION;
    private int index = 0;
    private Vector2 direction;

    public EyeView() {
        batch = new SpriteBatch();

        createSouthTexture();
        createNorthTexture();
        createEastTexture();
        createWestTexture();

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

    public void  render(Vector2 position) {
        if(OLD_POSITION == null) {
            OLD_POSITION = position;
            animation = animationN;
        }
        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        batch.begin();

        if(OLD_POSITION.x > position.x) {
            animation = animationE;
        } else if (OLD_POSITION.x < position.x) {
            animation = animationW;
        }
        if(OLD_POSITION.y > position.y) {
            animation = animationS;
        } else if(OLD_POSITION.y < position.y)  {
            animation = animationN;
        }
        if(OLD_POSITION.x == position.x && OLD_POSITION.y < position.y) {
            animation = animationE;
        } else if(OLD_POSITION.x == position.x && OLD_POSITION.y > position.y) {
            animation = animationW;
        }
        if(ELAPSED_TIME > 100.0f) { ELAPSED_TIME = 0f; }
        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), position.x, position.y);
        batch.end();
        OLD_POSITION = position;
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }

}
