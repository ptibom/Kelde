/** Description: Renders the Physics World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.physics;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import se.computerscience.kelde.model.physics.WorldPhysics;

public class WorldPhysicsView {
    private final Box2DDebugRenderer box2DDebugRenderer; // Renders box2d objects for debugging.
    private final WorldPhysics worldPhysics; // Having access to model is good. For getting data of what to render.
    private final OrthographicCamera b2dcamera;

    public WorldPhysicsView(WorldPhysics worldPhysics) {
        this.worldPhysics = worldPhysics;
        b2dcamera = new OrthographicCamera();
        box2DDebugRenderer = new Box2DDebugRenderer();
    }

    public void render(float delta) {
        box2DDebugRenderer.render(worldPhysics.getIb2DWorld().getBox2DWorld(), b2dcamera.combined);
    }

    public void resize(int width, int height) {
        // Prevents stretching/resizing of images. Keeps a perfect resolution when window is resized.
        b2dcamera.viewportWidth = width*WorldPhysics.BOX2D_SCALE;
        b2dcamera.viewportHeight = (1000f*height/width)*WorldPhysics.BOX2D_SCALE;
        b2dcamera.position.set(width * WorldPhysics.BOX2D_SCALE / (float)2, height * WorldPhysics.BOX2D_SCALE / (float)2, 0);
        b2dcamera.update();

    }

    public void dispose() {
        box2DDebugRenderer.dispose();
    }
}