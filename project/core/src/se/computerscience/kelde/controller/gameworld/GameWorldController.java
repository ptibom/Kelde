/** Description: Controls the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;


import com.badlogic.gdx.Screen;
import se.computerscience.kelde.controller.WorldContactListener;
import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.items.AxeController;
import se.computerscience.kelde.controller.items.SwordController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;

import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.view.gameworld.GameWorldView;

import java.util.ArrayList;
import java.util.List;

public class GameWorldController {
    private final GameWorld gameWorld;
    private final GameWorldView gameWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;

    private final BarrelController barrelController;
    private final TreasureController treasureController;
    private final TreasureController treasureController2;
    private final AxeController axeController;
    private final SwordController swordController;
    private final SensorController doorController;

    private List<IWorldObjectsController> worldObjList = new ArrayList<>();

    public GameWorldController() {
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView(gameWorld);

        worldPhysicsController = new WorldPhysicsController(gameWorld.getWorldPhysics(), gameWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(gameWorld.getEntityPlayerKelde(), gameWorldView.getEntityPlayerKeldeView());

        barrelController = new BarrelController(gameWorld.getBarrelModel(), gameWorldView.getBarrelView());
        treasureController = new TreasureController(gameWorld.getTreasureModell(), gameWorldView.getTreasureView());
        treasureController2 = new TreasureController(gameWorld.getTreasureModell2(), gameWorldView.getTreasureView2());
        axeController = new AxeController(gameWorld.getAxeModel(), gameWorldView.getAxeView());
        swordController = new SwordController(gameWorld.getSwordModel(), gameWorldView.getSwordView());
        doorController = new SensorController(gameWorld.getDoorModel(), gameWorldView.getDoorView());

        worldObjList.add(barrelController);              // pos 0
        worldObjList.add(treasureController);            // pos 1
        worldObjList.add(entityPlayerKeldeController);   // pos 2
        worldObjList.add(treasureController2);           // pos 3
        worldObjList.add(axeController);                 // pos 4
        worldObjList.add(swordController);               // pos 5
        worldObjList.add(doorController);                // pos 6

        gameWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener(worldObjList));
    }

    public void render(float delta) {
        barrelController.update(delta);
        entityPlayerKeldeController.update(delta);
        worldPhysicsController.update(delta);
        gameWorldView.render(delta);
    }

    public void resizeCamera(int width, int height) {
        // Make sure to resize camera to prevent stretching.
        gameWorld.resizeCamera(width, height);
        gameWorldView.updateProjectionMatrix();
        worldPhysicsController.resizeCamera(width, height);
    }

    public void dispose() {
        // Release resources.
        gameWorldView.dispose();
        gameWorld.dispose();
        worldPhysicsController.dispose();
    }
}