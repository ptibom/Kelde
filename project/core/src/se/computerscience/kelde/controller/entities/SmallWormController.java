package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntitySmallWorm;
import se.computerscience.kelde.view.SmallWormView;

import java.util.Random;

/**
 * Created by Anders on 2015-04-25.
 */
public class SmallWormController {

    //Variables
    private SmallWormView wormview;
    private EntitySmallWorm worm;
    private Vector2[] WAYPOINT = new Vector2[10];
    private Vector2 RENDER_POINT;
    private int INDEX = 0;
    private int LAST_POINT = 9;
    private int WORM_DAMAGE = 15;

    public SmallWormController(Vector2 startVector) {
        wormview = new SmallWormView(startVector);
        worm = new EntitySmallWorm(WORM_DAMAGE);
        setWaypoints();
        RENDER_POINT = startVector;
    }


    public void render(OrthographicCamera camera) {
        wormview.render(newSpritePosition());
    }

    public void resize(OrthographicCamera camera) {
        wormview.resize(camera);
    }

    private void setWaypoints() {
        for (int i = 0; i < 10; i++) {
            WAYPOINT[i] = setNewPosition();
        }
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

}
