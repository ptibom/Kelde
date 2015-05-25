/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.model.entities.EntityGhost;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.worldobjects.*;
import se.computerscience.kelde.view.entities.EntityBatView;
import se.computerscience.kelde.view.entities.EntityEyeView;
import se.computerscience.kelde.view.entities.EntityGhostView;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;
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

    private final List<BombView> bombViews = new ArrayList<>();
    private final List<BarrelView> barrelViews = new ArrayList<>();
    private final List<TreasureView> treasureViews = new ArrayList<>();
    private final List<CampFireView> campFireViews = new ArrayList<>();
    private final List<DoorView> doorViews = new ArrayList<>();
    private final List<EntityBatView> entityBatViews = new ArrayList<>();
    private final List<EntityGhostView> entityGhostViews = new ArrayList<>();
    private final List<EntityEyeView> entityEyeViews = new ArrayList<>();
    public GameWorldView(GameWorld gameWorld) {
        this.gameWorld = gameWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap().getTiledMap());

        batch = new SpriteBatch();

        worldPhysicsView = new WorldPhysicsView(gameWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(gameWorld.getEntityPlayerKelde());

        for (Barrel barrel: gameWorld.getBarrels()){
            barrelViews.add(new BarrelView(barrel));
        }
        for (Bomb bomb: gameWorld.getBombs()){
            bombViews.add(new BombView(bomb));
        }
        for (Treasure treasure: gameWorld.getTreasures()){
            treasureViews.add(new TreasureView(treasure));
        }
        for (CampFire campFire: gameWorld.getCampFires()){
            campFireViews.add(new CampFireView(campFire));
        }
        for (Door door: gameWorld.getDoors()){
            doorViews.add(new DoorView(door));
        }
        for (EntityBat entityBat: gameWorld.getEntityBats()){
            entityBatViews.add(new EntityBatView(entityBat));
        }
        for (EntityEye entityEye: gameWorld.getEntityEyes()){
            entityEyeViews.add(new EntityEyeView(entityEye));
        }
        for (EntityGhost entityGhost: gameWorld.getEntityGhosts()){
            entityGhostViews.add(new EntityGhostView(entityGhost));
        }
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(gameWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        entityPlayerKeldeView.draw(batch);
        for (final ItemEntityView itemView : itemEntityViews){
            itemView.draw(batch);
        }

        for (BarrelView barrelView: barrelViews){
            barrelView.draw(batch);
        }
        for (TreasureView treasureView: treasureViews){
            treasureView.draw(batch);
        }
        for (BombView bombView: bombViews){
            bombView.draw(batch);
        }
        for (CampFireView campFireView: campFireViews){
            campFireView.draw(batch);
        }
        for (DoorView doorView: doorViews){
            doorView.draw(batch);
        }
        for (EntityBatView entityBatView: entityBatViews){
            entityBatView.draw(batch);
        }
        for (EntityEyeView entityBatViews: entityEyeViews){
            entityBatViews.draw(batch);
        }
        for (EntityGhostView entityGhostView: entityGhostViews){
            entityGhostView.draw(batch);
        }
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

    public List<ItemEntityView> getItemEntityViews() {
        return itemEntityViews;
    }
    public void removeItemView(ItemEntityView itemEntityView){
        itemEntityViews.remove(itemEntityView);
    }

    public List<BombView> getBombViews() {
        return bombViews;
    }

    public List<TreasureView> getTreasureViews() {
        return treasureViews;
    }

    public List<CampFireView> getCampFireViews() {
        return campFireViews;
    }

    public List<DoorView> getDoorViews() {
        return doorViews;
    }

    public List<EntityBatView> getEntityBatViews() {
        return entityBatViews;
    }

    public List<EntityGhostView> getEntityGhostViews() {
        return entityGhostViews;
    }

    public List<EntityEyeView> getEntityEyeViews() {
        return entityEyeViews;
    }
}
