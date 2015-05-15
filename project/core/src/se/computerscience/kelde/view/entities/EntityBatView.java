package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.entities.EntityBat;

/**
 * Created by Anders on 2015-04-06.
 * @author Anders Bolin
 */
public class EntityBatView {

    private final EntityBat entityBat;

    //Variables
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasE, textureAtlasW;
    private Animation animationN, animationS, animationE, animationW;

    private SpriteBatch batch;
    private Animation animation;
    private float elapsedTime = 0, delta = 0;
    /**
     * Public constructor
     */
    public EntityBatView(EntityBat entityBat) {
        this.entityBat = entityBat;

        createTextures();
        animation = animationN;
    }

    private void createTextures() {
        textureAtlasW = new TextureAtlas(Gdx.files.internal("batWest.atlas"));
        animationW = new Animation(0.15f, textureAtlasW.getRegions());
        textureAtlasE = new TextureAtlas(Gdx.files.internal("batEast.atlas"));
        animationE = new Animation(0.15f, textureAtlasE.getRegions());
        textureAtlasNorth = new TextureAtlas(Gdx.files.internal("bat.atlas"));
        animationN = new Animation(0.15f, textureAtlasNorth.getRegions());
        textureAtlasSouth = new TextureAtlas(Gdx.files.internal("batSouth.atlas"));
        animationS = new Animation(0.15f, textureAtlasSouth.getRegions());
    }

    public void draw(Batch batch) {
        Heading direction = entityBat.getHeading();
        if(direction == Heading.EAST) { // TODO: Change as in KeldeView
            animation = animationE;
        } else if(direction == Heading.NORTH) {
            animation = animationN;
        } else if(direction == Heading.WEST) {
            animation = animationW;
        } else if(direction == Heading.SOUTH) {
            animation = animationS;
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
