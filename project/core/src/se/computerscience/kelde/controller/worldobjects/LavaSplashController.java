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

import java.util.Random;

public class LavaSplashController implements IWorldObjectsController, ICollisionEventHandler {
    private final LavaSplash lavaSplash;
    private Vector2 velocityControl;
    private final float velocityX, velocityY;
    private final float startPosX,startPosY;

    private boolean lavaOn;
    private static Random random = new Random();
    private static final float MAX_VELOCITY = 0.2f , MIN_VELOCITY = 0f; // the velocity range for the splash
    public LavaSplashController(LavaSplash lavaSplash) {
        this.lavaSplash = lavaSplash;
        velocityControl = new Vector2(0, 0);
        CollisionEventBus.INSTANCE.register(this);
        // makes the lava-splashes go in random direction with a velocity in the interval.
        if (random.nextBoolean()){
            velocityX = random.nextFloat() * (MAX_VELOCITY - MIN_VELOCITY) + MIN_VELOCITY;
        }else {
            velocityX = random.nextFloat() * (MIN_VELOCITY*-1 - MAX_VELOCITY*-1) + MAX_VELOCITY*-1;
        }
        if (random.nextBoolean()){
            velocityY = random.nextFloat() * (MAX_VELOCITY - MIN_VELOCITY) + MIN_VELOCITY;
        }else {
            velocityY = random.nextFloat() * (MIN_VELOCITY*-1 - MAX_VELOCITY*-1) + MAX_VELOCITY*-1;
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
        final int max = 1000;
        final int min = 0;
        if((max + random.nextInt(max - min + 1)) == (max + random.nextInt(max - min + 1)) || lavaOn ) {
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
    }

    public void dispose() {
        CollisionEventBus.INSTANCE.unregister(this);
    }
}