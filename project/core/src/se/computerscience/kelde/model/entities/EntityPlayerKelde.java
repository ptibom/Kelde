/** Description: This is the actual Player Controled character. Extends PlayerEntity for modularity.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;

public class EntityPlayerKelde extends EntityPlayer {
    private final float BODY_WIDTH = 16, BODY_HEIGHT = 8;

    IPhysicalBody entityBody;

    public EntityPlayerKelde(IB2DWorld ib2DWorld,float startPosX,float startPosY) {
        entityBody = new PhysicalBody(startPosX, startPosY, BODY_WIDTH, BODY_HEIGHT, ib2DWorld,this);
    }

    public void setVelocity(float x, float y) {
        entityBody.setVelocity(x, y);
    }

    public int getPositionY() {
        return (int)(entityBody.getPositionY()-BODY_HEIGHT);
    }
    public int getPositionX() {
        return (int)(entityBody.getPositionX()-BODY_WIDTH);
    }
}
