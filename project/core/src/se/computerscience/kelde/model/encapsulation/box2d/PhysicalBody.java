/**
 * Description: Physical bodies for entities in the game. Characters, boxes etc.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import se.computerscience.kelde.model.physics.WorldPhysics;

public class PhysicalBody implements IPhysicalBody {
    private final World worldPhysics;
    private final Body body;
    protected final BodyDef def;
    protected final FixtureDef fdef;

    public PhysicalBody(float x, float y, float width, float height, IB2DWorld ib2DWorld, Object userdata) {
        worldPhysics = ib2DWorld.getBox2DWorld();
        def = new BodyDef();

        def.position.set(x * WorldPhysics.BOX2D_SCALE, y * WorldPhysics.BOX2D_SCALE);
        setBodyType(); // May call method in subclass
        body = worldPhysics.createBody(def);

        fdef = new FixtureDef();
        setIsSensor(); // call method in subclass
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width*WorldPhysics.BOX2D_SCALE, height*WorldPhysics.BOX2D_SCALE);
        fdef.shape = shape;
        setFilter();
        body.createFixture(fdef).setUserData(userdata);
    }
    // Sub class may override this method
    protected void setBodyType() {
        def.type = BodyType.DynamicBody;
    }
    protected void setIsSensor() {fdef.isSensor = false;}

<<<<<<< HEAD
    protected void setFilter(){
        fdef.filter.groupIndex = 1;
        fdef.filter.categoryBits = 0x0001;
        short MASK = 0x0002 | 0x0001;
        fdef.filter.maskBits = MASK;
    }
=======

>>>>>>> master

    @Override
    public void setVelocity(float x, float y) {
        // x & y is meters per second. Not pixels.
        body.setLinearVelocity(x, y);
    }
    public void setPosition(float x , float y){
        body.setTransform(new Vector2(x * WorldPhysics.BOX2D_SCALE, y *WorldPhysics.BOX2D_SCALE), 0);
    }
    @Override
    public void setDampening(float dampening) {
        body.setLinearDamping(dampening);
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
    public float getVelocityX() {
        return body.getLinearVelocity().x;
    }

    @Override
    public float getVelocityY() {
        return body.getLinearVelocity().y;
    }

    @Override
    public Body getBody() {
        return body;
    }

    @Override
    public FixtureDef getFdef() {
        return null; // TODO: RETURN NULL ????
    }

    @Override
    public void destroy() {
        worldPhysics.destroyBody(body);
    }

    public Vector2 getLinearVelocity() {
        return body.getLinearVelocity();
    }

    public void setPosition(float x, float y) {
        body.setTransform(x * WorldPhysics.BOX2D_SCALE, y * WorldPhysics.BOX2D_SCALE, 0f);
    }
}
