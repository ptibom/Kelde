package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.view.EyeView;

import java.util.Random;

/**
 * Created by Anders on 2015-04-08.
 */
public class EntityEyeController {

    //Variables
    private EyeView eye_view;
    private Vector2 RENDER_POINT;
    private int INDEX = 0;
    private int LAST_POINT = 9;


    private Vector2[] WAYPOINT = new Vector2[10];


    public EntityEyeController(Vector2 startVector) {
        setVectors();
        RENDER_POINT = startVector;
    }


    public void render(OrthographicCamera camera) {
        eye_view.render(newSpritePosition());
    }

    public void resize(OrthographicCamera camera) {
        eye_view.resize(camera);
    }

    private Vector2 setNewPosition() {
        Random random = new Random();
        int x = random.nextInt(500) + 1;
        int y = random.nextInt(500) + 1;
        return new Vector2(x,y);
    }

    private void setVectors() {
        for (int i = 0; i < 10 ; i++) {
            WAYPOINT[i] = setNewPosition();
        }
    }

    private Vector2 newSpritePosition() {
        if(RENDER_POINT.x == WAYPOINT[INDEX].x && RENDER_POINT.y == WAYPOINT[INDEX].y) {
            RENDER_POINT = WAYPOINT[INDEX];
            INDEX++;
            if(INDEX == LAST_POINT) {
                INDEX = 0;
            }
        }
        if(RENDER_POINT.x > WAYPOINT[INDEX].x) {
            RENDER_POINT.x -= 0.5f;
        } else if (RENDER_POINT.x <  WAYPOINT[INDEX].x) {
            RENDER_POINT.x += 0.5f;
        }
        if(RENDER_POINT.y >  WAYPOINT[INDEX].y) {
            RENDER_POINT.y -= 0.5f;
        } else if(RENDER_POINT.y <  WAYPOINT[INDEX].y) {
            RENDER_POINT.y += 0.5f;
        }
        return RENDER_POINT;
    }
}
