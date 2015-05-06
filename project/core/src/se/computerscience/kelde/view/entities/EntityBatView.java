package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.model.gameworld.Heading;

import java.util.Random;

/**
 * Created by Anders on 2015-04-06.
 */
public class EntityBatView {

    private final EntityBat entityBat;

    //Variables
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasE, textureAtlasW;
    private Animation animationN, animationS, animationE, animationW;

    private SpriteBatch batch;
    private Animation animation;
    private float elapsedTime = 0, delta = 0;
    private Heading direction;
    /**
     * Public constructor
     */
    public EntityBatView(EntityBat entityBat) {
        this.entityBat = entityBat;

        createNorthTexture();
        createSouthTexture();
        createEastTexture();
        createWestTexture();
        animation = animationN;
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

    public void draw(Batch batch) {
        if(entityBat.getDirection() == Heading.NORTH) {
            animation = animationN;
        } else if(entityBat.getDirection() == Heading.SOUTH) {
            animation = animationS;
        } else if(entityBat.getDirection() == Heading.EAST) {
            animation = animationE;
        } else if(entityBat.getDirection() == Heading.WEST) {
            animation = animationW;
        }
        elapsedTime += delta;
        if(elapsedTime > 100.0f) {
            elapsedTime = 0f;
        }
        batch.draw(animation.getKeyFrame(elapsedTime, true), entityBat.getPositionX(), entityBat.getPositionY());
    }

    public void update(float delta) {
        this.delta = delta;
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }

}
