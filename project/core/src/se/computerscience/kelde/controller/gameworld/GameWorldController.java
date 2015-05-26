/** Description: Controls the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;

import java.util.ArrayList;
import se.computerscience.kelde.controller.entities.*;
import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.controller.items.ItemEntityController;
import se.computerscience.kelde.controller.physics.WorldContactListener;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.controller.worldobjects.*;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.view.gameworld.GameWorldView;
import java.util.List;

public class GameWorldController implements IGameWorldController,IItemEventHandler {
    private final GameWorld gameWorld;
    private final GameWorldView gameWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;
    private final List<IWorldObjectsController> worldObjList = new ArrayList<>();
    private final List<IMonsterController> monsterList = new ArrayList<>();
    private final List<ItemEntityController> itemEntityControllers = new ArrayList<>();

    public GameWorldController() {
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView(gameWorld);

        worldPhysicsController = new WorldPhysicsController(gameWorld.getWorldPhysics(), gameWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(gameWorld.getEntityPlayerKelde());

        initGameWorldControllers();

        worldObjList.add(entityPlayerKeldeController);

        gameWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener());
        ItemEventBus.INSTANCE.register(this);
    }
    public void updateItemControllers(){
        if (itemEntityControllers.size() == gameWorld.getItemEntities().size()){
            return;
        }
        for (int i = itemEntityControllers.size(); i < gameWorld.getItemEntities().size() ;i++) {
            itemEntityControllers.add(itemEntityController(i));
        }
    }

    public ItemEntityController itemEntityController(int i){
        return new ItemEntityController(gameWorld.getItemEntities().get(i) , gameWorldView.getItemEntityViews().get(i));
    }
    public void render(float delta) {
        updateItemControllers();
        entityPlayerKeldeController.update(delta);
        for (final IWorldObjectsController worldObj : worldObjList) {
            worldObj.update(delta);
        }

        for (final ItemEntityController entityControllerlist : itemEntityControllers ){
            entityControllerlist.update(delta);
        }
        for (final IMonsterController monster: monsterList){
            monster.update(delta);
        }

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

    private final void initGameWorldControllers(){
        for (int i = 0; i < gameWorld.getBombs().size() ; i++) {
            worldObjList.add(bombController(i));
        }
        for (int i = 0; i < gameWorld.getTreasures().size() ; i++) {
            worldObjList.add(treasureController(i));
        }
        for (int i = 0; i < gameWorld.getCampFires().size() ; i++) {
            worldObjList.add(campFireController(i));
        }
        for (int i = 0; i < gameWorld.getDoors().size() ; i++) {
            worldObjList.add(doorController(i));
        }
        for (int i = 0; i < gameWorld.getEntityBats().size() ; i++) {
            monsterList.add(entityBatController(i));
        }
        for (int i = 0; i < gameWorld.getEntityGhosts().size() ; i++) {
            monsterList.add(entityGhostController(i));
        }
        for (int i = 0; i < gameWorld.getEntityEyes().size() ; i++) {
            monsterList.add(entityEyeController(i));
        }
    }
    public BombController bombController(int i){
        return new BombController(gameWorld.getBombs().get(i),gameWorldView.getBombViews().get(i));
    }
    public TreasureController treasureController(int i){
        return new TreasureController(gameWorld.getTreasures().get(i),gameWorldView.getTreasureViews().get(i));
    }
    public CampFireController campFireController(int i){
        return new CampFireController(gameWorld.getCampFires().get(i),gameWorldView.getCampFireViews().get(i));
    }
    public DoorController doorController(int i){
        return new DoorController(gameWorld.getDoors().get(i));
    }
    public EntityBatController entityBatController(int i){
        return new EntityBatController(gameWorld.getEntityBats().get(i),gameWorldView.getEntityBatViews().get(i));
    }
    public EntityGhostController entityGhostController(int i){
        return new EntityGhostController(gameWorld.getEntityGhosts().get(i),gameWorldView.getEntityGhostViews().get(i));
    }
    public EntityEyeController entityEyeController(int i){
        return new EntityEyeController(gameWorld.getEntityEyes().get(i),gameWorldView.getEntityEyeViews().get(i));
    }
}
