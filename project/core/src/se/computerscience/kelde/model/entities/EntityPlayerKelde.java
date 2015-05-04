/** Description: This is the actual Player Controled character. Extends PlayerEntity for modularity.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.encapsulation.box2d.EntityBody;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IEntityBody;
import se.computerscience.kelde.model.physics.WorldPhysics;

public class EntityPlayerKelde extends EntityPlayer {
    private final float BODY_WIDTH = 12, BODY_HEIGHT = 8, START_POSITION_X = 70, START_POSITION_Y = 50;

    IEntityBody entityBody;

    public EntityPlayerKelde(IB2DWorld ib2DWorld) {
        entityBody = new EntityBody(START_POSITION_X, START_POSITION_Y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld);
    }

    public void setVelocity(float x, float y) {
        entityBody.setVelocity(x, y);
    }

    public float getPositionY() {
        return entityBody.getPositionY()-BODY_HEIGHT;
    }

    public float getPositionX() {
        return entityBody.getPositionX()-BODY_WIDTH;
    }

    public Vector2 getPosition() {
        return new Vector2(entityBody.getPositionX()-BODY_WIDTH, entityBody.getPositionY()-BODY_HEIGHT);
    }
}
