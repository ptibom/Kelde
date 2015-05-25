package se.computerscience.kelde.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import se.computerscience.kelde.controller.intro.IntroController;

import java.io.IOException;

/**
 * @author: Daniel Olsson
 */
public class IntroScreen implements Screen {

    private IntroController introController;

    public IntroScreen() {


    }


    @Override
    public void show() {
        try {
            introController = new IntroController();
        } catch (IOException e) {
            System.out.println("Files are missing");
        }
    }

    @Override
    public void render(float delta) {

        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        introController.render(delta);

    }

    @Override
    public void resize(int width, int height) {

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
