/* Description: Controls the Game World.
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.view.gameworld.GameWorldView;

public class GameWorldController {
    private GameWorld gameWorld;
    private GameWorldView gameWorldView;

    public GameWorldController(GameWorld gameWorld, GameWorldView gameWorldView) {
        this.gameWorld = gameWorld;
        this.gameWorldView = gameWorldView;
        initializeWorld(); // Make sure everything is set up.
    }

    public void render(float delta) {
        // Sets the camera to render from.
        gameWorldView.getRenderer().setView(gameWorld.getCamera());
        gameWorldView.render(delta);

    }

    public void resizeCamera(int width, int height) {
        // Make sure to resize camera to prevent stretching.
        gameWorld.resizeCamera(width, height);
    }

    public void initializeWorld() {
        // Give GameWorldView a renderer with the Map from GameWorld.
        gameWorldView.setRenderer(new OrthogonalTiledMapRenderer(gameWorld.getMap()));
    }

    public void dispose() {
        // Release resources.
        gameWorldView.dispose();
        gameWorld.dispose();
    }
}
