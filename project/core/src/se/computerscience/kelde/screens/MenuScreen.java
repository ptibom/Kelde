package se.computerscience.kelde.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import se.computerscience.kelde.controller.startmenu.StartMenuController;

import java.io.IOException;

/**
 * @author: Daniel Olsson
 */
public class MenuScreen implements Screen {

    private StartMenuController startmenuViewController;
    private Game keldeGame;
    private Stage menuStage;

    public MenuScreen( ) {

        menuStage = new Stage();

    }

    @Override
    public void show() {
        try {

            startmenuViewController = new StartMenuController();

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public void render(float delta) {
        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        startmenuViewController.render(delta);
    }

    @Override
    public void resize(int width, int height) {

        startmenuViewController.resize(width, height);

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
