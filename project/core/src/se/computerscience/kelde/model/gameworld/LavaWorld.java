/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.model.worldobjects.ItemEntity;

import java.util.ArrayList;
import java.util.List;


public class LavaWorld {

    private static final String MAP_LOCATION = "testmap.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;
    private final List<ItemEntity> itemEntities = new ArrayList<>();
    private final IMap map;
    private final ICamera camera;

    public LavaWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld(), 350, 140);
    }

    public void addItems(IItem item) {
        itemEntities.add(new ItemEntity(item.getItemPositionX(), item.getItemPositionY(), worldPhysics.getIb2DWorld(), item));
    }

    public List<ItemEntity> getItemEntities() {
        return itemEntities;
    }

    public void removeItem(ItemEntity item) {
        itemEntities.remove(item);
    }

    public void resizeCamera(int width, int height) {
        camera.setViewPortWidth(width);
        camera.setViewPortHeight(height);
        camera.setPosition(width / (float) 2, height / (float) 2, 0); // Temporary camera position. Divide by 2 to make the map stick by the corner.
        camera.update();
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
}