package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.entities.EntityEye;


/**
 * Created by Anders on 2015-04-08.
 * @author Anders
 */
public class EntityEyeView {


    //Variables
    private final EntityEye entityEye;

    private Batch batch;
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasE, textureAtlasW;
    private Animation animation,animationN,animationE,animationS,animationW;
    private float elapsedTime, delta;

    public EntityEyeView(EntityEye entityEye) {
        this.entityEye = entityEye;

        createTextures();
    }

    private void createTextures() {
        textureAtlasW = new TextureAtlas(Gdx.files.internal("eyeballWest.atlas"));
        animationW = new Animation(0.15f, textureAtlasW.getRegions());
        textureAtlasSouth = new TextureAtlas(Gdx.files.internal("eyeballSouth.atlas"));
        animationS = new Animation(0.15f, textureAtlasSouth.getRegions());
        textureAtlasNorth = new TextureAtlas(Gdx.files.internal("eyeballNorth.atlas"));
        animationN = new Animation(0.15f, textureAtlasNorth.getRegions());
        textureAtlasE = new TextureAtlas(Gdx.files.internal("eyeballEast.atlas"));
        animationE = new Animation(0.15f, textureAtlasE.getRegions());
    }

    public void draw(Batch batch) {
        final Heading direction = entityEye.getHeading();
        if(direction == Heading.EAST) {
            animation = animationE;
        } else if(direction == Heading.NORTH) {
            animation = animationN;
        } else if(direction == Heading.WEST) {
            animation = animationW;
        } else if(direction == Heading.SOUTH) {
            animation = animationS;
        }
        elapsedTime += delta;
        if(elapsedTime > 100.0f) { elapsedTime = 0f; }
        batch.draw(animation.getKeyFrame(elapsedTime, true), entityEye.getPositionX(), entityEye.getPositionY());
    }

    public void update(float delta) {
        this.delta = delta;
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }

}
