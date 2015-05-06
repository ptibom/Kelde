/**
 * Description: Physical bodies for entities in the game. Characters, boxes etc.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import se.computerscience.kelde.model.physics.WorldPhysics;

public class PhysicalBody implements IPhysicalBody {
    private final World worldPhysics;
    private final Body body;
    protected final BodyDef def;

    public PhysicalBody(float x, float y, float width, float height, IB2DWorld ib2DWorld) {
        worldPhysics = ib2DWorld.getBox2DWorld();
        def = new BodyDef();
        def.position.set(x*WorldPhysics.BOX2D_SCALE, y*WorldPhysics.BOX2D_SCALE);
        setBodyType(); // May call method in subclass
        body = worldPhysics.createBody(def);
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width*WorldPhysics.BOX2D_SCALE, height*WorldPhysics.BOX2D_SCALE);
        fdef.shape = shape;
        body.createFixture(fdef);
    }

    // Sub class may override this method
    protected void setBodyType() {
        def.type = BodyType.DynamicBody;
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
