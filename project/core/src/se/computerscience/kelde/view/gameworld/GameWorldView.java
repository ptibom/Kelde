/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;
import se.computerscience.kelde.view.items.AxeView;
import se.computerscience.kelde.view.items.SwordView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

public class GameWorldView {
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final GameWorld gameWorld;
    private final SpriteBatch batch;

    private final WorldPhysicsView worldPhysicsView;
    private final EntityPlayerKeldeView entityPlayerKeldeView;

    private final BarrelView barrelView;
    private final TreasureView treasureView;
    private final TreasureView treasureView2;
    private final AxeView axeView;
    private final SwordView swordView;
    private final SensorView sensorView1;

    public GameWorldView(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap().getTiledMap());

        batch = new SpriteBatch();

        worldPhysicsView = new WorldPhysicsView(gameWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(gameWorld.getEntityPlayerKelde());

        barrelView = new BarrelView(gameWorld.getBarrelModel());
        treasureView = new TreasureView(gameWorld.getTreasureModell());
        treasureView2 = new TreasureView(gameWorld.getTreasureModell2());
        axeView = new AxeView(gameWorld.getAxeModel());
        swordView = new SwordView(gameWorld.getSwordModel());
        sensorView1 = new SensorView(gameWorld.getSensorModel1());
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(gameWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();

        // Draw sprites
        batch.begin();

        entityPlayerKeldeView.draw(batch);

        if (axeView.isVisble())
            axeView.draw(batch);
        if (swordView.isVisble())
            swordView.draw(batch);


        treasureView.draw(batch);
        treasureView2.draw(batch);
        barrelView.draw(batch);
        sensorView1.draw(batch);

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
    public BarrelView getBarrelView(){
        return barrelView;
    }
    public TreasureView getTreasureView() {
        return treasureView;
    }
    public TreasureView getTreasureView2() {
        return treasureView2;
    }
    public AxeView getAxeView() {
        return axeView;
    }
    public SwordView getSwordView() {
        return swordView;
    }
    public SensorView getSensorView1() {
        return sensorView1;
    }
}
