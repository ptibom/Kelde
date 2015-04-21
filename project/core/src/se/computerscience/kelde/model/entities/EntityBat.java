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
    private int DAMAGE;
    private int HEALTH = 100;
    private static final int ATTACK_DISTANCE = 100;


    //Constructor
    public EntityBat(int damage){
        this.DAMAGE = damage;
    }

    public int getHEALTH() {
        return HEALTH;
    }

    public static int getATTACK_DISTANCE() {
        return ATTACK_DISTANCE;
    }

    public void setHEALTH(int HEALTH) {
        this.HEALTH = HEALTH;
    }

}
