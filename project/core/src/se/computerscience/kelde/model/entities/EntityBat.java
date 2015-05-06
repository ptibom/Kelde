package se.computerscience.kelde.model.entities;

import se.computerscience.kelde.model.encapsulation.box2d.EntityBody;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IEntityBody;
import se.computerscience.kelde.model.gameworld.Heading;

import java.util.Random;

/**
 * Created by Anders on 2015-04-06.
 */
public class EntityBat {

    //Variables
    private int DAMAGE = 10;
    private int health = 100;
    private final int BODY_WIDTH = 32, BODY_HEIGHT = 32;
    private final int ATTACK_DISTANCE = 100;
    private boolean ALIVE = true;
    private static final int LOOT = 15;
    private float elapsedTime = 0;
    private final IEntityBody entityBody;
    private final Random random;
    private Heading direction;

    //Constructor
    public EntityBat(float x, float y, IB2DWorld ib2DWorld){
        entityBody = new EntityBody(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld);
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
        return (int) (entityBody.getPositionX());
    }
    
    public int getPositionY() {
        return (int) (entityBody.getPositionY());
    }

    public Heading getDirection() {
        direction = Heading.SOUTH;
        if(getPositionX() > 0 && getPositionY() > 0) {
            direction = Heading.NORTH;
        } else if (getPositionX() < 0 && getPositionY() > 0) {
            direction = Heading.WEST;
        }else if(getPositionX() < 0 && getPositionY() < 0) {
            direction = Heading.SOUTH;
        } else if(getPositionX() > 0 && getPositionY() < 0) {
            direction = Heading.EAST;
        }
        System.out.print("in entitybat heading: "+direction + "\n");
        return direction;
    }
}
