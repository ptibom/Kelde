package se.computerscience.kelde.model.entities;

import se.computerscience.kelde.model.constants.Heading;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBody;

import java.util.Random;

/**
 * Created by Anders on 2015-04-08.
 *
 * @author Anders
 */
public class EntityEye extends EntityEnemy {

    //Variables
    private final IPhysicalBody entityBody;
    private final Random random;
    private static final int DAMAGE = 15;
    private int health = 100;
    private static final int ATTACK_DISTANCE = 150;
    private static final int BODY_WIDTH = 16, BODY_HEIGHT = 16;
    private float elapsedTime;
    private static final int LOOT = 25;
    private boolean alive = true;
    private Heading direction;

    /**
     * Public constructor
     */
    public EntityEye(float x, float y, IB2DWorld ib2DWorld) {
        super();
        entityBody = new PhysicalBody(x, y, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);
        random = new Random();

    }

    public int getDAMAGE() {
        return DAMAGE;
    }

    public boolean isALIVE() {
        return alive;
    }

    /**
     * A getter for the health value
     *
     * @return the HEALTH
     */
    public int getHEALTH() {
        return health;
    }

    /**
     * A getter for the distance the attacks
     *
     * @return the ATTACK_DISTANCE
     */
    public int getAttackDistance() {
        return ATTACK_DISTANCE;
    }

    /**
     * A getter for the Loot value
     *
     * @return the loot value
     */
    public int getLoot() {
        return LOOT;
    }

    /**
     * Sets the damage taken to the health value.
     *
     * @param takenDamage is the damage value taken
     */
    public void setTakenDamage(int takenDamage) {
        health -= takenDamage;
        if (health <= 0) {
            alive = false;
        }
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
    * @param distance the hypotenuse between the player and monster
    * @param vx monsters velocity, depending on dx
    * @param vy monsters velocity, depending on dy
    * */
    public void chargePlayer(float delta, float playerX, float playerY) {
        elapsedTime += delta;
        final float monsterX = entityBody.getPositionX();
        final float monsterY = entityBody.getPositionY();

        final float distance = NPCAI.distance(playerX,playerY,monsterX,monsterY);

        if (distance >= 0 && distance <= ATTACK_DISTANCE) {
            if (elapsedTime > 1) {
                final float vx = NPCAI.getVelocity(NPCAI.deltaX(playerX,monsterX));
                final float vy = NPCAI.getVelocity(NPCAI.deltaY(playerY,monsterY));

                entityBody.setVelocity(vx, vy);
                elapsedTime = 0;
            }
        }else {
            if (elapsedTime > 2) {
                setRandomSpeed();
                elapsedTime = 0;
            }
        }
    }

    public void update(float delta, float playerX, float playerY) {
        if (!isALIVE()){
            return;
        }
        chargePlayer(delta, playerX, playerY);
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
        return (int) (entityBody.getPositionY() - BODY_WIDTH - 6);
    }
}
