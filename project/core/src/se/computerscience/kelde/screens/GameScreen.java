/** Description: Renders a tile-map with camera.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import se.computerscience.kelde.controller.gameworld.GameWorldController;
import se.computerscience.kelde.controller.gameworld.ShopWorldContoller;


public class GameScreen implements Screen {
    private GameWorldController gameWorldController;
    private ShopWorldContoller shopWorldContoller;
    private int numScreen = 0; // used to swap screen

    public void setNumScreen(int numScreen) {
        this.numScreen = numScreen;
    }

    @Override
    public void show() {
        // Initialises objects, like a constructor
        gameWorldController = new GameWorldController(this);
        shopWorldContoller = new ShopWorldContoller(this);
    }
    @Override
    public void render(float delta) {
        // Renders the scene, first clear it with black.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render the world based om woth screen is set.
        if (numScreen == 1) {
            shopWorldContoller.render(delta);
        }else if (numScreen == 0){
            gameWorldController.render(delta);
        }
    }

    @Override
    public void resize(int width, int height) {
        gameWorldController.resizeCamera(width, height);
        shopWorldContoller.resizeCamera(width, height);
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
        shopWorldContoller.dispose();
    }

}