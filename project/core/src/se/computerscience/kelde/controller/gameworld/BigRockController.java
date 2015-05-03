package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.physics.box2d.Body;
import se.computerscience.kelde.model.gameworld.BarrelModel;
import se.computerscience.kelde.model.gameworld.BigRockModel;
import se.computerscience.kelde.model.physics.WorldPhysics;

/**
 * Created by Hassan on 2015-04-27.
 */
public class BigRockController extends WorldObjectController {
    BigRockModel bigRockModel = new BigRockModel();
    public BigRockController(boolean isMoveable, int x, int y) {
        super(isMoveable, x, y);
        bigRockModel.initWorld();
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