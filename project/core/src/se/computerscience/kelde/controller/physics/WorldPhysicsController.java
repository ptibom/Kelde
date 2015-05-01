/** Description: WorldCollision handles world object collision from Tiled maps. It loads all objects and uses box2d physics engine to calculate collisions.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.physics;

import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

public class WorldPhysicsController {
    private final WorldPhysics worldPhysics;
    private final WorldPhysicsView worldPhysicsView;

    public WorldPhysicsController(WorldPhysics worldPhysics, WorldPhysicsView worldPhysicsView) {
        this.worldPhysics = worldPhysics;
        this.worldPhysicsView = worldPhysicsView;
    }

    public void update(float delta) {
        worldPhysics.update(delta);
    }

    public void resizeCamera(int width, int height) {
        worldPhysics.resizeCamera(width, height);
    }

    public void dispose() {
        // Release resources.
        worldPhysicsView.dispose();
        worldPhysics.dispose();
    }
}
