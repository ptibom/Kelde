/**
 * Description: 
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import se.computerscience.kelde.controller.gameworld.ShopWorldContoller;

public class ShopScreen implements Screen {
    private ShopWorldContoller shopWorldContoller;
    @Override
    public void show() {
        shopWorldContoller = new ShopWorldContoller(this);
    }

    @Override
    public void render(float delta) {
        // Renders the scene, first clear it with black.
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // Render the world
        shopWorldContoller.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        shopWorldContoller.resizeCamera(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        shopWorldContoller.dispose();
    }
}