package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.physics.box2d.Body;
import se.computerscience.kelde.model.gameworld.BarrelModel;
import se.computerscience.kelde.model.physics.WorldPhysics;

/**
 * Created by Hossein on 2015-04-27.
 */
public class BarrelController extends WorldObjectController {

    BarrelModel barrelModel = new BarrelModel();
    public BarrelController(boolean isMoveable, int x, int y) {
        super(isMoveable, x, y);
        barrelModel.initWorld();
    }

    @Override
    public void loadObj(WorldPhysics wp) {
        super.loadObj(wp);
    }

    @Override
    public Body getObjBody() {
        return super.getObjBody();
    }
}
