/**
 * Description: Handles input from keyboard and mouse
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import se.computerscience.kelde.controller.gameworld.IGameWorldController;

public class InputController implements InputProcessor {
    private final IGameWorldController gameWorldController;

    public InputController(IGameWorldController gameWorldController) {
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
        gameWorldController.setMouseDown(screenX, Gdx.graphics.getHeight()-screenY);
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


