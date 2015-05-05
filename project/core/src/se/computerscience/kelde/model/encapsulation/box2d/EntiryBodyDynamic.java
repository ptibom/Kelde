package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.*;
import se.computerscience.kelde.model.physics.WorldPhysics;

/**
 * Created by Hassan on 2015-05-05.
 */
public class EntiryBodyDynamic implements IEntityBody {
    private final World worldPhysics;
    private final Body body;
    private final FixtureDef fdef = new FixtureDef();
    private BodyDef def;

    public EntiryBodyDynamic(float x, float y, float width, float height, IB2DWorld ib2DWorld, Object userdata) {
        worldPhysics = ib2DWorld.getBox2DWorld();
        def = new BodyDef();
        def.position.set(x* WorldPhysics.BOX2D_SCALE, y*WorldPhysics.BOX2D_SCALE);
        def.type = BodyDef.BodyType.DynamicBody;
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width*WorldPhysics.BOX2D_SCALE, height*WorldPhysics.BOX2D_SCALE);
        fdef.shape = shape;
        fdef.isSensor = false;
        body = ib2DWorld.getBox2DWorld().createBody(def);
        body.createFixture(fdef).setUserData(userdata);
    }

    public Body getBody() {
        return body;
    }

    public FixtureDef getFdef() {
        return fdef;
    }

    @Override
    public void setVelocity(float x, float y) {
        // x & y is meters per second. Not pixels.
        body.setLinearVelocity(x, y);
    }

    @Override
    public float getPositionY() {
        return body.getPosition().y/WorldPhysics.BOX2D_SCALE;
    }

    @Override
    public float getPositionX() {
        return body.getPosition().x/WorldPhysics.BOX2D_SCALE;
    }

    @Override
    public void destroy() {
        worldPhysics.destroyBody(body);
    }
}
