package se.computerscience.kelde.screens;

import com.badlogic.gdx.*;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import se.computerscience.kelde.controller.intro.IntroController;
import se.computerscience.kelde.controller.startmenu.StartMenuController;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.intro.IntroView;
import se.computerscience.kelde.view.startmenu.StartMenuView;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: Daniel Olsson
 */
public class IntroScreen implements Screen {

    private IntroController introController;
    private Game keldeGame;
    private Stage menuStage;

    public IntroScreen(Game g) {
        keldeGame = g;
        menuStage = new Stage();

    }


    @Override
    public void show() {
        try {
            introController = new IntroController();
            introController.init();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void render(float delta) {

        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (introController.render(delta) == 1) {
            this.dispose();
            keldeGame.setScreen(new GameScreen());
        }

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
