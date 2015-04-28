/**
 * Small worm, view class
 * @author: Anders Bolin
 */

package se.computerscience.kelde.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.controller.Waypoints;

import java.util.Random;

/**
 * Created by Anders on 2015-04-25.
 */
public class SmallWormView {

    //Variables
    private OrthographicCamera camera;
    private SpriteBatch batch;
    private TextureAtlas textureAtlasNorth, textureAtlasSouth, textureAtlasEast, textureAtlasWest, textureAtlasUp;
    private Animation animation,animationN,animationE,animationS,animationW,animationUp;
    private float ELAPSED_TIME = 0;
    private float BOX2D_SCALE = 0.01f;
    private Vector2 SPAWNPOINT;
    private final Waypoints WAYPOINTS;
    private float DELAY = 5;
    private float END_DELAY = 7;

    public SmallWormView(Vector2 startVector, Waypoints points) {
        camera = new OrthographicCamera();
        SPAWNPOINT = startVector;
        WAYPOINTS = points;
        batch = new SpriteBatch();
        createUpTexture();
    }

    private void createUpTexture() {
        textureAtlasUp = new TextureAtlas(Gdx.files.internal("smallwormUp.atlas"));
        animationUp = new Animation(0.3f, textureAtlasUp.getRegions());
    }

    public void  render(OrthographicCamera camera) {
        this.camera = camera;

        ELAPSED_TIME += Gdx.graphics.getDeltaTime();
        batch.begin();
        if(ELAPSED_TIME > DELAY) {

            batch.draw(animationUp.getKeyFrame(ELAPSED_TIME, true), SPAWNPOINT.x, SPAWNPOINT.y);

            if(ELAPSED_TIME > END_DELAY) {
                SPAWNPOINT = WAYPOINTS.getNextWaypoint();
                ELAPSED_TIME = 0;
            }
        }
        batch.end();
    }

    public void resize(OrthographicCamera camera) {
        batch.setProjectionMatrix(camera.combined);
    }
}
