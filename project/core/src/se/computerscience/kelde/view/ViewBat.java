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

    private SpriteBatch batch;
    private Animation animation;
    private float ELAPSED_TIME = 0;
    private Vector2 OLD_POSITION;

    /**
     * Public constructor
     */
    public ViewBat() {
        batch = new SpriteBatch();

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

    public void render(Vector2 position) {
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
        if(ELAPSED_TIME > 100.0f) { ELAPSED_TIME = 0f; }
        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), position.x, position.y);
        batch.end();
        OLD_POSITION = position;
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }

}
