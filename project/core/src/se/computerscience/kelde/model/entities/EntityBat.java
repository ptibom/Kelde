package se.computerscience.kelde.model.entities;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.values.PointSpawnShapeValue;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;
import java.util.Random;

/**
 * Created by Anders on 2015-04-06.
 */
public class EntityBat {

    //Variables
    private int DEALT_DAMAGE;
    private int HEALTH = 100;
    private static final int ATTACK_DISTANCE = 100;
    private boolean ALIVE = true;
    private static final int LOOT = 15;


    //Constructor
    public EntityBat(int damage){
        this.DEALT_DAMAGE = damage;
    }

    public int getHEALTH() {
        return HEALTH;
    }

    public static int getATTACK_DISTANCE() {
        return ATTACK_DISTANCE;
    }

    public int getLoot() {
        return LOOT;
    }

    public void setTakenDamage(int takenDamage) {
        this.HEALTH = this.HEALTH - takenDamage;
        if(this.HEALTH <= 0) {
            ALIVE = false;
        }
    }

}
