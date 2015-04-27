/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.GameWorld;

public class GameWorldView {
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final GameWorld gameWorld;

    public GameWorldView(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap());
        mapRenderer.setView(gameWorld.getCamera());
    }

    public void render(float delta) {
        mapRenderer.render();
    }

    public void dispose() {
        mapRenderer.dispose();
    }

    public OrthogonalTiledMapRenderer getMapRenderer() {
        return mapRenderer;
    }

}
