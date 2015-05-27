package se.computerscience.kelde.view.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.entities.EntityGhost;

/**
 * Created by Anders on 2015-05-16.
 * @author Anders Bolin
 */
public class EntityGhostView implements IEntitieView{

    //Variables
    private final EntityGhost entityGhost;
    private Animation animation, animationW, animationS, animationN, animationE;
    private float elapsedTime, delta;
    private Batch batch;

    //Constructor
    public EntityGhostView(EntityGhost entityGhost) {
        this.entityGhost = entityGhost;

        createTextures();
    }

    private void createTextures() {
        final TextureAtlas textureAtlasW = new TextureAtlas(Gdx.files.internal("ghostWest.atlas"));
        animationW = new Animation(0.15f, textureAtlasW.getRegions());
        final TextureAtlas textureAtlasSouth = new TextureAtlas(Gdx.files.internal("ghostSouth.atlas"));
        animationS = new Animation(0.15f, textureAtlasSouth.getRegions());
        final TextureAtlas textureAtlasNorth = new TextureAtlas(Gdx.files.internal("ghostNorth.atlas"));
        animationN = new Animation(0.15f, textureAtlasNorth.getRegions());
        final TextureAtlas textureAtlasE = new TextureAtlas(Gdx.files.internal("ghostEast.atlas"));
        animationE = new Animation(0.15f, textureAtlasE.getRegions());
    }

    public void draw(Batch batch) {
        final Heading direction = entityGhost.getHeading();
        if(direction == Heading.EAST) {
            animation = animationW;
        } else if(direction == Heading.NORTH) {
            animation = animationN;
        } else if(direction == Heading.WEST) {
            animation = animationE;
        } else if(direction == Heading.SOUTH) {
            animation = animationS;
        }
        elapsedTime += delta;
        if(elapsedTime > 100.0f) { elapsedTime = 0f; }
        batch.draw(animation.getKeyFrame(elapsedTime, true), entityGhost.getPositionX(), entityGhost.getPositionY());
    }

    public void update(float delta) {
        this.delta = delta;
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }
}
