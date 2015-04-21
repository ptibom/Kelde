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

    public EntityEye(int damage) {
        this.DAMAGE = damage;

    }

    public void setDAMAGAE(int damage) {
        this.DAMAGE = DAMAGE - damage;
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


}
