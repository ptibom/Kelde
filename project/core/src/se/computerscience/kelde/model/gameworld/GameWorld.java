/** Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class GameWorld {
    private static final String MAP_LOCATION = "map.tmx";

    private TiledMap map;
    private OrthographicCamera camera;

    public GameWorld() {
        map = new TmxMapLoader().load(MAP_LOCATION);
        camera = new OrthographicCamera();
    }

    public TiledMap getMap() {
        return map;
    }

    public void resizeCamera (int width, int height) {
        camera.viewportWidth = width;
        camera.viewportHeight = height;
        camera.position.set(width / (float)2, height / (float)2, 0); // Temporary camera position. Divide by 2 to make the map stick by the corner.
        camera.update();
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    public void dispose() {
        map.dispose();
    }
}
