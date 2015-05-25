/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.view.entities.*;
import se.computerscience.kelde.model.worldobjects.ItemEntity;
import se.computerscience.kelde.view.entities.EntityBatView;
import se.computerscience.kelde.view.entities.EntityEyeView;
import se.computerscience.kelde.view.entities.EntityGhostView;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;
import se.computerscience.kelde.view.items.ItemEntityView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;
import se.computerscience.kelde.view.worldobjects.BarrelView;
import se.computerscience.kelde.view.worldobjects.BombView;
import se.computerscience.kelde.view.worldobjects.DoorView;
import se.computerscience.kelde.view.worldobjects.TreasureView;

import java.util.ArrayList;
import java.util.List;

public class GameWorldView{
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
    private final DoorView doorView;
    private final EntityArrowView entityArrowView1,entityArrowView2, entityArrowView3;
    private final BombView bombView;
    private final List<ItemEntityView> itemEntityViews = new ArrayList<>();

    public GameWorldView(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap().getTiledMap());

        batch = new SpriteBatch();

        worldPhysicsView = new WorldPhysicsView(gameWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(gameWorld.getEntityPlayerKelde());

        barrelView = new BarrelView(gameWorld.getBarrel());
        treasureView = new TreasureView(gameWorld.getTreasure());
        treasureView2 = new TreasureView(gameWorld.getTreasure2());

        doorView = new DoorView(gameWorld.getDoor(),"door2");
        entityBatView = new EntityBatView(gameWorld.getEntityBat());
        entityEyeView = new EntityEyeView(gameWorld.getEntityEye());
        bombView = new BombView(gameWorld.getBomb());

        entityGhostView = new EntityGhostView(gameWorld.getEntityGhost());
        
        entityArrowView1 = new EntityArrowView(gameWorld.getEntityArrow1());
        entityArrowView2 = new EntityArrowView(gameWorld.getEntityArrow2());
        entityArrowView3 = new EntityArrowView(gameWorld.getEntityArrow3());
        
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(gameWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        treasureView.draw(batch);
        treasureView2.draw(batch);
        barrelView.draw(batch);
        doorView.draw(batch);

        entityPlayerKeldeView.draw(batch);
        entityBatView.draw(batch);
        entityEyeView.draw(batch);
        bombView.draw(batch);
        for (final ItemEntityView itemView : itemEntityViews){
            itemView.draw(batch);
        }
        entityGhostView.draw(batch);

        entityArrowView1.draw(batch);
        entityArrowView2.draw(batch);
        entityArrowView3.draw(batch);
        batch.end();

        // Physics debug renderer, comment out to remove debugger lines.
        worldPhysicsView.render(delta);
    }
    public void addEntityViews(ItemEntity itemEntity){
        itemEntityViews.add(new ItemEntityView(itemEntity));
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
    public DoorView getDoorView() {
        return doorView;
    }
    public EntityBatView getEntityBatView() {
        return entityBatView;
    }
    public EntityEyeView getEntityEyeView() {
        return entityEyeView;
    }
    public BombView getBombView() {
        return bombView;
    }
    public List<ItemEntityView> getItemEntityViews() {
        return itemEntityViews;
    }
    public EntityGhostView getEntityGhostView() { return entityGhostView; }


    public EntityArrowView getEntityArrowView1() {
        return entityArrowView1;
    }

    public EntityArrowView getEntityArrowView2() {
        return entityArrowView2;
    }

    public EntityArrowView getEntityArrowView3() {
        return entityArrowView3;
    }
    public void removeItemView(ItemEntityView itemEntityView){
        itemEntityViews.remove(itemEntityView);

    }
}
