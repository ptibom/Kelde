/** Description: Controls the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;


import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.view.gameworld.GameWorldView;

public class GameWorldController {
    /** Model reference of the MVC for GameWorld */
    private final GameWorld gameWorld;
    /** View reference of the MVC for GameWorld */
    private final GameWorldView gameWorldView;

    /** Constructor to initialize the controller
     * @param gameWorld The Model of the MVC.
     * @param gameWorldView The View of the MVC.
     */
    public GameWorldController(GameWorld gameWorld, GameWorldView gameWorldView) {
        this.gameWorld = gameWorld;
        this.gameWorldView = gameWorldView;
    }

    /** Called by Game Loop. Renders & Updates everything in the world
     * @param delta Time in milliseconds since the game has started.
     */
    public void render(float delta) {
        // Sets the camera to render from.
        gameWorldView.getMapRenderer().setView(gameWorld.getCamera().getOrthographicCamera());
        gameWorldView.render(delta);
    }

    /** Called when Game Window is resized by the user.
     * @param width The new window width in pixels
     * @param height The new window height in pixels
     */
    public void resizeCamera(int width, int height) {
        // Make sure to resize camera to prevent stretching.
        gameWorld.resizeCamera(width, height);
    }

    /** Called when game is closing */
    public void dispose() {
        // Release resources.
        gameWorldView.dispose();
        gameWorld.dispose();
    }
}
