/**
 * Description: Physical bodies for entities in the game. Characters, boxes etc.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.encapsulation.box2d;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import se.computerscience.kelde.model.gameworld.Heading;
import se.computerscience.kelde.model.physics.WorldPhysics;

public class EntityBody implements IEntityBody {
    private final World worldPhysics;
    private final Body body;

    public EntityBody(float x, float y, float width, float height, IB2DWorld ib2DWorld) {
        worldPhysics = ib2DWorld.getBox2DWorld();
        BodyDef def = new BodyDef();
        def.position.set(x*WorldPhysics.BOX2D_SCALE, y*WorldPhysics.BOX2D_SCALE);
        def.type = BodyType.DynamicBody;
        body = worldPhysics.createBody(def);
        FixtureDef fdef = new FixtureDef();
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width*WorldPhysics.BOX2D_SCALE, height*WorldPhysics.BOX2D_SCALE);
        fdef.shape = shape;
        body.createFixture(fdef);
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
    public float getVelocityX() {
        return 0;
    }

    @Override
    public float getVelocityY() {
        return 0;
    }

    @Override
    public void destroy() {
        worldPhysics.destroyBody(body);
    }

    public Vector2 getLinearVelocity() {
        return body.getLinearVelocity();
    }
}
