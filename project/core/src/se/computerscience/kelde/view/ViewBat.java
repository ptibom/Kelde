package se.computerscience.kelde.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.gameworld.Heading;

import java.util.Random;

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
    private Vector2 position;
    private Heading direction;
    /**
     * Public constructor
     */
    public ViewBat() {
        position = new Vector2(300f,300f);
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
        if(direction == Heading.NORTH) {
            animation = animationN;
        } else if(direction == Heading.SOUTH) {
            animation = animationS;
        } else if(direction == Heading.EAST) {
            animation = animationE;
        } else if(direction == Heading.WEST) {
            animation = animationW;
        }

        if(ELAPSED_TIME > 100.0f) { ELAPSED_TIME = 0f; }
        batch.draw(animation.getKeyFrame(ELAPSED_TIME, true), position.x, position.y);
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }

    private Vector2 getNewWaypoint() {
        float minX = 1.0f;
        float maxX = 100.0f;
        Random rnd = new Random();
        float x = rnd.nextFloat() * (maxX - minX) + minX;
        float y = rnd.nextFloat() * (maxX - minX) + minX;
        return new Vector2(x,y);
    }

    public void update(Vector2 render_point, Heading direction) {
        position = render_point;
        this.direction = direction;
    }
}
