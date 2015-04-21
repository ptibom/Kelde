package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.model.entities.EntitySmallWorm;
import se.computerscience.kelde.view.EyeView;
import se.computerscience.kelde.view.SmallWormView;

import java.util.Random;

/**
 * Created by Anders on 2015-04-25.
 */
public class SmallWormController {

    //Variables
    private SmallWormView wormview;
    private EntitySmallWorm worm;
    private Vector2 vector;

    private Vector2[] waypoint = new Vector2[10];
    private int index = 0;

    public SmallWormController(Vector2 startVector) {
        setVectors();
        worm = new EntitySmallWorm(10);
        wormview = new SmallWormView(startVector, waypoint);
        vector = startVector;
    }


    public void render(OrthographicCamera camera) {
        wormview.render(camera);
    }

    public void resize(OrthographicCamera camera) {
        wormview.resize(camera);
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

    private void setVectors() {
        for (int i = 0; i < 10 ; i++) {
            waypoint[i] = setNewPosition();
        }
    }
}
