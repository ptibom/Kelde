/**
 * Description:
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller;

import com.badlogic.gdx.InputProcessor;
import se.computerscience.kelde.controller.gameworld.GameWorldController;

public class InputController implements InputProcessor {
    GameWorldController gameWorldController;

    public InputController(GameWorldController gameWorldController) {
        this.gameWorldController = gameWorldController;
    }

    @Override
    public boolean keyDown(int keycode) {
        gameWorldController.setKeyDown(keycode);
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        gameWorldController.setKeyUp(keycode);
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}


