package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityEye;
import se.computerscience.kelde.view.EyeView;

/**
 * Created by Anders on 2015-04-08.
 */
public class EyeController {

    //Variables
    private EntityEye eye;
    private EyeView eyeview;
    private Vector2 vector, oldvector;

    public EyeController() {
        eye = new EntityEye();
        eyeview = new EyeView();
        eye.setNewWaypoint();
        vector = eye.getNewPosition();
        oldvector = eye.getNewPosition();
    }


    public void render(OrthographicCamera camera) {
        if(vector.x == oldvector.x && vector.y == oldvector.y) {
            eye.setNewWaypoint();
            oldvector = vector;
            vector = eye.getNewPosition();
        }

        eyeview.render(vector, oldvector, camera);
    }

}
