/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import se.computerscience.kelde.controller.InputController;
import se.computerscience.kelde.controller.gameworld.LavaWorldController;
import se.computerscience.kelde.controller.services.ScreenChanger;

public class LavaScreen implements Screen {
    private LavaWorldController lavaWorldController;
    @Override
    public void show() {
        lavaWorldController = new LavaWorldController();
        Gdx.input.setInputProcessor(new InputController(lavaWorldController));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        lavaWorldController.render(delta);

        ScreenChanger.performingChange();

    }
    @Override
    public void resize(int width, int height) {
        lavaWorldController.resizeCamera(width, height);
    }

    @Override
    public void pause() {
        //TODO: Pause
    }

    @Override
    public void resume() {
        //TODO: Resume
    }

    @Override
    public void hide() {
        // When screen is no longer used, dispose the objects.
        dispose();
    }

    @Override
    public void dispose() {
        lavaWorldController.dispose();
    }
}