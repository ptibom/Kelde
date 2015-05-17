/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.worldobjects;

import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.controller.events.CollisionEvent;
import se.computerscience.kelde.controller.events.CollisionEventBus;
import se.computerscience.kelde.controller.events.ICollisionEventHandler;
import se.computerscience.kelde.model.worldobjects.LavaSplash;
import se.computerscience.kelde.view.worldobjects.LavaSplashView;

import java.util.Random;

public class LavaSplashController implements IWorldObjectsController, ICollisionEventHandler {
    private LavaSplash lavaSplash;
    private LavaSplashView lavaSplashView;
    private Vector2 velocityControl;
    private float x, y,startPosX,startPosY;
    private Random random = new Random();
    private boolean lavaOn = false;
    final float max_velocity = 0.2f , min_velocity = .05f; // the velocity range for the splash
    public LavaSplashController(LavaSplash lavaSplash, LavaSplashView lavaSplashView) {
        this.lavaSplash = lavaSplash;
        this.lavaSplashView = lavaSplashView;
        velocityControl = new Vector2(0, 0);
        CollisionEventBus.INSTANCE.register(this);

        if (random.nextBoolean()){
            x = random.nextFloat() * (max_velocity - (min_velocity)) + (min_velocity);
        }else {
            x = random.nextFloat() * (min_velocity*-1 - (max_velocity*-1)) + (max_velocity*-1);
        }
        if (random.nextBoolean()){
            y = random.nextFloat() * (max_velocity - (min_velocity)) + (min_velocity);
        }else {
            y = random.nextFloat() * (min_velocity*-1 - (max_velocity*-1)) + (max_velocity*-1);
        }
        startPosX = lavaSplash.getPositionX();
        startPosY = lavaSplash.getPositionY();
    }

    @Override
    public void update(float delta) {
        /*
        * max and min, is the intervall of the random, the higher the max is the less the chance it will execute.
        * */
        int max = 1000;
        int min = 0;
        if (((max + random.nextInt(max - min + 1)) == (max + random.nextInt(max - min + 1)) || lavaOn )) {
            lavaOn = true;
            velocityControl.x += x;
            velocityControl.y += y;
            lavaSplash.setVelocity(velocityControl.x, velocityControl.y);
            if (lavaSplash.getPositionX() > 400 || lavaSplash.getPositionX() < 0 || lavaSplash.getPositionY() > 400 || lavaSplash.getPositionY() < 0){
                System.out.println("returning");
                lavaSplash.setPosition(startPosX,startPosY);
                lavaOn = false;
            }
        }
    }
    @Override
    public void onCollisionEvent(CollisionEvent event) {
        if (event.getObject() != lavaSplash) {
            return;
        }
        //do dmg
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}