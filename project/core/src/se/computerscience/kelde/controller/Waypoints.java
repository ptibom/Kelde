package se.computerscience.kelde.controller;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Anders on 2015-04-27.
 */
public class Waypoints {

    //Variables
    private final Vector2[] waypoints;
    private int ARRAY_INDEX = 0;
    private int ARRAY_END = 9;

    /**
     * Public constructor
     */
    public Waypoints(Vector2[] waypoints) {
        this.waypoints = waypoints;
    }

    public Vector2 getNextWaypoint() {
        ARRAY_INDEX++;
        if(ARRAY_INDEX == ARRAY_END) {
            ARRAY_INDEX = 0;
        }
        return waypoints[ARRAY_INDEX];
    }
}
