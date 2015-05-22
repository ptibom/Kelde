/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.view.entities.EntityBatView;
import se.computerscience.kelde.view.entities.EntityEyeView;
import se.computerscience.kelde.view.entities.EntityGhostView;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;
import se.computerscience.kelde.view.items.AxeView;
import se.computerscience.kelde.view.items.SwordView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;
import se.computerscience.kelde.view.worldobjects.BarrelView;
import se.computerscience.kelde.view.worldobjects.DoorView;
import se.computerscience.kelde.view.worldobjects.TreasureView;

public class GameWorldView {
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final GameWorld gameWorld;
    private final SpriteBatch batch;

    private final WorldPhysicsView worldPhysicsView;
    private final EntityPlayerKeldeView entityPlayerKeldeView;
    private final EntityBatView entityBatView;
    private final EntityEyeView entityEyeView;
    private final EntityGhostView entityGhostView;

    private final BarrelView barrelView;
    private final TreasureView treasureView;
    private final TreasureView treasureView2;
    private final AxeView axeView;
    private final AxeView axeView2;
    private final SwordView swordView;
    private final SwordView swordView2;
    private final DoorView doorView;

    public GameWorldView(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap().getTiledMap());

        batch = new SpriteBatch();

        worldPhysicsView = new WorldPhysicsView(gameWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(gameWorld.getEntityPlayerKelde());

        barrelView = new BarrelView(gameWorld.getBarrel());
        treasureView = new TreasureView(gameWorld.getTreasure());
        treasureView2 = new TreasureView(gameWorld.getTreasure2());
        axeView = new AxeView(gameWorld.getTreasure().getAxe());
        axeView2 = new AxeView(gameWorld.getTreasure2().getAxe());
        swordView = new SwordView(gameWorld.getTreasure().getSword());
        swordView2 = new SwordView(gameWorld.getTreasure2().getSword());

        doorView = new DoorView(gameWorld.getDoor(),"door2");
        entityBatView = new EntityBatView(gameWorld.getEntityBat());
        entityEyeView = new EntityEyeView(gameWorld.getEntityEye());
        entityGhostView = new EntityGhostView(gameWorld.getEntityGhost());
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(gameWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        if (axeView.isVisble()){
            axeView.draw(batch);
        }
        if (axeView2.isVisble()){
            axeView2.draw(batch);
        }
        if (swordView.isVisble()){
            swordView.draw(batch);
        }
        if (swordView2.isVisble()){
            swordView2.draw(batch);
        }
        treasureView.draw(batch);
        treasureView2.draw(batch);
        barrelView.draw(batch);
        doorView.draw(batch);

        entityPlayerKeldeView.draw(batch);
        entityBatView.draw(batch);
        entityEyeView.draw(batch);
        entityGhostView.draw(batch);
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
    public DoorView getDoorView() {
        return doorView;
    }
    public SwordView getSwordView2() {
        return swordView2;
    }
    public AxeView getAxeView2() {
        return axeView2;
    }

    public EntityBatView getEntityBatView() {
        return entityBatView;
    }

    public EntityEyeView getEntityEyeView() {
        return entityEyeView;
    }

    public EntityGhostView getEntityGhostView() { return entityGhostView; }
}
