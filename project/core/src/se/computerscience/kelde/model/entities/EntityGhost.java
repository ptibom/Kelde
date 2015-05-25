package se.computerscience.kelde.model.entities;


import se.computerscience.kelde.model.encapsulation.IMonster;
import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyMonster;

import java.util.Random;

/**
 * Created by Anders on 2015-05-16.
 * @author Anders Bolin
 */
public class EntityGhost implements IMonster{

    //Variables
    private final IPhysicalBody entityBody;
    private final Random random;
    private final int damage = 15;
    private final int healt = 100;
    private static final int attack_distance = 150;
    private static final int BODY_WIDTH = 16, BODY_HEIGHT = 16;
    private float elapsedTime;
    private static final int loot = 25;
    private boolean alive = true;
    private Heading direction;

    public EntityGhost(float x, float y, IB2DWorld ib2DWorld) {
        entityBody = new PhysicalBodyMonster(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
        random = new Random();
    }



    private void setRandomSpeed() {
        final int vx = random.nextInt(3) - 1;
        final int vy = random.nextInt(3) - 1;
        entityBody.setVelocity(vx, vy);

    }

    public void update(float delta) {
        elapsedTime += delta;
        if (elapsedTime > 2) {
            setRandomSpeed();
            elapsedTime = 0;
        }
    }


    public Heading getHeading() {
        final float x = entityBody.getVelocityX();
        final float y = entityBody.getVelocityY();
        final float degree = (float)Math.toDegrees(Math.atan2(x, y));
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

    public float getPositionX() {
        return (int) (entityBody.getPositionX()-BODY_HEIGHT);
    }

    public float getPositionY() {
        return (int) (entityBody.getPositionY()-BODY_WIDTH);
    }

    public int getDamage() {
        return damage;
    }

    public int getHealt() {
        return healt;
    }
}
