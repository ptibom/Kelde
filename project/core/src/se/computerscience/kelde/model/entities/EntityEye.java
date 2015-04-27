package se.computerscience.kelde.model.entities;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by Anders on 2015-04-08.
 */
public class EntityEye {

    //Variables
    private Vector2 waypoint;

    public EntityEye() {
        waypoint = getNewPosition();
    }

    private void setNewPosition() {
        Random random = new Random();
        int x = random.nextInt(500) + 1;
        int y = random.nextInt(500) + 1;
        waypoint = new Vector2(x,y);
    }

    public Vector2 getNewPosition() {
        return waypoint;
    }

    public void setNewWaypoint() {
        setNewPosition();
    }
}
