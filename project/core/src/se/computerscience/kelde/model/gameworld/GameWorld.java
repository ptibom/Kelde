/**
 * Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import se.computerscience.kelde.controller.events.ScreenEvent;
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

    private IMap map;
    private ICamera camera;
    private List<ItemEntity> itemEntities = new ArrayList<>();

    private final List<Barrel> barrels = new ArrayList<>();
    private final List<Bomb> bombs = new ArrayList<>();
    private final List<Treasure> treasures = new ArrayList<>();
    private final List<CampFire> campFires = new ArrayList<>();
    private final List<Door> doors = new ArrayList<>();
    private final List<EntityBat> entityBats = new ArrayList<>();
    private final List<EntityEye> entityEyes = new ArrayList<>();
    private final List<EntityGhost> entityGhosts = new ArrayList<>();


    public GameWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);

        // test
        creatObjects();
        // test

        // objects in the gameworld, init each obj with position
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

    public void creatObjects() {
        MapLayer layer = map.getTiledMap().getLayers().get("WorldObjects");
        for (MapObject mapObject : layer.getObjects()) {
            float x = (float) mapObject.getProperties().get("x");
            float y = (float) mapObject.getProperties().get("y");
            mapObject.getName();
            switch (mapObject.getName()) {
                case "Barrel":
                    barrels.add(new Barrel(worldPhysics.getIb2DWorld(), x, y));
                    break;
                case "Bomb":
                    bombs.add(new Bomb(worldPhysics.getIb2DWorld(), x, y));
                    break;
                case "Treasure1":
                    treasures.add(new Treasure(worldPhysics.getIb2DWorld(), x, y, ItemSets.getSet1()));
                    break;
                case "Treasure2":
                    treasures.add(new Treasure(worldPhysics.getIb2DWorld(), x, y, ItemSets.getSet2()));
                    break;
                case "Treasure3":
                    treasures.add(new Treasure(worldPhysics.getIb2DWorld(), x, y, ItemSets.getSet3()));
                    break;
                case "Campfire":
                    campFires.add(new CampFire(worldPhysics.getIb2DWorld(), x, y));
                    break;
                case "DoorLava":
                    doors.add(new Door(worldPhysics.getIb2DWorld(), x, y, ScreenEvent.ScreenTag.LAVA_WORLD));
                    break;
                case "DoorStartGame":
                    doors.add(new Door(worldPhysics.getIb2DWorld(), x, y, ScreenEvent.ScreenTag.START_WORLD));
                    break;
                case "Bat":
                    entityBats.add(new EntityBat(x,y,worldPhysics.getIb2DWorld()));
                    break;
                case "Eye":
                    entityEyes.add(new EntityEye(x,y,worldPhysics.getIb2DWorld()));
                    break;
                case "Ghost":
                    entityGhosts.add(new EntityGhost(x,y,worldPhysics.getIb2DWorld()));
                    break;
            }
        }
    }

    public List<CampFire> getCampFires() {
        return campFires;
    }

    public List<Barrel> getBarrels() {
        return barrels;
    }

    public List<Bomb> getBombs() {
        return bombs;
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public List<Door> getDoors() {
        return doors;
    }

    public List<EntityBat> getEntityBats() {
        return entityBats;
    }

    public List<EntityEye> getEntityEyes() {
        return entityEyes;
    }

    public List<EntityGhost> getEntityGhosts() {
        return entityGhosts;
    }
}