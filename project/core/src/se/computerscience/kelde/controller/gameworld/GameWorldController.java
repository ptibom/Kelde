/** Description: Controls the Game World.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.controller.gameworld;


import se.computerscience.kelde.controller.entities.*;
import se.computerscience.kelde.controller.physics.WorldContactListener;
import se.computerscience.kelde.controller.items.AxeController;
import se.computerscience.kelde.controller.items.SwordController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.controller.worldobjects.BarrelController;
import se.computerscience.kelde.controller.worldobjects.DoorController;
import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.controller.worldobjects.TreasureController;
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
    private final AxeController axeController2;
    private final SwordController swordController;
    private final SwordController swordController2;
    private final DoorController doorController;

    private List<IWorldObjectsController> worldObjList = new ArrayList<>();
    private final EntityBatController entityBatController;
    private final EntityEyeController entityEyeController;
    private final EntityGhostController entityGhostController;

    private List<EntityArrowController> keldeArrowList = new ArrayList<>();
    private final EntityArrowController entityArrowController1;
    private final EntityArrowController entityArrowController2;
    private final EntityArrowController entityArrowController3;

    public GameWorldController() {
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView(gameWorld);

        worldPhysicsController = new WorldPhysicsController(gameWorld.getWorldPhysics(), gameWorldView.getWorldPhysicsView());
        entityPlayerKeldeController = new EntityPlayerKeldeController(gameWorld.getEntityPlayerKelde(), gameWorldView.getEntityPlayerKeldeView());

        barrelController = new BarrelController(gameWorld.getBarrel(), gameWorldView.getBarrelView());
        treasureController = new TreasureController(gameWorld.getTreasure(), gameWorldView.getTreasureView());
        treasureController2 = new TreasureController(gameWorld.getTreasure2(), gameWorldView.getTreasureView2());

        axeController = new AxeController(gameWorld.getTreasure().getAxe(), gameWorldView.getAxeView());
        axeController2 = new AxeController(gameWorld.getTreasure2().getAxe(), gameWorldView.getAxeView2());
        swordController = new SwordController(gameWorld.getTreasure().getSword(), gameWorldView.getSwordView());
        swordController2 = new SwordController(gameWorld.getTreasure2().getSword(), gameWorldView.getSwordView2());

        doorController = new DoorController(gameWorld.getDoor(), gameWorldView.getDoorView());

        entityArrowController1 = new EntityArrowController(gameWorld.getEntityArrow1(), gameWorldView.getEntityArrowView1());
        entityArrowController2 = new EntityArrowController(gameWorld.getEntityArrow2(), gameWorldView.getEntityArrowView2());
        entityArrowController3 = new EntityArrowController(gameWorld.getEntityArrow3(), gameWorldView.getEntityArrowView3());

        keldeArrowList.add(entityArrowController1);
        keldeArrowList.add(entityArrowController2);
        keldeArrowList.add(entityArrowController3);

        worldObjList.add(barrelController);
        worldObjList.add(treasureController);
        worldObjList.add(entityPlayerKeldeController);
        worldObjList.add(treasureController2);
        worldObjList.add(axeController);
        worldObjList.add(axeController2);
        worldObjList.add(swordController);
        worldObjList.add(doorController);
        worldObjList.add(swordController2);


        gameWorld.getWorldPhysics().getIb2DWorld().getBox2DWorld().setContactListener(new WorldContactListener());

        entityBatController = new EntityBatController(gameWorld.getEntityBat(), gameWorldView.getEntityBatView());
        entityEyeController = new EntityEyeController(gameWorld.getEntityEye(), gameWorldView.getEntityEyeView());
        entityGhostController = new EntityGhostController(gameWorld.getEntityGhost(), gameWorldView.getEntityGhostView());
    }

    public void render(float delta) {
        entityPlayerKeldeController.update(delta);
        for (IWorldObjectsController worldObj : worldObjList) {
            worldObj.update(delta);
        }

        for(EntityArrowController arrow : keldeArrowList) {
            arrow.update(delta, gameWorldView.getEntityPlayerKeldeView().getPositionX(), gameWorldView.getEntityPlayerKeldeView().getPositionY());
        }

        entityBatController.update(delta);
        entityEyeController.update(delta);
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
        for(EntityArrowController arrow : keldeArrowList) {
            arrow.setKeyDown(keycode);
        }
        entityPlayerKeldeController.setKeyDown(keycode);
    }

    public void setKeyUp(int keycode) { entityPlayerKeldeController.setKeyUp(keycode);
    }
}
