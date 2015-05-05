/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;
import se.computerscience.kelde.model.entities.EntityPlayerKelde;
import se.computerscience.kelde.view.entities.EntityPlayerKeldeView;

public class EntityPlayerKeldeController {
    EntityPlayerKelde entityPlayerKelde;
    EntityPlayerKeldeView entityPlayerKeldeView;
    Vector2 velocityControl; // Save obj locally to prevent creation of objects. (Optimizing)
    private Boolean KNIFE_SLASH, ARROW;

    public EntityPlayerKeldeController(EntityPlayerKelde entityPlayerKelde, EntityPlayerKeldeView entityPlayerKeldeView) {
        this.entityPlayerKelde = entityPlayerKelde;
        this.entityPlayerKeldeView = entityPlayerKeldeView;
        velocityControl = new Vector2(0, 0);
        KNIFE_SLASH = false;
        ARROW = false;
    }

    public void update(float delta) {
        getKeyInput();
        entityPlayerKelde.setVelocity(velocityControl.x, velocityControl.y);
        entityPlayerKelde.setSlash(KNIFE_SLASH);
        entityPlayerKelde.setArrow(ARROW);

    }

    public void getKeyInput() {
        velocityControl.set(0, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            velocityControl.y = 1;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            velocityControl.y = -1;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            velocityControl.x = 1;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            velocityControl.x = -1;
        }
    }
    public void setKeyDown(int keycode) {
        velocityControl.set(0, 0);
        if (Input.Keys.UP == keycode) {
            velocityControl.y = 1;
        }
        else if (Input.Keys.DOWN == keycode) {
            velocityControl.y = -1;
        }
        if (Input.Keys.RIGHT == keycode) {
            velocityControl.x = 1;
        }
        else if (Input.Keys.LEFT == keycode) {
            velocityControl.x = -1;
        }

        if(keycode == Input.Keys.SPACE) {
            KNIFE_SLASH = true;
        }
        if(keycode == Input.Keys.ALT_LEFT) {
            ARROW = true;
        }
    }

    public void setKeyUp(int keycode) {
        if(keycode == Input.Keys.SPACE) {
            KNIFE_SLASH = false;
        }
        if(keycode == Input.Keys.ALT_LEFT) {
            ARROW = false;
        }
    }
}
