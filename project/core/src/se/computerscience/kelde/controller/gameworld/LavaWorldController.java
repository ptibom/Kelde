/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import se.computerscience.kelde.controller.entities.EntityPlayerKeldeController;
import se.computerscience.kelde.controller.entities.IMonsterController;
import se.computerscience.kelde.controller.events.CollisionEventBus;
import se.computerscience.kelde.controller.events.IItemEventHandler;
import se.computerscience.kelde.controller.events.ItemEvent;
import se.computerscience.kelde.controller.events.ItemEventBus;
import se.computerscience.kelde.controller.items.ItemEntityController;
import se.computerscience.kelde.controller.physics.WorldContactListener;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.controller.worldobjects.*;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.entities.INPCEntity;
import se.computerscience.kelde.model.gameworld.LavaWorld;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.model.worldobjects.IWorldObjects;
import se.computerscience.kelde.view.entities.IEntityView;
import se.computerscience.kelde.view.gameworld.LavaWorldView;
import se.computerscience.kelde.view.worldobjects.IWorldObjectView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LavaWorldController implements IGameWorldController, IItemEventHandler{

    private final LavaWorld lavaWorld;
    private final LavaWorldView lavaWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;
    private final List<IWorldObjectsController> worldObjectsControllers = new ArrayList<>();
    private final List<IMonsterController> npcControllers = new ArrayList<>();
    private final List<ItemEntityController> itemEntityControllers = new ArrayList<>();
    private Logger logger;
    public LavaWorldController() {
        lavaWorld = new LavaWorld();
        lavaWorldView = new LavaWorldView(lavaWorld);
        createWorldObjects();
        createNPCEntities();
        worldPhysicsController = new WorldPhysicsController(lavaWorld.getWorldPhysics(), lavaWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(lavaWorld.getEntityPlayerKelde());
        ItemEventBus.INSTANCE.register(this);

        lavaWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener());

    }
    public void updateItemControllers(){
        if (itemEntityControllers.size() == lavaWorld.getItemEntities().size()){
            return;
        }
        for (int i = itemEntityControllers.size(); i < lavaWorld.getItemEntities().size() ;i++) {
            itemEntityControllers.add(itemEntityController(i));
        }
    }

    public ItemEntityController itemEntityController(int i){
        return new ItemEntityController(lavaWorld.getItemEntities().get(i) , lavaWorldView.getItemEntityViews().get(i));
    }

    private void createWorldObjects() {
        final IMap map = lavaWorld.getMap();
        final MapLayer layer = map.getTiledMap().getLayers().get("GameWorld");
        for (final MapObject mapObject : layer.getObjects()) {
            final IWorldObjects modelObject;
            final float x = (float) mapObject.getProperties().get("x");
            final float y = (float) mapObject.getProperties().get("y");
            final String prop = (String) mapObject.getProperties().get("Extra");
            try {
                final IB2DWorld b2DWorld = lavaWorld.getWorldPhysics().getIb2DWorld();
                final Class modelCls = Class.forName("se.computerscience.kelde.model.worldobjects."+mapObject.getName());
                final Class viewCls = Class.forName("se.computerscience.kelde.view.worldobjects."+mapObject.getName()+"View");
                final Class controllerCls = Class.forName("se.computerscience.kelde.controller.worldobjects." + mapObject.getName() + "Controller");
                if (prop == null){
                    modelObject = (IWorldObjects)modelCls.getConstructor(IB2DWorld.class,float.class,float.class).newInstance(b2DWorld, x, y);
                }else {
                    modelObject = (IWorldObjects)modelCls.getConstructor(IB2DWorld.class,float.class,float.class,String.class).newInstance(b2DWorld, x, y, prop);
                }
                final IWorldObjectView viewObject = (IWorldObjectView)viewCls.getConstructor(modelCls).newInstance(modelObject);
                final IWorldObjectsController controllerObject = (IWorldObjectsController) controllerCls.getConstructor(modelCls, viewCls).newInstance(modelObject,viewObject);
                lavaWorldView.addWorldObject(viewObject);
                worldObjectsControllers.add(controllerObject);
            } catch (Exception e) {
                logger.log(Level.WARNING, e.toString());
            }
        }
    }
    private void createNPCEntities() {
        final IMap map = lavaWorld.getMap();
        final MapLayer layer = map.getTiledMap().getLayers().get("Npc");
        for (final MapObject mapObject : layer.getObjects()) {
            final float x = (float) mapObject.getProperties().get("x");
            final float y = (float) mapObject.getProperties().get("y");
            try {
                final IB2DWorld b2DWorld = lavaWorld.getWorldPhysics().getIb2DWorld();
                final Class modelCls = Class.forName("se.computerscience.kelde.model.entities."+mapObject.getName());
                final Class viewCls = Class.forName("se.computerscience.kelde.view.entities."+mapObject.getName()+"View");
                final Class controllerCls = Class.forName("se.computerscience.kelde.controller.entities." + mapObject.getName() + "Controller");
                final INPCEntity modelObject = (INPCEntity)modelCls.getConstructor(float.class,float.class,IB2DWorld.class).newInstance(x, y,b2DWorld);
                final IEntityView viewObject = (IEntityView)viewCls.getConstructor(modelCls).newInstance(modelObject);
                final IMonsterController controllerObject = (IMonsterController) controllerCls.getConstructor(modelCls, viewCls).newInstance(modelObject,viewObject);
                lavaWorldView.addNPCEntity(viewObject);
                npcControllers.add(controllerObject);
            } catch (Exception e) {
                logger.log(Level.WARNING, e.toString());
            }
        }
    }
    public void render(float delta) {
        updateItemControllers();
        entityPlayerKeldeController.update(delta);
        for (final IWorldObjectsController worldObj : worldObjectsControllers) {
            worldObj.update(delta);
        }
        for (final IMonsterController monster: npcControllers){
            monster.update(delta);
        }
        for (final ItemEntityController entityControllerlist : itemEntityControllers ){
            entityControllerlist.update(delta);
        }
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
        CollisionEventBus.INSTANCE.unregisterAll();
        ItemEventBus.INSTANCE.unregisterAll();
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

    @Override
    public void setMouseDown(int x, int y) {

    }

    @Override
    public void onItemEvent(ItemEvent event) {
        if (!(event.getObject() instanceof IItem || event.getObject() instanceof ItemEntityController)){
            return;
        }
        if (event.getTag() == ItemEvent.Tag.ITEM) {
            lavaWorld.addItems((IItem) event.getObject());
            lavaWorldView.addEntityViews(lavaWorld.getItemEntities().get(lavaWorld.getItemEntities().size() - 1));
        }
        if (event.getTag() == ItemEvent.Tag.DEL_ITEM){
            lavaWorld.removeItem(((ItemEntityController) event.getObject()).getItemEntity());
            lavaWorldView.removeItemView(((ItemEntityController) event.getObject()).getItemEntityView());
            itemEntityControllers.remove(event.getObject());
        }
    }
}