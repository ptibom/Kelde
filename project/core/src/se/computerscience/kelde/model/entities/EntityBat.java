package se.computerscience.kelde.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.values.PointSpawnShapeValue;
import com.badlogic.gdx.math.Vector2;

import java.awt.*;

/**
 * Created by Anders on 2015-04-06.
 */
public class EntityBat {

    //Model of Flying Enemy Bat

    //Variables
    private int index;
    private Vector2[] wayPoints = {
            new Vector2(1, 1),
            new Vector2(50, 50),
            new Vector2(0, 50),
            new Vector2(100, 75),
            new Vector2(200, 25),
            new Vector2(25,200)
    };
    //Constructor
    public EntityBat(){
        index = 0;
    }


    public Vector2 getWayPoint() {
        index += 1;
        if(index > 5){
            index = 0;
        }
        return wayPoints[index];
    }
}
