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
    private Vector2 velocityControl;
    private float x, y,startPosX,startPosY;
    private Random random = new Random();
    private boolean lavaOn = false;
    final float maxt = 1f , mint = .6f; // the velocity range for the splash
    final float maxf = -1f , minf = -.6f; // the velocity range for the splash
    public LavaSplashController(LavaSplash lavaSplash, LavaSplashView lavaSplashView) {
        this.lavaSplash = lavaSplash;
        this.lavaSplashView = lavaSplashView;
        velocityControl = new Vector2(0, 0);

        if (random.nextBoolean()){
            x = random.nextFloat() * (maxt - (mint)) + (mint);
        }else {
            x = random.nextFloat() * (minf - (maxf)) + (maxf);
        }
        if (random.nextBoolean()){
            y = random.nextFloat() * (maxt - (mint)) + (mint);
        }else {
            y = random.nextFloat() * (minf - (maxf)) + (maxf);
        }
        startPosX = lavaSplash.getPositionX();
        startPosY = lavaSplash.getPositionY();
    }

    @Override
    public void update(float delta) {
        int max = 1000;
        int min = 0;
        if (((max + random.nextInt(max - min + 1)) == (max+ random.nextInt(max - min + 1)) || lavaOn )) {
            lavaOn = true;
            velocityControl.x += x;
            velocityControl.y += y;
            lavaSplash.setVelocity(velocityControl.x, velocityControl.y);
            if (lavaSplash.getPositionX() > 400 || lavaSplash.getPositionX() < 0 || lavaSplash.getPositionY() > 400 || lavaSplash.getPositionY() < 0){
                lavaSplash.setPosition(startPosX,startPosY);
                lavaOn = false;
            }
        }
    }
}