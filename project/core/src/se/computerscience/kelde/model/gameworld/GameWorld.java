/** Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.physics.WorldPhysics;

public class GameWorld {
    private static final String MAP_LOCATION = "map.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;
    private final EntityBat entityBat;
    private final EntityEye entityEye;

    private IMap map;
    private ICamera camera;

    public GameWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld());
        entityBat = new EntityBat(300f, 300f, worldPhysics.getIb2DWorld());
        entityEye = new EntityEye(200f, 200f, worldPhysics.getIb2DWorld());
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

    public EntityBat getEntityBat() {
        return entityBat;
    }

    public EntityEye getEntityEye() { return entityEye; }
}
