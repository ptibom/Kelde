/** Description: World includes most of the game. Such as monsters, players, terrain, objects, camera etc.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.gameworld;

import se.computerscience.kelde.model.encapsulation.libgdx.Camera;
import se.computerscience.kelde.model.encapsulation.libgdx.ICamera;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.encapsulation.libgdx.Map;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.model.items.AxeModel;
import se.computerscience.kelde.model.items.SwordModel;
import se.computerscience.kelde.model.physics.WorldPhysics;

public class GameWorld {

    private static final String MAP_LOCATION = "map.tmx";
    private final WorldPhysics worldPhysics;
    private final EntityPlayerKelde entityPlayerKelde;

    private final BarrelModel barrelModel;
    private final TreasureModell treasureModell;
    private final TreasureModell treasureModell2;
    private final AxeModel axeModel;
    private final SwordModel swordModel;
    private final SensorModel doorModel;

    private IMap map;
    private ICamera camera;

    public GameWorld() {
        map = new Map(MAP_LOCATION);
        camera = new Camera();
        worldPhysics = new WorldPhysics(map);

        // objects in the gameworld, init each obj with position
        entityPlayerKelde = new EntityPlayerKelde(worldPhysics.getIb2DWorld(),100,100);
        barrelModel = new BarrelModel(worldPhysics.getIb2DWorld(),200,33, "barrel 1");
        treasureModell = new TreasureModell(worldPhysics.getIb2DWorld(),300,70, "treasure 1");
        treasureModell2 = new TreasureModell(worldPhysics.getIb2DWorld(),120,70, "treasure 2");
        axeModel = new AxeModel(worldPhysics.getIb2DWorld(),300,170,"axe 1");
        swordModel = new SwordModel(worldPhysics.getIb2DWorld(),120,170,"sword 1");
        doorModel = new SensorModel(worldPhysics.getIb2DWorld(),20,100,"sensor 1");
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

    public BarrelModel getBarrelModel() {
        return barrelModel;
    }

    public TreasureModell getTreasureModell() {
        return treasureModell;
    }

    public TreasureModell getTreasureModell2() {
        return treasureModell2;
    }

    public AxeModel getAxeModel() {
        return axeModel;
    }

    public SwordModel getSwordModel() {
        return swordModel;
    }

    public SensorModel getDoorModel() {
        return doorModel;
    }
}