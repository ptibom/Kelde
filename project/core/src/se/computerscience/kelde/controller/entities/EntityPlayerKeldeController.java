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

    public EntityPlayerKeldeController(EntityPlayerKelde entityPlayerKelde, EntityPlayerKeldeView entityPlayerKeldeView) {
        this.entityPlayerKelde = entityPlayerKelde;
        this.entityPlayerKeldeView = entityPlayerKeldeView;
        velocityControl = new Vector2(0, 0);

    }

    public void update(float delta) {
        getKeyInput();
        entityPlayerKelde.setVelocity(velocityControl.x, velocityControl.y);
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
}
