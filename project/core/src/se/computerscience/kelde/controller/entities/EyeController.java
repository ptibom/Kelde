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

    public EyeController(Vector2 startVector) {
        eye = new EntityEye();
        eyeview = new EyeView(startVector);
        vector = startVector;
    }


    public void render(OrthographicCamera camera) {
        eyeview.render(vector, camera);
    }

}
