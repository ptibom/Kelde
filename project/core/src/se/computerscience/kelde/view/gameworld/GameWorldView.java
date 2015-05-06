/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.view.entities.EntityBatView;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

public class GameWorldView {
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final GameWorld gameWorld;
    private final SpriteBatch batch;

    private final WorldPhysicsView worldPhysicsView;
    private final EntityPlayerKeldeView entityPlayerKeldeView;
    private final EntityBatView entityBatView;

    public GameWorldView(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap().getTiledMap());

        batch = new SpriteBatch();

        worldPhysicsView = new WorldPhysicsView(gameWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(gameWorld.getEntityPlayerKelde());
        entityBatView = new EntityBatView(gameWorld.getEntityBat());
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(gameWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        entityPlayerKeldeView.draw(batch);
        entityBatView.draw(batch);
        batch.end();

        // Physics debug renderer, comment out to remove debugger lines.
        worldPhysicsView.render(delta);
    }

    public void updateProjectionMatrix() {
        batch.setProjectionMatrix(gameWorld.getCamera().getOrthographicCamera().combined);
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

    public EntityPlayerKeldeView getEntityPlayerKeldeView() {
        return entityPlayerKeldeView;
    }

    public EntityBatView getEntityBatView() {
        return entityBatView;
    }
}
