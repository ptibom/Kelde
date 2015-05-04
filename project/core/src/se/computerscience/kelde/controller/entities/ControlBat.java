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
    private Vector2 RENDER_POINT;
    private int INDEX = 0;
    private int LAST_POINT = 9;
    private int BATBITE_DAMAGE = 10;

    private Vector2[] WAYPOINT = new Vector2[10];

    public ControlBat(Vector2 startVector) {
        setWayVectors();
        ebat = new EntityBat(BATBITE_DAMAGE);
        vbat = new ViewBat();
        RENDER_POINT = startVector;
    }

    private void setWayVectors() {
        for (int i = 0; i < 10 ; i++) {
            WAYPOINT[i] = setNewPosition();
        }
    }
    public void render(OrthographicCamera camera) {
        vbat.render(newSpritePosition());
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

    private Vector2 newSpritePosition() {
        if(RENDER_POINT.x == WAYPOINT[INDEX].x && RENDER_POINT.y == WAYPOINT[INDEX].y) {
            RENDER_POINT = WAYPOINT[INDEX];
            INDEX++;
            if(INDEX == LAST_POINT) {
                INDEX = 0;
            }
        }
        if(RENDER_POINT.x > WAYPOINT[INDEX].x) {
            RENDER_POINT.x -= 1;
        } else if (RENDER_POINT.x <  WAYPOINT[INDEX].x) {
            RENDER_POINT.x += 1;
        }
        if(RENDER_POINT.y >  WAYPOINT[INDEX].y) {
            RENDER_POINT.y -= 1;
        } else if(RENDER_POINT.y <  WAYPOINT[INDEX].y) {
            RENDER_POINT.y += 1;
        }
        return RENDER_POINT;
    }

    public void update(float delta) {

    }
}
