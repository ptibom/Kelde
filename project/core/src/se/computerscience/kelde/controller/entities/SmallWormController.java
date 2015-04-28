package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.controller.Waypoints;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.model.entities.EntitySmallWorm;
import se.computerscience.kelde.view.EyeView;
import se.computerscience.kelde.view.SmallWormView;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by Anders on 2015-04-25.
 */
public class SmallWormController {

    //Variables
    private SmallWormView wormview;
    private EntitySmallWorm worm;
    private Vector2[] wpoints = new Vector2[10];

    private int index = 0;

    public SmallWormController(Vector2 startVector) {
        for (int i = 0; i < 10; i++) {
            wpoints[i] = setNewPosition();
        }
        Waypoints wpoint = new Waypoints(wpoints);
        wormview = new SmallWormView(startVector, wpoint);
    }


    public void render(OrthographicCamera camera) {
        wormview.render(camera);
    }

    public void resize(OrthographicCamera camera) {
        wormview.resize(camera);
    }

    private void setWaypoints() {

    }
    private Vector2 setNewPosition() {
        Random random = new Random();
        int x = random.nextInt(500) + 1;
        int y = random.nextInt(500) + 1;
        return new Vector2(x,y);
    }

}
