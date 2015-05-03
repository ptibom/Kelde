package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.*;
import se.computerscience.kelde.model.gameworld.TreasureModell;
import se.computerscience.kelde.model.physics.WorldPhysics;
import se.computerscience.kelde.view.gameworld.BarrelView;
import se.computerscience.kelde.view.gameworld.TreasureView;

/**
 * Created by Hossein on 2015-04-28.
 */
public class TreasureController extends WorldObjectController{
    private World world;
    private TreasureModell treasureModell = new TreasureModell();
    public TreasureController(World world, boolean isMoveable, int x, int y) {
        super(isMoveable, x, y);
        this.world = world;
        treasureModell.initWorld();
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