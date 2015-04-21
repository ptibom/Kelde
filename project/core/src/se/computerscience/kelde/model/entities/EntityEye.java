package se.computerscience.kelde.model.entities;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Anders on 2015-04-08.
 */
public class EntityEye {

    //Variables
    private Vector2[] waypoint = new Vector2[10];
    private int index = 0;

    public EntityEye() {
        for (int i = 0; i < 10 ; i++) {
            waypoint[i] = setNewPosition();
        }

    }

    private Vector2 setNewPosition() {
        Random random = new Random();
        int x = random.nextInt(500) + 1;
        int y = random.nextInt(500) + 1;
        return new Vector2(x,y);
    }

    public Vector2 getWayPoint() {
        index++;
        if(index == 9){
            index = 0;
        }
        return waypoint[index];
    }

}
