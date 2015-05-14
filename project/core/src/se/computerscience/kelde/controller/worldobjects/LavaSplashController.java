/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.worldobjects.LavaSplash;
import se.computerscience.kelde.view.worldobjects.LavaSplashView;

import java.util.Random;

public class LavaSplashController implements IWorldObjectsController {
    private LavaSplash lavaSplash;
    private LavaSplashView lavaSplashView;
    Vector2 velocityControl;
    private float x, y;
    private Random random = new Random();
    private boolean lavaOn= false;
    public LavaSplashController(LavaSplash lavaSplash, LavaSplashView lavaSplashView) {
        this.lavaSplash = lavaSplash;
        this.lavaSplashView = lavaSplashView;
        velocityControl = new Vector2(0, 0);
        x = random.nextFloat() * (0.05f - (-0.05f)) + (-0.05f);
        y = random.nextFloat() * (0.05f - (-0.05f)) + (-0.05f);
    }

    @Override
    public void update(float delta) {
        int max = 100;
        int min = 0;
        if (((max + random.nextInt(max - min + 1)) == (max+ random.nextInt(max - min + 1)) || lavaOn )) {
            lavaOn = true;
            velocityControl.x += x;
            velocityControl.y += y;
            lavaSplash.setVelocity(velocityControl.x, velocityControl.y);
        }
    }
}