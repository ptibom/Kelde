/** Description: Controls the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;


import se.computerscience.kelde.controller.events.IItemEventHandler;
import se.computerscience.kelde.controller.events.ItemEvent;
import se.computerscience.kelde.controller.events.ItemEventBus;
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
import se.computerscience.kelde.model.worldobjects.ItemEntity;
import se.computerscience.kelde.view.gameworld.GameWorldView;
import se.computerscience.kelde.view.items.ItemEntityView;

import java.util.ArrayList;
import java.util.List;

public class GameWorldController implements IItemEventHandler{
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
        doorController = new DoorController(gameWorld.getDoor(), gameWorldView.getDoorView());

        bombController = new BombController(gameWorld.getBomb(),gameWorldView.getBombView());


        worldObjList.add(barrelController);
        worldObjList.add(treasureController);
        worldObjList.add(entityPlayerKeldeController);
        worldObjList.add(treasureController2);
        worldObjList.add(doorController);

        gameWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener());

        entityBatController = new EntityBatController(gameWorld.getEntityBat(), gameWorldView.getEntityBatView());
        entityEyeController = new EntityEyeController(gameWorld.getEntityEye(), gameWorldView.getEntityEyeView());
        ItemEventBus.INSTANCE.register(this);
        entityGhostController = new EntityGhostController(gameWorld.getEntityGhost(), gameWorldView.getEntityGhostView());
    }

    public void render(float delta) {
        entityPlayerKeldeController.update(delta);
        for (IWorldObjectsController worldObj : worldObjList) {
            worldObj.update(delta);
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
    public void onEvent(ItemEvent event) {
        if (!(event.getObject() instanceof IItem || event.getObject() instanceof ItemEntity || event.getObject() instanceof ItemEntityView)){
            return;
        }
        if (event.getTag() == ItemEvent.Tag.ITEM) {
            gameWorld.addItems((IItem) event.getObject());
            ItemEventBus.INSTANCE.publish(new ItemEvent(ItemEvent.Tag.ITEM_ENTITY,gameWorld.getItemEntities().get(gameWorld.getItemEntities().size()-1)));
        }
        if (event.getTag() == ItemEvent.Tag.ITEM_ENTITY){
            for (ItemEntity itemEntity : gameWorld.getItemEntities()) {
                gameWorldView.addEntityViews(itemEntity);
                ItemEventBus.INSTANCE.publish(new ItemEvent(ItemEvent.Tag.ITEM_CTRL,gameWorldView.getItemEntityViews().get(gameWorldView.getItemEntityViews().size()-1) ));
            }
        }
        //itemEntityControllers.add(new ItemEntityController(itemEntity,gameWorldView.getItemEntityViews().get(gameWorldView.getItemEntityViews().size()-1)));
        //itemEntityControllers.add(new ItemEntityController(null,null));
    }
}