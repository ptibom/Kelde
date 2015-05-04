/** Description: Controls the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;


import se.computerscience.kelde.MyContactListener;
import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;

import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.gameworld.IWorldObjectsModel;
import se.computerscience.kelde.view.gameworld.GameWorldView;

public class GameWorldController {
    private final GameWorld gameWorld;
    private final GameWorldView gameWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;

    private final BarrelController barrelController;
    private final TreasureController treasureController;

    private IWorldObjectsController[] worldObjectsList;

    public GameWorldController() {
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView(gameWorld);
        worldPhysicsController = new WorldPhysicsController(gameWorld.getWorldPhysics(), gameWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(gameWorld.getEntityPlayerKelde(), gameWorldView.getEntityPlayerKeldeView());

        barrelController = new BarrelController(gameWorld.getBarrelModel(), gameWorldView.getBarrelView());
        treasureController = new TreasureController(gameWorld.getTreasureModell(), gameWorldView.getTreasureView());

        worldObjectsList = new IWorldObjectsController[3];
        worldObjectsList[0] = barrelController;
        worldObjectsList[1] = treasureController;
        worldObjectsList[2] = entityPlayerKeldeController;

        gameWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new MyContactListener(worldObjectsList));

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
