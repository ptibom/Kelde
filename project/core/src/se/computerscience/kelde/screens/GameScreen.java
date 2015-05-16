/** Description: Renders a tile-map with camera.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import se.computerscience.kelde.controller.InputController;
import se.computerscience.kelde.controller.gameworld.GameWorldController;


public class GameScreen implements Screen {
    private GameWorldController gameWorldController;

    @Override
    public void show() {
        // Initialises objects, like a constructor
        gameWorldController = new GameWorldController();
        Gdx.input.setInputProcessor(new InputController(gameWorldController));
    }
    @Override
    public void render(float delta) {
        // Renders the scene, first clear it with black.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render the world based om woth screen is set.
        gameWorldController.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        gameWorldController.resizeCamera(width, height);
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
        gameWorldController.dispose();
    }

}
