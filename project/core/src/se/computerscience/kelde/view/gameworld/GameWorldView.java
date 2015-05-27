/** Description: Renders the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.model.gameworld.GameWorld;

import se.computerscience.kelde.model.guioverlay.GuiOverlay;
import se.computerscience.kelde.model.worldobjects.*;
import se.computerscience.kelde.view.entities.*;

import se.computerscience.kelde.view.guioverlay.GuiOverlayView;
import se.computerscience.kelde.view.inventory.InventoryView;
import se.computerscience.kelde.view.items.ItemEntityView;

import se.computerscience.kelde.view.physics.WorldPhysicsView;
import se.computerscience.kelde.view.worldobjects.*;

import java.util.ArrayList;
import java.util.List;

public class GameWorldView{
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final GameWorld gameWorld;
    private final SpriteBatch batch;
    private final GuiOverlayView guiOverlayView;
    private final InventoryView inventoryView;

    private final WorldPhysicsView worldPhysicsView;
    private final EntityPlayerKeldeView entityPlayerKeldeView;

    private final List<ItemEntityView> itemEntityViews = new ArrayList<>();

    private final List<IWorldObjectView> worldObjectViews = new ArrayList<>();
    private final List<IEntitieView> entitieViews = new ArrayList<>();

    public GameWorldView(GameWorld gameWorld) {
        guiOverlayView = new GuiOverlayView(gameWorld.getGui());
        inventoryView = new InventoryView(gameWorld.getInventory());
        this.gameWorld = gameWorld;
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap().getTiledMap());
        batch = new SpriteBatch();
        worldPhysicsView = new WorldPhysicsView(gameWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(gameWorld.getEntityPlayerKelde());

    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(gameWorld.getCamera().getOrthographicCamera());
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        entityPlayerKeldeView.draw(batch);
        guiOverlayView.draw(batch);
        inventoryView.draw(batch);
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
    public void addNPCEntity(IEntitieView entitieView){
        entitieViews.add(entitieView);
    }
    public void addWorldObject(IWorldObjectView worldObjectView){
        worldObjectViews.add(worldObjectView);
    }
    public GuiOverlayView getGuiOverlayView(){
    return guiOverlayView;
    }
}
