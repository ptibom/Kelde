package se.computerscience.kelde.model.entities;


import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;
import se.computerscience.kelde.model.worldobjects.IWorldObjects;

/**
 * Created by Anders on 2015-05-16.
 * @author Anders Bolin
 */
public class EntityArrow implements IWorldObjects{


    //Variables
    private int DAMAGE = 50;
    private final int BODY_WIDTH = 4, BODY_HEIGHT = 4;
    private float elapsedTime = 0;
    private final IPhysicalBody entityBody;
    private Heading direction;
    private float x,y;

    //Constructor
    public EntityArrow(float x, float y, IB2DWorld ib2DWorld) {
        entityBody = new PhysicalBodySensor(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
    }

    public void update(float delta, float x, float y, Heading heading) {
        elapsedTime += delta;
        if(x > 0 && y > 0 && elapsedTime > 0.5f) {
            if(heading == Heading.WEST) {
                entityBody.setVelocity(0,10);
            } else if(heading == Heading.NORTH) {
                entityBody.setVelocity(10,0);
            } else if(heading == Heading.SOUTH) {
                entityBody.setVelocity(-10,0);
            } else if(heading == Heading.EAST) {
                entityBody.setVelocity(10,0);
            }
            elapsedTime = 0;
        }
    }

    public float getPositionX() {
        return (int) (entityBody.getPositionX()-BODY_HEIGHT*8);
    }

    public float getPositionY() {
        return (int) (entityBody.getPositionY()-BODY_WIDTH*8);
    }

    public Heading getHeading() {
        float x = entityBody.getVelocityX();
        float y = entityBody.getVelocityY();
        float degree = (float)Math.toDegrees(Math.atan2(x, y));
        if(degree > 45.0f && degree < 135.0f) {
            direction = Heading.WEST;
        } else if(degree <= -135.0f || degree >= 135.0f) {
            direction = Heading.SOUTH;
        } else if(degree <= 45.0f && degree >= -45.0f) {
            direction = Heading.NORTH;
        } else if(degree < -45.0f && degree > -135.0f) {
            direction = Heading.EAST;
        }
        return direction;
    }

    public void setPosition(float x, float y) {
        float offsetX = x, offsetY = y;
        if(getHeading() == Heading.NORTH) {
            offsetY -= 16;
            offsetX += 16;
        } else if (getHeading() == Heading.WEST) {
            offsetX -= 16;
        } else if (getHeading() == Heading.SOUTH) {
            offsetY += 16;
        } else if(getHeading() == Heading.EAST) {
            offsetX += 16;
        }
        entityBody.setPosition(offsetX,offsetY);
    }
}
