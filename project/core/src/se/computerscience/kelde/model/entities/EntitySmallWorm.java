package se.computerscience.kelde.model.entities;

/**
 * Created by Anders on 2015-04-25.
 */
public class EntitySmallWorm {

    //Variables
    private int DAMAGE;
    private int HEALTH = 100;
    private static final int ATTACK_DISTANCE = 30;
    private static final int LOOT = 5;
    private boolean ALIVE = true;
    private static final int DEAD = 0;

    public EntitySmallWorm(int damage) {
        this.DAMAGE = damage;

    }

    public int getHEALTH() {
        return HEALTH;
    }

    public int getAttackDistance() {
        return ATTACK_DISTANCE;
    }

    public int getLoot() {
        return LOOT;
    }

    public void setTakenDamage(int takenDamage) {
        this.HEALTH = this.HEALTH - takenDamage;
        if(this.HEALTH <= DEAD) {
            ALIVE = false;
        }
    }

}
