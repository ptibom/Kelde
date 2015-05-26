/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.LavaWorld;
import se.computerscience.kelde.view.entities.EntityGhostView;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;
import se.computerscience.kelde.view.entities.IEntitieView;
import se.computerscience.kelde.view.items.ItemEntityView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;
import se.computerscience.kelde.view.worldobjects.*;

import java.util.ArrayList;
import java.util.List;

public class LavaWorldView {

    private final OrthogonalTiledMapRenderer mapRenderer;
    private final LavaWorld lavaWorld;
    private final SpriteBatch batch;

    private final WorldPhysicsView worldPhysicsView;
    private final EntityPlayerKeldeView entityPlayerKeldeView;

    private final List<IWorldObjectView> worldObjectViews = new ArrayList<>();
    private final List<IEntitieView> entitieViews = new ArrayList<>();

    public LavaWorldView(LavaWorld lavaWorld) {
        this.lavaWorld = lavaWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(lavaWorld.getMap().getTiledMap());

        batch = new SpriteBatch();

        worldPhysicsView = new WorldPhysicsView(lavaWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(lavaWorld.getEntityPlayerKelde());
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(lavaWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        entityPlayerKeldeView.draw(batch);
        for (IWorldObjectView worldObjectView: worldObjectViews){
            worldObjectView.draw(batch);
        }
        for (IEntitieView entitieView: entitieViews){
            entitieView.draw(batch);
        }
        batch.end();

        // Physics debug renderer, comment out to remove debugger lines.
        worldPhysicsView.render(delta);
    }
    public void updateProjectionMatrix() {
        batch.setProjectionMatrix(lavaWorld.getCamera().getOrthographicCamera().combined);
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

    public void addNPCEntity(IEntitieView entitieView){
        entitieViews.add(entitieView);
    }
    public void addWorldObject(IWorldObjectView worldObjectView){
        worldObjectViews.add(worldObjectView);
    }
}