/**
 * Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.guioverlay.GuiOverlay;
import se.computerscience.kelde.model.inventory.Inventory;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.model.worldobjects.ItemEntity;

import java.util.ArrayList;
import java.util.List;

public class GameWorld {

    private static final String MAP_LOCATION = "map.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;
    private final GuiOverlay guiOverlay;
    private final Inventory inventory;


    private final IMap map;

    private final List<ItemEntity> itemEntities = new ArrayList<>();

    public GameWorld() {
        inventory = new Inventory();
        guiOverlay = new GuiOverlay();
        map = new Map(MAP_LOCATION);
        //camera = new Camera();
        worldPhysics = new WorldPhysics(map);
        //creating the player
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld(), 100, 100);

    }

    public void addItems(IItem item) {
        itemEntities.add(new ItemEntity(item.getItemPositionX(), item.getItemPositionY(), worldPhysics.getIb2DWorld(), item));
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

    public GuiOverlay getGui() {
        return guiOverlay;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void removeItem(ItemEntity item) {

        itemEntities.remove(item);
    }

}
