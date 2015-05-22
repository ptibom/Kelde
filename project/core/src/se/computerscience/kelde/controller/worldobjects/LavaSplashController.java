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
    private float velocityX, velocityY,startPosX,startPosY;

    private boolean lavaOn = false;
    private static Random random = new Random();
    private static final float max_velocity = 0.2f , min_velocity = 0f; // the velocity range for the splash
    public LavaSplashController(LavaSplash lavaSplash, LavaSplashView lavaSplashView) {
        this.lavaSplash = lavaSplash;
        this.lavaSplashView = lavaSplashView;
        velocityControl = new Vector2(0, 0);
        CollisionEventBus.INSTANCE.register(this);
        // makes the lava-splashes go in random direction with a velocity in the interval.
        if (random.nextBoolean()){
            velocityX = random.nextFloat() * (max_velocity - (min_velocity)) + (min_velocity);
        }else {
            velocityX = random.nextFloat() * (min_velocity*-1 - (max_velocity*-1)) + (max_velocity*-1);
        }
        if (random.nextBoolean()){
            velocityY = random.nextFloat() * (max_velocity - (min_velocity)) + (min_velocity);
        }else {
            velocityY = random.nextFloat() * (min_velocity*-1 - (max_velocity*-1)) + (max_velocity*-1);
        }
        // saves the start position of the lavasplash
        startPosX = lavaSplash.getPositionX();
        startPosY = lavaSplash.getPositionY();
    }

    @Override
    public void update(float delta) {
        /*
        * max and min, is the interval of the random,
        * the higher the max is the less the chance it will execute.
        * */
        int max = 1000;
        int min = 0;
        if (((max + random.nextInt(max - min + 1)) == (max + random.nextInt(max - min + 1)) || lavaOn )) {
            lavaOn = true;
            velocityControl.x += velocityX;
            velocityControl.y += velocityY;
            lavaSplash.setVelocity(velocityControl.x, velocityControl.y);
            // whn they go out of screen, the splashes will return to start position
            if (lavaSplash.getPositionX() > 1000 || lavaSplash.getPositionX() < 0 || lavaSplash.getPositionY() > 1000 || lavaSplash.getPositionY() < 0){
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
        // player should take damage.
        System.out.println("hit");
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}