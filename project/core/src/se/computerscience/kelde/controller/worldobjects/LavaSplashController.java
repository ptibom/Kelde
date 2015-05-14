/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.worldobjects.LavaSplash;
import se.computerscience.kelde.view.worldobjects.LavaSplashView;

public class LavaSplashController implements IWorldObjectsController {
    private LavaSplash lavaSplash;
    private LavaSplashView lavaSplashView;
    Vector2 velocityControl;

    public LavaSplashController(LavaSplash lavaSplash, LavaSplashView lavaSplashView) {
        this.lavaSplash = lavaSplash;
        this.lavaSplashView = lavaSplashView;
        velocityControl = new Vector2(0, 0);
    }

    @Override
    public void update(float delta) {
        if (lavaSplash.isSplash()){
            velocityControl.x+=0.001f;
            lavaSplash.setVelocity(velocityControl.x,velocityControl.y);
            System.out.println("splash: x "+velocityControl.x+" y: "+velocityControl.y);
        }
    }
}