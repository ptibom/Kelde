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
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.model.worldobjects.Bomb;
import se.computerscience.kelde.model.worldobjects.Door;
import se.computerscience.kelde.model.worldobjects.LavaRing;
import se.computerscience.kelde.model.worldobjects.Treasure;

public class LavaWorld {

    private static final String MAP_LOCATION = "testmap.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;
    private final Door door;
    private final LavaRing lavaRing;
    private final Bomb bomb;
    private IMap map;
    private ICamera camera;
    private Treasure treasure;
    public LavaWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld(),350,100);
        door = new Door(worldPhysics.getIb2DWorld(),350,16);
        lavaRing = new LavaRing(worldPhysics.getIb2DWorld(),250,400);
        bomb = new Bomb(worldPhysics.getIb2DWorld(), 370,300);
        treasure = new Treasure(worldPhysics.getIb2DWorld(),300,300);

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

    public Door getDoor() {
        return door;
    }

    public LavaRing getLavaRing() {
        return lavaRing;
    }

    public Bomb getBomb() {
        return bomb;
    }

    public Treasure getTreasure() {
        return treasure;
    }
}