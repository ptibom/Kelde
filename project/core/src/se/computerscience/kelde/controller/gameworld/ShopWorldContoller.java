/**
 * Description: 
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.Screen;
import se.computerscience.kelde.WorldContactListener;
import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.model.gameworld.ShopWorld;
import se.computerscience.kelde.view.gameworld.ShopWorldView;

import java.util.ArrayList;
import java.util.List;

public class ShopWorldContoller {
    ShopWorld shopWorld;
    ShopWorldView shopWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;
    private final SensorController sensorController;

    private List<IWorldObjectsController> worldObjList = new ArrayList<>();

    public ShopWorldContoller(Screen screen){
        shopWorld = new ShopWorld();
        shopWorldView = new ShopWorldView(shopWorld);
        worldPhysicsController = new WorldPhysicsController(shopWorld.getWorldPhysics(), shopWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(shopWorld.getEntityPlayerKelde(), shopWorldView.getEntityPlayerKeldeView());
        sensorController = new SensorController(shopWorld.getSensorModel(),shopWorldView.getSensorView());

        worldObjList.add(sensorController);
        shopWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener(worldObjList,screen));
    }

    public void render(float delta) {
        entityPlayerKeldeController.update(delta);
        worldPhysicsController.update(delta);
        shopWorldView.render(delta);

    }

    public void resizeCamera(int width, int height) {
        // Make sure to resize camera to prevent stretching.
        shopWorld.resizeCamera(width, height);
        shopWorldView.updateProjectionMatrix();
        worldPhysicsController.resizeCamera(width, height);
    }

    public void dispose() {
        // Release resources.
        shopWorldView.dispose();
        shopWorld.dispose();
        worldPhysicsController.dispose();
    }
}