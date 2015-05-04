package se.computerscience.kelde.model.gameworld;

import com.badlogic.gdx.physics.box2d.BodyDef;
import se.computerscience.kelde.MyContactListener;
import se.computerscience.kelde.controller.gameworld.TreasureController;
import se.computerscience.kelde.model.encapsulation.box2d.EntityBody;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IEntityBody;
import se.computerscience.kelde.view.gameworld.TreasureView;

/**
 * Created by Hossein on 2015-04-28.
 */

public class TreasureModell implements IWorldObjectsModel {
    private final float BODY_WIDTH = 16, BODY_HEIGHT = 16;

    IEntityBody entityBody;

    public TreasureModell(IB2DWorld ib2DWorld,float x,float y) {
        entityBody = new EntityBody(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, BodyDef.BodyType.StaticBody, this);
    }

    public float getPositionY() {
        return entityBody.getPositionY()-BODY_HEIGHT;
    }
    public float getPositionX() {
        return entityBody.getPositionX() - BODY_WIDTH;
    }
}
