/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

public class GameWorldView {
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final GameWorld gameWorld;

    private final WorldPhysicsView worldPhysicsView;

    public GameWorldView(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap().getTiledMap());

        worldPhysicsView = new WorldPhysicsView(gameWorld.getWorldPhysics());
    }

    public void render(float delta) {
        mapRenderer.setView(gameWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();
        // Physics debug renderer, comment out to remove.
        worldPhysicsView.render(delta);
    }

    public void dispose() {
        mapRenderer.dispose();
    }

    public OrthogonalTiledMapRenderer getMapRenderer() {
        return mapRenderer;
    }

    public WorldPhysicsView getWorldPhysicsView() {
        return worldPhysicsView;
    }
}
