/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.worldobjects.*;
import se.computerscience.kelde.view.entities.*;
import se.computerscience.kelde.view.items.ItemEntityView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;
import se.computerscience.kelde.view.worldobjects.*;

import java.util.ArrayList;
import java.util.List;

public class GameWorldView{
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final GameWorld gameWorld;
    private final SpriteBatch batch;

    private final WorldPhysicsView worldPhysicsView;
    private final EntityPlayerKeldeView entityPlayerKeldeView;
    private final List<ItemEntityView> itemEntityViews = new ArrayList<>();

    private final List<IWorldObjectView> worldObjectViews = new ArrayList<>();
    private final List<IEntitieView> entitieViews = new ArrayList<>();

    OrthographicCamera camera;

    public GameWorldView(GameWorld gameWorld) {
        this.gameWorld = gameWorld;

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        camera = new OrthographicCamera(30, 30 * (h / w));
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();

        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap().getTiledMap());
        batch = new SpriteBatch();
        worldPhysicsView = new WorldPhysicsView(gameWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(gameWorld.getEntityPlayerKelde());
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(camera);
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        entityPlayerKeldeView.draw(batch);
        for (final ItemEntityView itemView : itemEntityViews){
            itemView.draw(batch);
        }
        for (final IWorldObjectView worldObjectView: worldObjectViews){
            worldObjectView.draw(batch);
        }
        for (final IEntitieView entitieView: entitieViews){
            entitieView.draw(batch);
        }
        batch.end();

        // Physics debug renderer, comment out to remove debugger lines.
        worldPhysicsView.render(delta);
    }

    public void addEntityViews(ItemEntity itemEntity){
        itemEntityViews.add(new ItemEntityView(itemEntity));
    }
    public void resize(int width, int height) {
        camera.viewportWidth = 1000f;
        camera.viewportHeight = 1000f * height/width;
        camera.position.set(camera.viewportWidth / 2f, camera.viewportHeight / 2f, 0);
        camera.update();
        batch.setProjectionMatrix(camera.combined);
    }
    public void dispose() {
        mapRenderer.dispose();
    }
    public WorldPhysicsView getWorldPhysicsView() {
        return worldPhysicsView;
    }
    public List<ItemEntityView> getItemEntityViews() {
        return itemEntityViews;
    }
    public void removeItemView(ItemEntityView itemEntityView){
        itemEntityViews.remove(itemEntityView);
    }
    public void addNPCEntity(IEntitieView entitieView){
        entitieViews.add(entitieView);
    }
    public void addWorldObject(IWorldObjectView worldObjectView){
        worldObjectViews.add(worldObjectView);
    }
}
