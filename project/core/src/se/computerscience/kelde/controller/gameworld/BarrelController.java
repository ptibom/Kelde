package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import se.computerscience.kelde.model.gameworld.BarrelModel;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.gameworld.BarrelView;

/**
 * Created by Hossein on 2015-04-27.
 */
public class BarrelController implements IWorldObjectsController {
    BarrelModel barrelModel;
    BarrelView barrelView;
    public BarrelController(BarrelModel barrelModel, BarrelView barrelView) {
        this.barrelModel = barrelModel;
        this.barrelView = barrelView;
    }
    public void update(float delta){
        barrelModel.barrelMovement();
    }


}
