/** Description: Controls the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;

import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.controller.items.ItemEntityController;
import se.computerscience.kelde.controller.entities.EntityGhostController;
import se.computerscience.kelde.controller.physics.WorldContactListener;
import se.computerscience.kelde.controller.entities.EntityBatController;
import se.computerscience.kelde.controller.entities.EntityEyeController;
import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.controller.worldobjects.*;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.view.gameworld.GameWorldView;

import java.util.ArrayList;
import java.util.List;

public class GameWorldController implements IGameWorldController,IItemEventHandler {
    private final GameWorld gameWorld;
    private final GameWorldView gameWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;

    private final BarrelController barrelController;
    private final TreasureController treasureController;
    private final TreasureController treasureController2;
    private final DoorController doorController;

    private List<IWorldObjectsController> worldObjList = new ArrayList<>();

    private final EntityBatController entityBatController;
    private final EntityEyeController entityEyeController;
    private final EntityGhostController entityGhostController;
    private final List<ItemEntityController> itemEntityControllers = new ArrayList<>();

    private final BombController bombController;
    public GameWorldController() {
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView(gameWorld);

        worldPhysicsController = new WorldPhysicsController(gameWorld.getWorldPhysics(), gameWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(gameWorld.getEntityPlayerKelde(), gameWorldView.getEntityPlayerKeldeView());

        barrelController = new BarrelController(gameWorld.getBarrel(), gameWorldView.getBarrelView());
        treasureController = new TreasureController(gameWorld.getTreasure(), gameWorldView.getTreasureView());
        treasureController2 = new TreasureController(gameWorld.getTreasure2(), gameWorldView.getTreasureView2());
        doorController = new DoorController(gameWorld.getDoor(), gameWorldView.getDoorView(), ScreenEvent.ScreenTag.LAVA_WORLD);
        bombController = new BombController(gameWorld.getBomb(),gameWorldView.getBombView());

        worldObjList.add(barrelController);
        worldObjList.add(treasureController);
        worldObjList.add(entityPlayerKeldeController);
        worldObjList.add(treasureController2);
        worldObjList.add(doorController);

        gameWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener());

        entityBatController = new EntityBatController(gameWorld.getEntityBat(), gameWorldView.getEntityBatView());
        entityEyeController = new EntityEyeController(gameWorld.getEntityEye(), gameWorldView.getEntityEyeView());
        entityGhostController = new EntityGhostController(gameWorld.getEntityGhost(), gameWorldView.getEntityGhostView());
        ItemEventBus.INSTANCE.register(this);
    }
    public void updateItemControllers(){
        if (itemEntityControllers.size() == gameWorld.getItemEntities().size()){
            return;
        }
        for (int i = itemEntityControllers.size(); i < gameWorld.getItemEntities().size() ;i++) {
            itemEntityControllers.add(new ItemEntityController(gameWorld.getItemEntities().get(i) , gameWorldView.getItemEntityViews().get(i)));
        }
    }
    public void render(float delta) {
        updateItemControllers();
        entityPlayerKeldeController.update(delta);
        for (IWorldObjectsController worldObj : worldObjList) {
            worldObj.update(delta);
        }

        for (ItemEntityController entityControllerlist : itemEntityControllers ){
            entityControllerlist.update(delta);
        }

        entityBatController.update(delta);
        entityEyeController.update(delta);
        bombController.update(delta);
        entityGhostController.update(delta);
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
        CollisionEventBus.INSTANCE.unregisterAll();
        ItemEventBus.INSTANCE.unregisterAll();
        gameWorldView.dispose();
        gameWorld.dispose();
        worldPhysicsController.dispose();
    }

    public void setKeyDown(int keycode) {
        entityPlayerKeldeController.setKeyDown(keycode);
    }

    public void setKeyUp(int keycode) { entityPlayerKeldeController.setKeyUp(keycode);
    }

    @Override
    public void onItemEvent(ItemEvent event) {
        if (!(event.getObject() instanceof IItem|| event.getObject() instanceof ItemEntityController)){
            return;
        }
        if (event.getTag() == ItemEvent.Tag.ITEM) {
            gameWorld.addItems((IItem) event.getObject());
            gameWorldView.addEntityViews(gameWorld.getItemEntities().get(gameWorld.getItemEntities().size()-1));
        }
        if (event.getTag() == ItemEvent.Tag.DEL_ITEM){
            gameWorld.removeItem(((ItemEntityController) event.getObject()).getItemEntity());
            gameWorldView.removeItemView(((ItemEntityController) event.getObject()).getItemEntityView());
            itemEntityControllers.remove(event.getObject());
        }
    }
}
