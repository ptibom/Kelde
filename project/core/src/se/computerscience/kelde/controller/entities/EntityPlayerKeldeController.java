/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;

public class EntityPlayerKeldeController implements IWorldObjectsController {
    private final EntityPlayerKelde entityPlayerKelde;
    private final Vector2 velocityControl; // Save obj locally to prevent creation of objects. (Optimizing)
    private boolean isSlashing, isShooting;
    private final static float WALKSPEED = 1.4f;


    public EntityPlayerKeldeController(EntityPlayerKelde entityPlayerKelde) {
        this.entityPlayerKelde = entityPlayerKelde;
        velocityControl = new Vector2(0, 0);
        isSlashing = false;
        isShooting = false;
    }

    public void update(float delta) {
        entityPlayerKelde.setVelocity(velocityControl.x, velocityControl.y);
        entityPlayerKelde.setIsSlashing(isSlashing);
        entityPlayerKelde.setIsShooting(isShooting);

    }

    public void setKeyDown(int keycode) {
        if (Input.Keys.UP == keycode) {
            velocityControl.y = WALKSPEED;
        }
        else if (Input.Keys.RIGHT == keycode) {
            velocityControl.x = WALKSPEED;
        }
        else if (Input.Keys.DOWN == keycode) {
            velocityControl.y = -WALKSPEED;
        }
        else if (Input.Keys.LEFT == keycode) {
            velocityControl.x = -WALKSPEED;
        }
        else if(keycode == Input.Keys.SPACE) {
            isSlashing = true;
        }
        else if(keycode == Input.Keys.ALT_LEFT) {
            isShooting = true;
        }
    }

    public void setKeyUp(int keycode) {
        if (Input.Keys.UP == keycode && !Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            velocityControl.y = 0;
        }
        if (Input.Keys.DOWN == keycode && !Gdx.input.isKeyPressed(Input.Keys.UP)) {
            velocityControl.y = 0;
        }
        if (Input.Keys.RIGHT == keycode && !Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            velocityControl.x = 0;
        }
        if (Input.Keys.LEFT == keycode && !Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            velocityControl.x = 0;
        }
        if (Input.Keys.LEFT == keycode && Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            velocityControl.x = WALKSPEED;
        }
        if (Input.Keys.RIGHT == keycode && Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            velocityControl.x = -WALKSPEED;
        }
        if (Input.Keys.UP == keycode && Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            velocityControl.y = -WALKSPEED;
        }
        if (Input.Keys.DOWN == keycode && Gdx.input.isKeyPressed(Input.Keys.UP)) {
            velocityControl.y = WALKSPEED;
        }
        if(keycode == Input.Keys.SPACE) {
            isSlashing = false;
        }
        if(keycode == Input.Keys.ALT_LEFT) {
            isShooting = false;
        }
    }

    public Vector2 getVelocityControl() {
        return velocityControl;
    }
}
