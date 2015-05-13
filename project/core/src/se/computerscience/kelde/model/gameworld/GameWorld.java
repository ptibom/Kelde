/** Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.model.worldobjects.Door;
import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.model.items.Sword;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.model.worldobjects.Barrel;
import se.computerscience.kelde.model.worldobjects.Treasure;

public class GameWorld {

    private static final String MAP_LOCATION = "map.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;

    private final Barrel barrel;
    private final Treasure treasure;
    private final Treasure treasure2;
    private final Door door;

    private IMap map;
    private ICamera camera;

    public GameWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);

        // objects in the gameworld, init each obj with position
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld(),100,100);
        barrel = new Barrel(worldPhysics.getIb2DWorld(),100,150);
        treasure = new Treasure(worldPhysics.getIb2DWorld(),300,70,3);
        treasure2 = new Treasure(worldPhysics.getIb2DWorld(),120,70,3);
        door = new Door(worldPhysics.getIb2DWorld(),20,100);
    }

    public void resizeCamera (int width, int height) {
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
}