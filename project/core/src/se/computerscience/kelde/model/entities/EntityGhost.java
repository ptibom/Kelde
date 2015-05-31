package se.computerscience.kelde.model.entities;


import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;

import java.awt.*;
import java.util.Random;

/**
 * Created by Anders on 2015-05-16.
 *
 * @author Anders Bolin
 */
public class EntityGhost extends EntityEnemy {

    private static final int DAMAGE = 15;
    private static final int ATTACK_DISTANCE = 150;
    private static final int BODY_WIDTH = 16, BODY_HEIGHT = 16;
    private static final int LOOT = 25;
    //Variables
    private final IPhysicalBody entityBody;
    private final Random random;
    private int healt = 100;
    private float elapsedTime;
    private boolean alive = true;
    private Heading direction;

    public EntityGhost(float x, float y, IB2DWorld ib2DWorld) {
        entityBody = new PhysicalBody(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
        random = new Random();
    }

    public int getAttackDistance() {
        return ATTACK_DISTANCE;
    }

    private void setRandomSpeed() {
        final int vx = random.nextInt(3) - 1;
        final int vy = random.nextInt(3) - 1;
        entityBody.setVelocity(vx, vy);

    }

    /*
    * Description: monster will charge the players position when
    * monster is hypotenuse is less then or equal to 200.
    * @param monsterx Ghost x axis in the map
    * @param monstery Ghost y axis in the map
    * @param playerx Player x axis in the map
    * @param playery Player y axis in the map
    * @param dx the distance between monster and player in x a-xsis
    * @param dy the distance between monster and player in y a-xsis
    * @param distance the hypotenuse between the player and monster
    * @param vx monsters velocity, depending on dx
    * @param vy monsters velocity, depending on dy
    * */
    public void chargePlayer(float delta, float playerx, float playery) {
        elapsedTime += delta;
        final float monsterX = entityBody.getPositionX(), monsterY = entityBody.getPositionY();
        float dx = playerx - monsterX, dy = playery - monsterY;
        float distance = (float) Math.sqrt(dx*dx+dy*dy);

        float vx = NPCAI.getVelocity(dx);
        float vy = NPCAI.getVelocity(dy);

        if (distance >= 0 && distance <= 200) {
            entityBody.setVelocity(vx, vy);
        }else {
            if (elapsedTime > 2) {
                setRandomSpeed();
                elapsedTime = 0;
            }
        }
    }

    public void update(float delta, float playerx, float playery) {
        chargePlayer(delta, playerx, playery);
    }


    public Heading getHeading() {
        final float x = entityBody.getVelocityX();
        final float y = entityBody.getVelocityY();
        final float degree = (float) Math.toDegrees(Math.atan2(x, y));
        if (degree > 45.0f && degree < 135.0f) {
            direction = Heading.WEST;
        } else if (degree <= -135.0f || degree >= 135.0f) {
            direction = Heading.SOUTH;
        } else if (degree <= 45.0f && degree >= -45.0f) {
            direction = Heading.NORTH;
        } else if (degree < -45.0f && degree > -135.0f) {
            direction = Heading.EAST;
        }
        return direction;
    }

    public float getPositionX() {
        return (int) (entityBody.getPositionX() - BODY_HEIGHT);
    }

    public float getPositionY() {
        return (int) (entityBody.getPositionY() - BODY_WIDTH);
    }

    public int getDamage() {
        return DAMAGE;
    }

    public void setDamage(int damage) {
        healt -= damage;
        if (healt <= 0) {
            alive = false;
        }
    }

    public int getHealt() {
        return healt;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getLoot() {
        return LOOT;
    }
}
