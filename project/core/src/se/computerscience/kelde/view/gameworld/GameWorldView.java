/**
 * Description: Renders the Game World.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.view.gameworld;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.worldobjects.ItemEntity;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;
import se.computerscience.kelde.view.entities.IEntityView;
import se.computerscience.kelde.view.guioverlay.GuiOverlayView;
import se.computerscience.kelde.view.inventory.InventoryView;
import se.computerscience.kelde.view.items.ItemEntityView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;
import se.computerscience.kelde.view.worldobjects.IWorldObjectView;

import java.util.ArrayList;
import java.util.List;

public class GameWorldView {
    private final OrthogonalTiledMapRenderer mapRenderer;
    private final SpriteBatch batch;
    private final GuiOverlayView guiOverlayView;
    private final InventoryView inventoryView;

    private final WorldPhysicsView worldPhysicsView;
    private final EntityPlayerKeldeView entityPlayerKeldeView;

    private final List<ItemEntityView> itemEntityViews = new ArrayList<>();

    private final List<IWorldObjectView> worldObjectViews = new ArrayList<>();
    private final List<IEntityView> entitieViews = new ArrayList<>();

    private final OrthographicCamera camera;
    private final Viewport viewport;

    private final Sprite fightTextSprite;

    public GameWorldView(GameWorld gameWorld) {
        inventoryView = new InventoryView(gameWorld.getInventory());

        camera = new OrthographicCamera();
        camera.update();

        viewport = new FitViewport(960, 640, camera);
        guiOverlayView = new GuiOverlayView(gameWorld.getGui(), viewport);
        mapRenderer = new OrthogonalTiledMapRenderer(gameWorld.getMap().getTiledMap());
        batch = new SpriteBatch();
        worldPhysicsView = new WorldPhysicsView(gameWorld.getWorldPhysics());
        entityPlayerKeldeView = new EntityPlayerKeldeView(gameWorld.getEntityPlayerKelde());

        fightTextSprite = new Sprite(new Texture("fighttext.png"));
        fightTextSprite.setPosition(200, 610);
    }

    public void render(float delta) {
        // Draw map
        mapRenderer.setView(camera);
        mapRenderer.render();

        // Draw sprites
        batch.begin();
        entityPlayerKeldeView.draw(batch);

        for (final ItemEntityView itemView : itemEntityViews) {
            itemView.draw(batch);
        }
        for (final IWorldObjectView worldObjectView : worldObjectViews) {
            worldObjectView.draw(batch);
        }
        for (final IEntityView entitieView : entitieViews) {
            entitieView.draw(batch);
        }

        guiOverlayView.draw(batch);
        inventoryView.draw(batch);
        fightTextSprite.draw(batch);
        batch.end();

        // Physics debug renderer, comment out to remove debugger lines.
        //worldPhysicsView.render(delta);
    }

    public void addEntityViews(ItemEntity itemEntity) {
        itemEntityViews.add(new ItemEntityView(itemEntity));
    }

    public void resize(int width, int height) {
        camera.position.set(width / (float) 2, height / (float) 2, 0);
        viewport.update(width, height, true);
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

    public void removeItemView(ItemEntityView itemEntityView) {
        itemEntityViews.remove(itemEntityView);
    }

    public void addNPCEntity(IEntityView entitieView) {
        entitieViews.add(entitieView);
    }

    public void addWorldObject(IWorldObjectView worldObjectView) {
        worldObjectViews.add(worldObjectView);
    }

    public GuiOverlayView getGuiOverlayView() {
        return guiOverlayView;
    }

    public InventoryView getInventoryView() {
        return inventoryView;
    }
}
