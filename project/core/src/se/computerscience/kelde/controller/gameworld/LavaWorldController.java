/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.gameworld;

import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.physics.WorldContactListener;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.controller.worldobjects.*;
import se.computerscience.kelde.model.gameworld.LavaWorld;
import se.computerscience.kelde.view.gameworld.LavaWorldView;
import java.util.ArrayList;
import java.util.List;

public class LavaWorldController {

    private final LavaWorld lavaWorld;
    private final LavaWorldView lavaWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;

    private final DoorController doorController;
    private final LavaRingController lavaRingController;
    private List<IWorldObjectsController> worldObjList = new ArrayList<>();
    private final BombController bombController;

    private final TreasureController treasureController;
    public LavaWorldController() {
        lavaWorld = new LavaWorld();
        lavaWorldView = new LavaWorldView(lavaWorld);

        worldPhysicsController = new WorldPhysicsController(lavaWorld.getWorldPhysics(), lavaWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(lavaWorld.getEntityPlayerKelde(), lavaWorldView.getEntityPlayerKeldeView());
        doorController = new DoorController(lavaWorld.getDoor(), lavaWorldView.getDoorView());
        lavaRingController = new LavaRingController(lavaWorld.getLavaRing(), lavaWorldView.getLavaRingView());
        bombController = new BombController(lavaWorld.getBomb(),lavaWorldView.getBombView());
        lavaWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener());
        treasureController = new TreasureController(lavaWorld.getTreasure(),lavaWorldView.getTreasureView());
    }

    public void render(float delta) {
        entityPlayerKeldeController.update(delta);
        doorController.update(delta);
        lavaRingController.update(delta);
        treasureController.update(delta);

        bombController.update(delta);
        worldPhysicsController.update(delta);
        lavaWorldView.render(delta);
    }

    public void resizeCamera(int width, int height) {
        // Make sure to resize camera to prevent stretching.
        lavaWorld.resizeCamera(width, height);
        lavaWorldView.updateProjectionMatrix();
        worldPhysicsController.resizeCamera(width, height);
    }

    public void dispose() {
        // Release resources.
        lavaWorldView.dispose();
        lavaWorld.dispose();
        worldPhysicsController.dispose();
    }
}