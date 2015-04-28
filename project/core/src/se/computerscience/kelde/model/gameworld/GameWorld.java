/** Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.encapsulation.Camera;
import se.computerscience.kelde.encapsulation.ICamera;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

public class GameWorld {
    private static final String MAP_LOCATION = "map.tmx";
    private final WorldPhysics worldPhysics;
    private final WorldPhysicsView worldPhysicsView;
    private final WorldPhysicsController worldPhysicsController;

    private TiledMap map;
    private ICamera camera;

    public GameWorld() {
        map = new TmxMapLoader().load(MAP_LOCATION);
        camera = new Camera();

        worldPhysics = new WorldPhysics(getMap());
        worldPhysicsView = new WorldPhysicsView(worldPhysics);
        worldPhysicsController = new WorldPhysicsController(worldPhysics, worldPhysicsView);
    }

    public TiledMap getMap() {
        return map;
    }

    public void resizeCamera (int width, int height) {
        camera.setViewPortWidth(width);
        camera.setViewPortHeight(height);
        camera.setPosition(width / (float) 2, height / (float) 2, 0); // Temporary camera position. Divide by 2 to make the map stick by the corner.
        camera.update();
        worldPhysics.resizeCamera(width, height);
    }

    public ICamera getCamera() {
        return camera;
    }

    public void dispose() {
        map.dispose();
    }

    public WorldPhysicsController getWorldPhysicsController() {
        return worldPhysicsController;
    }

    public WorldPhysics getWorldPhysics() {
        return worldPhysics;
    }
}
