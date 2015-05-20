package se.computerscience.kelde.model.entities;

import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyMonster;

import java.util.Random;

/**
 * Created by Anders on 2015-04-06.
 * @author: Anders Bolin
 */
public class EntityBat {

    //Variables
    private int DAMAGE = 10;
    private int health = 100;
    private final int BODY_WIDTH = 8, BODY_HEIGHT = 8;
    private final int ATTACK_DISTANCE = 100;
    private boolean ALIVE = true;
    private static final int LOOT = 15;
    private float elapsedTime = 0;
    private final IPhysicalBody entityBody;
    private final Random random;
    private Heading direction;

    //Constructor
    public EntityBat(float x, float y, IB2DWorld ib2DWorld){
        entityBody = new PhysicalBodyMonster(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
        random = new Random();
    }

    public int getHealth() {
        return health;
    }

    public int getLoot() {
        return LOOT;
    }

    public void setTakenDamage(int takenDamage) {
        health -= takenDamage;
        if(health <= 0) {
            ALIVE = false;
        }
    }

    public void update(float delta) {
        elapsedTime += delta;
        if (elapsedTime > 2) {
            setRandomSpeed();
            elapsedTime = 0;
        }
    }

    private void setRandomSpeed() {
        int vx = random.nextInt(3) - 1;
        int vy = random.nextInt(3) - 1;
        entityBody.setVelocity(vx, vy);

    }

    public int getPositionX() {
        return (int) (entityBody.getPositionX()-BODY_HEIGHT*2);
    }
    
    public int getPositionY() {
        return (int) (entityBody.getPositionY()-BODY_WIDTH*2);
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
}
