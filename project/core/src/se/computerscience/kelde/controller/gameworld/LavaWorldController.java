/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.gameworld;

import se.computerscience.kelde.controller.entities.EntityGhostController;
import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.controller.physics.WorldContactListener;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.controller.worldobjects.*;
import se.computerscience.kelde.model.gameworld.LavaWorld;
import se.computerscience.kelde.view.gameworld.LavaWorldView;
import java.util.ArrayList;
import java.util.List;

public class LavaWorldController implements IGameWorldController{

    private final LavaWorld lavaWorld;
    private final LavaWorldView lavaWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;

    private final DoorController doorController;
    private final LavaRingController lavaRingController;
    private List<IWorldObjectsController> worldObjList = new ArrayList<>();
    private final BombController bombController;
    private final CampFireController campFireController;
    private final EntityGhostController entityGhostController;

    public LavaWorldController() {
        lavaWorld = new LavaWorld();
        lavaWorldView = new LavaWorldView(lavaWorld);

        worldPhysicsController = new WorldPhysicsController(lavaWorld.getWorldPhysics(), lavaWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(lavaWorld.getEntityPlayerKelde());
        doorController = new DoorController(lavaWorld.getDoor(), lavaWorldView.getDoorView(), ScreenEvent.ScreenTag.START_WORLD);
        lavaRingController = new LavaRingController(lavaWorld.getLavaRing(), lavaWorldView.getLavaRingView());
        bombController = new BombController(lavaWorld.getBomb(),lavaWorldView.getBombView());
        campFireController = new CampFireController(lavaWorld.getCampFire(),lavaWorldView.getCampFireView());
        entityGhostController = new EntityGhostController(lavaWorld.getEntityGhost(),lavaWorldView.getEntityGhostView());
        lavaWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener());

        worldObjList.add(doorController);
        worldObjList.add(lavaRingController);
        worldObjList.add(bombController);
        worldObjList.add(campFireController);

    }

    public void render(float delta) {
        entityPlayerKeldeController.update(delta);
        for (IWorldObjectsController worldObjectsController: worldObjList){
            worldObjectsController.update(delta);
        }
        entityGhostController.update(delta);
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

    @Override
    public void setKeyDown(int keycode) {
        entityPlayerKeldeController.setKeyDown(keycode);
    }

    @Override
    public void setKeyUp(int keycode) {
        entityPlayerKeldeController.setKeyUp(keycode);
    }
}