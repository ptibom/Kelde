/**
 * Description: This is the actual Player Controled character. Extends PlayerEntity for modularity.
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

import se.computerscience.kelde.model.constants.Direction;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;

public class EntityPlayerKelde extends EntityPlayer implements IEntitie{
    private static final float BODY_WIDTH = 16, BODY_HEIGHT = 8;

    private boolean isSlashing;
    private boolean isShooting;
    private final IPhysicalBody entityBody;
    public EntityPlayerKelde(IB2DWorld ib2DWorld, float startPosX, float startPosY) {
        entityBody = new PhysicalBody(startPosX, startPosY, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
    }

    public void setVelocity(float x, float y) {
        if (x > 0) {
            setDirection(Direction.EAST);
        }
        else if (x < 0) {
            setDirection(Direction.WEST);
        }
        else if (y > 0) {
            setDirection(Direction.NORTH);
        }
        else if (y < 0) {
            setDirection(Direction.SOUTH);
        }
        entityBody.setVelocity(x, y);
    }

    public boolean isWalking() {
        return entityBody.getVelocityX() < 0 || entityBody.getVelocityX() > 0
                || entityBody.getVelocityY() < 0 || entityBody.getVelocityY() > 0;
    }

    public int getPositionY() {
        return (int) (entityBody.getPositionY() - BODY_HEIGHT);
    }

    public int getPositionX() {
        return (int) (entityBody.getPositionX() - BODY_WIDTH * 2);
    }

    public void setIsShooting(boolean isShooting) {
        this.isShooting = isShooting;
    }

    public Boolean getIsShooting() {
        return isShooting;
    }

    public void setIsSlashing(boolean isSlashing) {
        this.isSlashing = isSlashing;
    }

    public boolean getIsSlashing() {
        return isSlashing;
    }
}
