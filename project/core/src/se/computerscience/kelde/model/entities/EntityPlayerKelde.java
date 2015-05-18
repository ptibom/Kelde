/** Description: This is the actual Player Controled character. Extends PlayerEntity for modularity.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

import se.computerscience.kelde.model.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;

public class EntityPlayerKelde extends EntityPlayer {
    private final float BODY_WIDTH = 16, BODY_HEIGHT = 8;
    private static Boolean SLASH = false;
    private static Boolean ARROW = false;
    IPhysicalBody entityBody;
    private Heading heading = Heading.NORTH;

    public EntityPlayerKelde(IB2DWorld ib2DWorld,float startPosX,float startPosY) {
        entityBody = new PhysicalBody(startPosX, startPosY, BODY_WIDTH, BODY_HEIGHT, ib2DWorld,this);
    }

    public void setSlash(Boolean slash) {
        EntityPlayerKelde.SLASH = slash;
    }
    public static boolean getSlash() {
        return SLASH;
    }

    public void setVelocity(float x, float y) {
        if(x > 0 && y <= 0) {
            heading = Heading.EAST;
        } else if(x <= 0 && y > 0) {
            heading = Heading.WEST;
        } else if(x < 0 && y >= 0) {
            heading = Heading.SOUTH;
        } else if(x > 0 && y <= 0) {
            heading = Heading.NORTH;
        }
        entityBody.setVelocity(x, y);
    }

    public int getPositionY() {
        return (int)(entityBody.getPositionY()-BODY_HEIGHT);
    }
    public int getPositionX() {
        return (int) (entityBody.getPositionX() - BODY_WIDTH);
    }

    public void setArrow(Boolean arrow) {
        this.ARROW = arrow;
    }
    public Boolean getArrow() {
        return ARROW;
    }
    public Heading getHeading() { return heading; }
}
