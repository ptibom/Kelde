/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.Screen;
import se.computerscience.kelde.controller.LavaContactListener;
import se.computerscience.kelde.controller.WorldContactListener;
import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.controller.worldobjects.DoorController;
import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.model.gameworld.LavaWorld;
import se.computerscience.kelde.view.gameworld.LavaWorldView;

import java.util.ArrayList;
import java.util.List;

public class LavaWorldController implements IWorldController {

    private final LavaWorld lavaWorld;
    private final LavaWorldView lavaWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;

    private final DoorController doorController;
    private boolean isCurrentScreen = false;
    private List<IWorldObjectsController> worldObjList = new ArrayList<>();

    public LavaWorldController() {
        lavaWorld = new LavaWorld();
        lavaWorldView = new LavaWorldView(lavaWorld);

        worldPhysicsController = new WorldPhysicsController(lavaWorld.getWorldPhysics(), lavaWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(lavaWorld.getEntityPlayerKelde(), lavaWorldView.getEntityPlayerKeldeView());

        doorController = new DoorController(lavaWorld.getDoor(), lavaWorldView.getDoorView());


        lavaWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new LavaContactListener());

    }

    public void render(float delta) {
        entityPlayerKeldeController.update(delta);
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

    public boolean isCurrentScreen() {
        return isCurrentScreen;
    }

    public void setIsCurrentScreen(boolean isCurrentScreen) {
        this.isCurrentScreen = isCurrentScreen;
    }
}