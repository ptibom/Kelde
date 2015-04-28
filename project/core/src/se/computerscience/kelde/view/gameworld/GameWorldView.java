/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

public class GameWorldView {
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final GameWorld gameWorld;

    public GameWorldView(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap());
        mapRenderer.setView(gameWorld.getCamera().getOrthographicCamera());
    }

    public void render(float delta) {
        mapRenderer.render();
        // Update physics & render debugging
        gameWorld.getWorldPhysicsController().update(delta);
        gameWorld.getWorldPhysicsController().renderDebug(delta); // Comment this line to remove debugging.
    }

    public void dispose() {
        mapRenderer.dispose();
    }

    public OrthogonalTiledMapRenderer getMapRenderer() {
        return mapRenderer;
    }

}
