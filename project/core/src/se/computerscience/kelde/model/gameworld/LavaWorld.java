/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityGhost;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.model.worldobjects.*;


public class LavaWorld {

    private static final String MAP_LOCATION = "lavamap.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;
    private final Door door;
    private final LavaRing lavaRing;
    private final Bomb bomb;
    private final CampFire campFire;
    private final EntityGhost entityGhost;

    private IMap map;
    private ICamera camera;
    public LavaWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld(),350,140);
        door = new Door(worldPhysics.getIb2DWorld(),350,16,"Start");
        lavaRing = new LavaRing(worldPhysics.getIb2DWorld(),250,400);
        bomb = new Bomb(worldPhysics.getIb2DWorld(), 370,300);
        campFire = new CampFire(worldPhysics.getIb2DWorld(),140,100);
        entityGhost = new EntityGhost(150,200,worldPhysics.getIb2DWorld());
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
    public CampFire getCampFire() {
        return campFire;
    }

    public EntityGhost getEntityGhost() {
        return entityGhost;
    }
}