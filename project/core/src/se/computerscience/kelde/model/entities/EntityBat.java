package se.computerscience.kelde.model;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.particles.values.PointSpawnShapeValue;

import java.awt.*;

/**
 * Created by Anders on 2015-04-06.
 */
public class EntityBat {

    //Model of Flying Enemy Bat

    //Variables
    private int index;
    private Point[] wayPoints = {
            new Point(1, 1),
            new Point(50, 50),
            new Point(0, 50),
            new Point(100, 75),
            new Point(200, 25),
            new Point(25,200)
    };
    //Constructor
    public EntityBat(){
        index = 0;
    }


    public Point getWayPoint() {
        index += 1;
        if(index > 5){
            index = 0;
        }
        return wayPoints[index];
    }
}
