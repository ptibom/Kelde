package se.computerscience.kelde.model.entities;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Anders on 2015-04-08.
 */
public class EntityEye {

    //Variables
    private int DAMAGE;
    private int HEALTH = 100;
    private static final int ATTACK_DISTANCE = 150;
    private static final int LOOT = 25;
    private boolean ALIVE = true;
    private static final int DEAD = 0;

    /**
     * Public constructor
     * @param damage value the monster will have is set
     */
    public EntityEye(int damage) {
        this.DAMAGE = damage;

    }

    /**
     * A getter for the health value
     * @return the HEALTH
     */
    public int getHEALTH() {
        return HEALTH;
    }

    /**
     * A getter for the distance the attacks
     * @return the ATTACK_DISTANCE
     */
    public int getAttackDistance() {
        return ATTACK_DISTANCE;
    }

    /**
     * A getter for the Loot value
     * @return the loot value
     */
    public int getLoot() {
        return LOOT;
    }

    /**
     * Sets the damage taken to the health value.
     * @param takenDamage is the damage value taken
     */
    public void setTakenDamage(int takenDamage) {
        this.HEALTH = this.HEALTH - takenDamage;
        if(this.HEALTH <= DEAD) {
            ALIVE = false;
        }
    }


}
