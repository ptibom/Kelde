/**
 * Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import se.computerscience.kelde.model.constants.ItemSets;
import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.model.entities.EntityGhost;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.model.worldobjects.*;
import se.computerscience.kelde.model.physics.WorldPhysics;

import java.util.ArrayList;
import java.util.List;

public class GameWorld {

    private static final String MAP_LOCATION = "map.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;

    private final IMap map;
    private final ICamera camera;
    private final List<ItemEntity> itemEntities = new ArrayList<>();

    public GameWorld() {
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
    public void removeItem(ItemEntity item) {
        itemEntities.remove(item);
    }
}
