/** Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.encapsulation.libgdx.Camera;
import se.computerscience.kelde.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.encapsulation.libgdx.IMap;
import se.computerscience.kelde.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

public class GameWorld {
    private static final String MAP_LOCATION = "map.tmx";
    private final WorldPhysics worldPhysics;
    private final WorldPhysicsView worldPhysicsView;
    private final WorldPhysicsController worldPhysicsController;

    private IMap map;
    private ICamera camera;

    public GameWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();

        worldPhysics = new WorldPhysics(map);
        worldPhysicsView = new WorldPhysicsView(worldPhysics);
        worldPhysicsController = new WorldPhysicsController(worldPhysics, worldPhysicsView);
    }

    public void resizeCamera (int width, int height) {
        camera.setViewPortWidth(width);
        camera.setViewPortHeight(height);
        camera.setPosition(width / (float) 2, height / (float) 2, 0); // Temporary camera position. Divide by 2 to make the map stick by the corner.
        camera.update();
        worldPhysicsController.resizeCamera(width, height);
    }

    public void update(float delta) {
        worldPhysicsController.update(delta);
    }

    public ICamera getCamera() {
        return camera;
    }

    public void dispose() {
        map.dispose();
        worldPhysicsController.dispose();
    }

    public WorldPhysicsController getWorldPhysicsController() {
        return worldPhysicsController;
    }

    public WorldPhysics getWorldPhysics() {
        return worldPhysics;
    }

    public IMap getMap() {
        return map;
    }
}
