package se.computerscience.kelde.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.controller.events.ScreenEventBus;
import se.computerscience.kelde.controller.startmenu.StartMenuController;

import java.io.IOException;

/**
 * @author: Daniel Olsson
 */
public class MenuScreen implements Screen {

    private StartMenuController startMenuController;


    @Override
    public void show() {
        try {
            startMenuController = new StartMenuController();
        } catch (IOException e) {
            ScreenEventBus.INSTANCE.publish(new ScreenEvent(ScreenEvent.Tag.SET_SCREEN, ScreenEvent.ScreenTag.START_WORLD));
        }
    }

    @Override
    public void render(float delta) {
        final GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        final SpriteBatch batch = new SpriteBatch();
        batch.begin();
        startMenuController.render(delta);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        startMenuController.resize(width, height);
    }

    @Override
    public void pause() {
        // No need for this
    }

    @Override
    public void resume() {
        // No need for this
    }

    @Override
    public void hide() {
        // No need for this
    }

    @Override
    public void dispose() {
        //TODO
    }


}
