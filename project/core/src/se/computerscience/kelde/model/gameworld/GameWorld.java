/**
 * Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;
import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;

import se.computerscience.kelde.model.guioverlay.GuiOverlay;

import se.computerscience.kelde.model.inventory.Inventory;
import se.computerscience.kelde.model.items.IItem;

import se.computerscience.kelde.model.worldobjects.*;

import se.computerscience.kelde.model.physics.WorldPhysics;
import java.util.ArrayList;
import java.util.List;

public class GameWorld {

    private static final String MAP_LOCATION = "map.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;
    private GuiOverlay guiOverlay;
    private Inventory inventory;


    private final IMap map;
    private final ICamera camera;
    private final List<ItemEntity> itemEntities = new ArrayList<>();

    public GameWorld() {
        guiOverlay = new GuiOverlay();
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);

        // init  the world objects and monsters from tiled map editor
        //creating the player
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld(), 100, 100);

    }
    public void resizeCamera(int width, int height) {
        camera.setViewPortWidth(width);
        camera.setViewPortHeight(height);
        camera.setPosition(width / (float) 2, height / (float) 2, 0); // Temporary camera position. Divide by 2 to make the map stick by the corner.
        camera.update();
    }
    public void addItems(IItem item) {
        itemEntities.add(new ItemEntity(item.getItemPositionX(), item.getItemPositionY(), worldPhysics.getIb2DWorld(), item));
    }
    public ICamera getCamera() {
        return camera;
    }
    public void dispose() {
        map.dispose();
    }
    public WorldPhysics getWorldPhysics() {
        return worldPhysics;
    }
    public IMap getMap() {
        return map;
    }
    public EntityPlayerKelde getEntityPlayerKelde() {
        return entityPlayerKelde;
    }
    public List<ItemEntity> getItemEntities() {
        return itemEntities;
    }
    public GuiOverlay getGui(){ return guiOverlay;
    }

    public Inventory getInventory(){
       return inventory;
    }

    public void removeItem(ItemEntity item) {

        itemEntities.remove(item);
    }

}
