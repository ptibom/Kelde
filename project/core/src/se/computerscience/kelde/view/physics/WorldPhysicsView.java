/** Description: Renders the Physics World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.physics;

import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import se.computerscience.kelde.model.physics.WorldPhysics;

public class WorldPhysicsView {
    private Box2DDebugRenderer box2DDebugRenderer; // Renders box2d objects for debugging.
    private WorldPhysics worldPhysics; // Having access to model is good. For getting data of what to render.

    public WorldPhysicsView(WorldPhysics worldPhysics) {
        this.worldPhysics = worldPhysics;
        box2DDebugRenderer = new Box2DDebugRenderer();
    }

    public void render(float delta) {
        box2DDebugRenderer.render(worldPhysics.getIb2DWorld().getBox2DWorld(), worldPhysics.getIb2DCamera().getOrthographicCamera().combined);
    }

    public void dispose() {
        box2DDebugRenderer.dispose();
    }
}
