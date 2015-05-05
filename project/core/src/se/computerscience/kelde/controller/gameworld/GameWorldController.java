/** Description: Controls the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;


import se.computerscience.kelde.WorldContactListener;
import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.items.AxeController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;

import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.view.gameworld.GameWorldView;

public class GameWorldController {
    private final GameWorld gameWorld;
    private final GameWorldView gameWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;

    private final BarrelController barrelController;
    private final TreasureController treasureController;
    private final TreasureController treasureController2;
    private final AxeController axeController;

    private IWorldObjectsController[] worldObjectsList;

    public GameWorldController() {
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView(gameWorld);
        worldPhysicsController = new WorldPhysicsController(gameWorld.getWorldPhysics(), gameWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(gameWorld.getEntityPlayerKelde(), gameWorldView.getEntityPlayerKeldeView());

        barrelController = new BarrelController(gameWorld.getBarrelModel(), gameWorldView.getBarrelView());
        treasureController = new TreasureController(gameWorld.getTreasureModell(), gameWorldView.getTreasureView());
        treasureController2 = new TreasureController(gameWorld.getTreasureModell2(), gameWorldView.getTreasureView2());
        axeController = new AxeController(gameWorld.getAxeModel(),gameWorldView.getAxeView());

        worldObjectsList = new IWorldObjectsController[5];
        worldObjectsList[0] = barrelController;
        worldObjectsList[1] = treasureController;
        worldObjectsList[3] = treasureController2;
        worldObjectsList[2] = entityPlayerKeldeController;
        worldObjectsList[4] = axeController;

        gameWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener(worldObjectsList));

    }

    public void render(float delta) {
        barrelController.update(delta);
        //treasureController.update(delta);

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
