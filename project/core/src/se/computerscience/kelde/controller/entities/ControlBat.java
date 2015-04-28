package se.computerscience.kelde.controller.entities;


import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityBat;
import se.computerscience.kelde.view.ViewBat;

import java.util.Random;


/**
 * Created by Anders on 2015-04-06.
 */
public class ControlBat {

    //Variables
    private final EntityBat ebat;
    private final ViewBat vbat;
    private Vector2 startPos;

    private Vector2[] waypoint = new Vector2[10];

    public ControlBat(Vector2 startVector) {
        setWayVectors();
        ebat = new EntityBat(10);
        vbat = new ViewBat(startVector,waypoint);
        startPos = startVector;
    }

    private void setWayVectors() {
        for (int i = 0; i < 10 ; i++) {
            waypoint[i] = setNewPosition();
        }
    }
    public void render(OrthographicCamera camera) {
        vbat.render(startPos, camera);
    }


    public void resize(OrthographicCamera camera) {
        vbat.resize(camera);
    }

    private Vector2 setNewPosition() {
        Random random = new Random();
        int x = random.nextInt(500) + 1;
        int y = random.nextInt(500) + 1;
        return new Vector2(x,y);
    }
}
