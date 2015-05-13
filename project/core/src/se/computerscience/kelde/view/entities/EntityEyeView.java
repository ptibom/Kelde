package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.model.Heading;


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
    private float elapsedTime = 0, delta = 0;
    private Vector2 direction;

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
        Heading direction = entityEye.getHeading();
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
