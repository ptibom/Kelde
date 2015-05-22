package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.view.entities.SmallWormView;

import java.util.Random;

/**
 * Created by Anders on 2015-04-25.
 * @author Anders
 */
public class SmallWormController {

    //Variables
    private final SmallWormView wormview;
    private Vector2[] waypoint = new Vector2[10];
    private Vector2 position;
    private int index;

    public SmallWormController(Vector2 startVector) {
        wormview = new SmallWormView(startVector);
        setWaypoints();
        position = startVector;
    }


    public void render(OrthographicCamera camera) {
        wormview.render(newSpritePosition());
    }

    public void resize(OrthographicCamera camera) {
        wormview.resize(camera);
    }

    private void setWaypoints() {
        for (int i = 0; i < 10; i++) {
            waypoint[i] = setNewPosition();
        }
    }

    private Vector2 setNewPosition() {
        final Random random = new Random();
        final int x = random.nextInt(500) + 1;
        final int y = random.nextInt(500) + 1;
        return new Vector2(x,y);
    }

    private Vector2 newSpritePosition() {
        if(position.x == waypoint[index].x && position.y == waypoint[index].y) {
            position = waypoint[index];
            index++;
            if(index == 9) {
                index = 0;
            }
        }
        if(position.x > waypoint[index].x) {
            position.x -= 1;
        } else if (position.x <  waypoint[index].x) {
            position.x += 1;
        }
        if(position.y >  waypoint[index].y) {
            position.y -= 1;
        } else if(position.y <  waypoint[index].y) {
            position.y += 1;
        }
        return position;
    }

}
