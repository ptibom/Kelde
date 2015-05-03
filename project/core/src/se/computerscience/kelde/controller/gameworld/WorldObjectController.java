package se.computerscience.kelde.controller.gameworld;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import se.computerscience.kelde.model.gameworld.WorldObjectModel;
import se.computerscience.kelde.model.physics.WorldPhysics;

/**
 * Created by Hossein on 2015-04-27.
 */
public class WorldObjectController {
    public void setObjBody(Body objBody) {
        this.objBody = objBody;
    }

    private final float BOX2D_SCALE = 0.01f;
    private int x; // objects x position
    private int y; // objects y position
    private boolean isMoveable; // controlls if object will be moveable or not.
    private Body objBody; // the object body from libgdx

    public BodyDef getObjBodyDef() {
        return objBodyDef;
    }

    private BodyDef objBodyDef = new BodyDef();
    WorldObjectModel worldObjectModel = new WorldObjectModel();


    public WorldObjectController(boolean isMoveable, int x, int y) {
        this.isMoveable = isMoveable;
        this.x = x;
        this.y = y;
        worldObjectModel.initWorld();
    }

    public void loadObj(WorldPhysics wp){
        objBodyDef.position.set(x*BOX2D_SCALE,y*BOX2D_SCALE);

        if (isMoveable){
            objBodyDef.type = BodyDef.BodyType.DynamicBody;
        }
        else{
            objBodyDef.type = BodyDef.BodyType.StaticBody;
        }

        objBody = wp.getBox2dWorld().createBody(objBodyDef);
        FixtureDef objFixtureDef = new FixtureDef();
        PolygonShape objShape = new PolygonShape();
        objShape.setAsBox(16*BOX2D_SCALE, 16*BOX2D_SCALE);
        objFixtureDef.shape = objShape;
        objBody.createFixture(objFixtureDef);
        //objBody.setLinearDamping(f);

    }

    public Body getObjBody() {
        return objBody;
    }
}
