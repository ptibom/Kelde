package se.computerscience.kelde.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.controller.intro.IntroController;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: Daniel Olsson
 */
public class IntroScreen implements Screen {

    private IntroController introController;


    @Override
    public void show() {

        try {
            introController = new IntroController();
        } catch (IOException e) {
            final  Logger log = Logger.getLogger(IOException.class.getName());
            if (log.isLoggable(Level.FINE)) {
                log.fine("File not found");
            }
        }
    }

    @Override
    public void render(float delta) {

        final  GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        introController.render(delta);

    }

    @Override
    public void resize(int width, int height) {
      introController.resize(width, height);
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
       introController.dispose();
    }


}
