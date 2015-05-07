/**
 * Description: 
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.controller.gameworld.SensorController;
import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.physics.WorldPhysics;

public class ShopWorld {
    private static final String MAP_LOCATION = "shop.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;
    private final SensorModel sensorModel;
    private IMap map;
    private ICamera camera;

    public ShopWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld(),300,50);
        sensorModel = new SensorModel(worldPhysics.getIb2DWorld(),300,16,"sensor ut");
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

    public SensorModel getSensorModel() {
        return sensorModel;
    }
}