/** Description: Modelling the world physics. Using Box2D physics engine.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.physics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import net.dermetfan.gdx.physics.box2d.Box2DMapObjectParser;
import se.computerscience.kelde.model.gameworld.GameWorld;

public class WorldPhysics {
    // Scale 100 pixels to 1 meter. Box2D uses: Meters, Kilograms, Seconds as units
    private static final float BOX2D_SCALE = 0.01f;
    private static final int VELOCITY_ITERATIONS = 6;
    private static final int POSITION_ITERATIONS = 2;

    private OrthographicCamera box2dCamera; // Used to debug Box2D visually.
    private World box2dWorld; // A box2d World.

    public WorldPhysics(TiledMap map) {
        box2dWorld = new World(new Vector2(0, 0), true); // Create a Box2D world with 0 gravity.
        box2dCamera = new OrthographicCamera();

        // Load all the objects from the Game Map and populate the Box2D world with polygon objects.
        Box2DMapObjectParser parser = new Box2DMapObjectParser(BOX2D_SCALE);
        parser.load(box2dWorld, map); // Objects loaded to Box2D.
    }

    public void update(float delta) {
        // Simulating the Box2D world.
        box2dWorld.step(delta, VELOCITY_ITERATIONS, POSITION_ITERATIONS);
    }

    public void resizeCamera(int width, int height) {
        // Prevents stretching/resizing of images. Keeps a perfect resolution when window is resized.
        box2dCamera.viewportWidth = width*BOX2D_SCALE;
        box2dCamera.viewportHeight = height*BOX2D_SCALE;
        box2dCamera.position.set(width * BOX2D_SCALE / (float)2, height * BOX2D_SCALE / (float)2, 0);
        box2dCamera.update();
    }

    public OrthographicCamera getBox2dCamera() {
        return box2dCamera;
    }

    public World getBox2dWorld() {
        return box2dWorld;
    }

    public void dispose() {
        box2dWorld.dispose();
    }
}
