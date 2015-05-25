package se.computerscience.kelde.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.startmenu.StartMenuController;

import java.io.IOException;

/**
 * @author: Daniel Olsson
 */
public class MenuScreen implements Screen {

    private StartMenuController startMenuController;


    @Override
    public void show() {
        startMenuController = new StartMenuController();
    }

    @Override
    public void render(float delta) {
        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        SpriteBatch batch = new SpriteBatch();
        batch.begin();
        startMenuController.render(batch, delta);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        startMenuController.resize(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }


}
