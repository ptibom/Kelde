package se.computerscience.kelde.model.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import se.computerscience.kelde.controller.gameworld.GameWorldController;
import se.computerscience.kelde.controller.physics.WorldPhysicsController;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.gameworld.GameWorldView;
import se.computerscience.kelde.view.physics.WorldPhysicsView;

/**
 * Created by Hossein on 2015-04-27.
 */
public class WorldObjectModel {

    private GameWorldController gameWorldController;
    private GameWorldView gameWorldView;

    private WorldPhysics worldPhysics;
    private WorldPhysicsView worldPhysicsView;
    private WorldPhysicsController worldPhysicsController;

    private GameWorld gameWorld;

    public void initWorld(){
        // Initialises objects, like a constructor
        gameWorld = new GameWorld();
        gameWorldView = new GameWorldView(gameWorld);
        //gameWorldController = new GameWorldController(gameWorld, gameWorldView);
        gameWorldController = new GameWorldController();

        worldPhysics = new WorldPhysics(gameWorld.getMap());

        worldPhysicsView = new WorldPhysicsView(worldPhysics);
        worldPhysicsController = new WorldPhysicsController(worldPhysics, worldPhysicsView);
    }
}