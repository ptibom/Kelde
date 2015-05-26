/** Description: Controls the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;

import java.util.ArrayList;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import se.computerscience.kelde.controller.entities.*;
import se.computerscience.kelde.controller.events.*;
import se.computerscience.kelde.controller.items.ItemEntityController;
import se.computerscience.kelde.controller.physics.WorldContactListener;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.controller.worldobjects.*;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.entities.IEntitie;
import se.computerscience.kelde.model.gameworld.GameWorld;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.model.worldobjects.IWorldObjects;
import se.computerscience.kelde.view.entities.IEntitieView;
import se.computerscience.kelde.view.gameworld.GameWorldView;
import se.computerscience.kelde.view.worldobjects.IWorldObjectView;

import java.util.List;

public class GameWorldController implements IGameWorldController,IItemEventHandler {
    private final GameWorld gameWorld;
    private final GameWorldView gameWorldView;
    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;
    private final List<IWorldObjectsController> worldObjectsControllers = new ArrayList<>();
    private final List<IMonsterController> npcControllers = new ArrayList<>();
    private final List<ItemEntityController> itemEntityControllers = new ArrayList<>();


    public GameWorldController() {
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView(gameWorld);
        createWorldObjects();
        createNPCEntities();
        worldPhysicsController = new WorldPhysicsController(gameWorld.getWorldPhysics(), gameWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(gameWorld.getEntityPlayerKelde());
        worldObjectsControllers.add(entityPlayerKeldeController);

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
    private void createWorldObjects() {
        final IMap map = gameWorld.getMap();
        final MapLayer layer = map.getTiledMap().getLayers().get("GameWorld");
        final IB2DWorld b2DWorld = gameWorld.getWorldPhysics().getIb2DWorld();
        for (final MapObject mapObject : layer.getObjects()) {
            final IWorldObjects modelObject;
            final IWorldObjectView viewObject;
            final IWorldObjectsController controllerObject;
            final float x = (float) mapObject.getProperties().get("x");
            final float y = (float) mapObject.getProperties().get("y");
            final String prop = (String) mapObject.getProperties().get("Extra");
            try {
                final Class modelCls = Class.forName("se.computerscience.kelde.model.worldobjects."+mapObject.getName());
                final Class viewCls = Class.forName("se.computerscience.kelde.view.worldobjects."+mapObject.getName()+"View");
                final Class controllerCls = Class.forName("se.computerscience.kelde.controller.worldobjects." + mapObject.getName() + "Controller");
                if (prop == null){
                    modelObject = (IWorldObjects)modelCls.getConstructor(IB2DWorld.class,float.class,float.class).newInstance(b2DWorld, x, y);
                }else {
                    modelObject = (IWorldObjects)modelCls.getConstructor(IB2DWorld.class,float.class,float.class,String.class).newInstance(b2DWorld, x, y, prop);
                }
                viewObject = (IWorldObjectView)viewCls.getConstructor(modelCls).newInstance(modelObject);
                controllerObject = (IWorldObjectsController) controllerCls.getConstructor(modelCls, viewCls).newInstance(modelObject,viewObject);
                gameWorldView.addWorldObject(viewObject);
                worldObjectsControllers.add(controllerObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void createNPCEntities() {
        final IMap map = gameWorld.getMap();
        IEntitie modelObject;
        IEntitieView viewObject;
        IMonsterController controllerObject;
        final MapLayer layer = map.getTiledMap().getLayers().get("Npc");
        final IB2DWorld b2DWorld = gameWorld.getWorldPhysics().getIb2DWorld();
        for (final MapObject mapObject : layer.getObjects()) {
            final float x = (float) mapObject.getProperties().get("x");
            final float y = (float) mapObject.getProperties().get("y");
            try {
                final Class modelCls = Class.forName("se.computerscience.kelde.model.entities."+mapObject.getName());
                final Class viewCls = Class.forName("se.computerscience.kelde.view.entities."+mapObject.getName()+"View");
                final Class controllerCls = Class.forName("se.computerscience.kelde.controller.entities." + mapObject.getName() + "Controller");
                modelObject = (IEntitie)modelCls.getConstructor(float.class,float.class,IB2DWorld.class).newInstance(x, y,b2DWorld);
                viewObject = (IEntitieView)viewCls.getConstructor(modelCls).newInstance(modelObject);
                controllerObject = (IMonsterController) controllerCls.getConstructor(modelCls, viewCls).newInstance(modelObject,viewObject);
                gameWorldView.addNPCEntity(viewObject);
                npcControllers.add(controllerObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void render(float delta) {
        updateItemControllers();
        entityPlayerKeldeController.update(delta);
        for (final IWorldObjectsController worldObj : worldObjectsControllers) {
            worldObj.update(delta);
        }

        for (final ItemEntityController entityControllerlist : itemEntityControllers ){
            entityControllerlist.update(delta);
        }
        for (final IMonsterController monster: npcControllers){
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

}
