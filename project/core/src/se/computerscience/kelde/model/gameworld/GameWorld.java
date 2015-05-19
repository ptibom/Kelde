/** Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.controller.events.IItemEventHandler;
import se.computerscience.kelde.controller.events.ItemEvent;
import se.computerscience.kelde.controller.events.ItemEventBus;
import se.computerscience.kelde.model.constants.ItemSets;
import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.model.items.ItemEntity;
import se.computerscience.kelde.model.items.Sword;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.model.worldobjects.Barrel;
import se.computerscience.kelde.model.worldobjects.Bomb;
import se.computerscience.kelde.model.worldobjects.Door;
import se.computerscience.kelde.model.worldobjects.Treasure;

import java.util.ArrayList;
import java.util.List;

public class GameWorld{

    private static final String MAP_LOCATION = "map.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;
    private final EntityBat entityBat;
    private final EntityEye entityEye;

    private final Barrel barrel;
    private final Treasure treasure;
    private final Treasure treasure2;
    private final Door door;
    private final Bomb bomb;

    private IMap map;
    private ICamera camera;
    private List<ItemEntity> itemEntities = new ArrayList<>();

    public GameWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);
        // objects in the gameworld, init each obj with position
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld(),100,100);
        barrel = new Barrel(worldPhysics.getIb2DWorld(),100,150);
        treasure = new Treasure(worldPhysics.getIb2DWorld(),300,70, ItemSets.getSet1());
        treasure2 = new Treasure(worldPhysics.getIb2DWorld(),120,70, ItemSets.getSet2());

        door = new Door(worldPhysics.getIb2DWorld(),20,20);
        entityBat = new EntityBat(300f, 300f, worldPhysics.getIb2DWorld());
        entityEye = new EntityEye(200f, 200f, worldPhysics.getIb2DWorld());
        bomb = new Bomb(worldPhysics.getIb2DWorld(),100,50);
    }

    public void resizeCamera (int width, int height) {
        camera.setViewPortWidth(width);
        camera.setViewPortHeight(height);
        camera.setPosition(width / (float) 2, height / (float) 2, 0); // Temporary camera position. Divide by 2 to make the map stick by the corner.
        camera.update();
    }
    public void addItems(IItem item){
        itemEntities.add(new ItemEntity(20,20,worldPhysics.getIb2DWorld(),item));
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

    public Barrel getBarrel() {
        return barrel;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public Treasure getTreasure2() {
        return treasure2;
    }

    public Door getDoor() {
        return door;
    }

    public EntityBat getEntityBat() {
        return entityBat;
    }

    public EntityEye getEntityEye() { return entityEye; }

    public Bomb getBomb() {
        return bomb;
    }

    public List<ItemEntity> getItemEntities() {
        return itemEntities;
    }


}
