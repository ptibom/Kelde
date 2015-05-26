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
import se.computerscience.kelde.controller.physics.WorldContactListener;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.controller.worldobjects.*;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.libgdx.IMap;
import se.computerscience.kelde.model.entities.IEntitie;
import se.computerscience.kelde.model.gameworld.LavaWorld;
import se.computerscience.kelde.model.worldobjects.IWorldObjects;
import se.computerscience.kelde.view.entities.IEntitieView;
import se.computerscience.kelde.view.gameworld.LavaWorldView;
import se.computerscience.kelde.view.worldobjects.IWorldObjectView;

import java.util.ArrayList;
import java.util.List;

public class LavaWorldController implements IGameWorldController{

    private final LavaWorld lavaWorld;
    private final LavaWorldView lavaWorldView;

    private final WorldPhysicsController worldPhysicsController;
    private final EntityPlayerKeldeController entityPlayerKeldeController;
    private final List<IWorldObjectsController> worldObjectsControllers = new ArrayList<>();
    private final List<IMonsterController> npcControllers = new ArrayList<>();

    public LavaWorldController() {
        lavaWorld = new LavaWorld();
        lavaWorldView = new LavaWorldView(lavaWorld);
        createWorldObjects();
        createNPCEntities();
        worldPhysicsController = new WorldPhysicsController(lavaWorld.getWorldPhysics(), lavaWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(lavaWorld.getEntityPlayerKelde());


        lavaWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener());

    }
    private void createWorldObjects() {
        final IMap map = lavaWorld.getMap();
        final MapLayer layer = map.getTiledMap().getLayers().get("GameWorld");
        final IB2DWorld b2DWorld = lavaWorld.getWorldPhysics().getIb2DWorld();
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
                if (prop != null){
                    modelObject = (IWorldObjects)modelCls.getConstructor(IB2DWorld.class,float.class,float.class,String.class).newInstance(b2DWorld, x, y, prop);
                }else {
                    modelObject = (IWorldObjects)modelCls.getConstructor(IB2DWorld.class,float.class,float.class).newInstance(b2DWorld, x, y);
                }
                viewObject = (IWorldObjectView)viewCls.getConstructor(modelCls).newInstance(modelObject);
                controllerObject = (IWorldObjectsController) controllerCls.getConstructor(modelCls, viewCls).newInstance(modelObject,viewObject);
                lavaWorldView.addWorldObject(viewObject);
                worldObjectsControllers.add(controllerObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private void createNPCEntities() {
        final IMap map = lavaWorld.getMap();
        IEntitie modelObject;
        IEntitieView viewObject;
        IMonsterController controllerObject;
        final MapLayer layer = map.getTiledMap().getLayers().get("Npc");
        final IB2DWorld b2DWorld = lavaWorld.getWorldPhysics().getIb2DWorld();
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
                lavaWorldView.addNPCEntity(viewObject);
                npcControllers.add(controllerObject);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void render(float delta) {
        entityPlayerKeldeController.update(delta);
        for (final IWorldObjectsController worldObj : worldObjectsControllers) {
            worldObj.update(delta);
        }
        for (final IMonsterController monster: npcControllers){
            monster.update(delta);
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
}