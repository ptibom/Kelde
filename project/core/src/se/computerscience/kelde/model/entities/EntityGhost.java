package se.computerscience.kelde.model.entities;


import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;

import java.awt.*;
import java.util.Random;

/**
 * Created by Anders on 2015-05-16.
 * @author Anders Bolin
 */
public class EntityGhost extends EntityEnemy {

    //Variables
    private final IPhysicalBody entityBody;
    private final Random random;
    private static final int DAMAGE = 15;
    private int healt = 100;
    private static final int ATTACK_DISTANCE = 150;
    private static final int BODY_WIDTH = 16, BODY_HEIGHT = 16;
    private float elapsedTime;
    private static final int LOOT = 25;
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
    * @param monsterx Ghost x axis in the map
    * @param monstery Ghost y axis in the map
    * @param playerx Player x axis in the map
    * @param playery Player y axis in the map
    * @param dx the distance between monster and player in x axsis
    * @param dy the distance between monster and player in y axsis
    * @param dif the hypotenuse between the player and monster
    * @param
    * @param xpos
    * */
    public void update(float delta,float playerx, float playery) {
        elapsedTime += delta;
        final float monsterx = entityBody.getPositionX() , monstery = entityBody.getPositionY();
        final float dx = monsterx - playerx, dy = monstery - playery;
        final float dif = (float)Math.sqrt(dx*dx+dy*dy);
        final boolean xdir = playerx - monsterx > 0 , ydir = playery - monstery > 0;
        final float SPEEDx = playerx/monsterx, SPEEDy = playery/monstery;
        if (dif >=0 && dif <= 200){
            if (dif >=-10 && dif <= 30){
                entityBody.setVelocity(0, 0);
            }else {
                if (elapsedTime > .5) {
                    if (xdir && ydir) {
                        entityBody.setVelocity(SPEEDx, SPEEDy);
                    } else if (!xdir && !ydir) {
                        entityBody.setVelocity(-SPEEDx, -SPEEDy);
                    } else if (xdir && !ydir) {
                        entityBody.setVelocity(SPEEDx, -SPEEDy);
                    } else if (!xdir && ydir) {
                        entityBody.setVelocity(-SPEEDx, SPEEDy);
                    }
                    elapsedTime=0;
                }
            }
        }else {
            if (elapsedTime > 3) {
                setRandomSpeed();
                elapsedTime=0;
            }
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

    public void setDamage(int damage) {
        healt -= damage;
        if(healt <= 0) {
            alive = false;
        }
    }

    public int getDamage() {
        return DAMAGE;
    }

    public int getHealt() {
        return healt;
    }

    public boolean isAlive() { return alive; }

    public int getLoot() { return LOOT;}
}
