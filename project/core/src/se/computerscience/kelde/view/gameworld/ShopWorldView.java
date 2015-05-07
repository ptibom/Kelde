/**
 * Description: 
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.ShopWorld;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

public class ShopWorldView {
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final ShopWorld shopWorld;
    private final SpriteBatch batch;

    private final WorldPhysicsView worldPhysicsView;
    private final EntityPlayerKeldeView entityPlayerKeldeView;
    private final SensorView sensorView;

    public ShopWorldView(ShopWorld shopWorld){
        this.shopWorld = shopWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(shopWorld.getMap().getTiledMap());

        batch = new SpriteBatch();

        worldPhysicsView = new WorldPhysicsView(shopWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(shopWorld.getEntityPlayerKelde());
        sensorView = new SensorView(shopWorld.getSensorModel());
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(shopWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        sensorView.draw(batch);
        entityPlayerKeldeView.draw(batch);
        batch.end();

        // Physics debug renderer, comment out to remove debugger lines.
        // worldPhysicsView.render(delta);
    }
    public void updateProjectionMatrix() {
        batch.setProjectionMatrix(shopWorld.getCamera().getOrthographicCamera().combined);
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
    public SensorView getSensorView() {
        return sensorView;
    }
}