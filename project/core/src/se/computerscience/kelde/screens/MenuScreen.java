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
import se.computerscience.kelde.controller.startmenu.StartMenuController;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.startmenu.StartMenuView;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author: Daniel Olsson
 */
public class MenuScreen implements Screen {

    private StartMenuController startmenuViewController;
    private Game keldeGame;
    private Stage menuStage;

    public MenuScreen(Game g) {
        keldeGame = g;
        menuStage = new Stage();

    }

    @Override
    public void show() {
        try {

            startmenuViewController = new StartMenuController();
            startmenuViewController.init();
        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

    @Override
    public void render(float delta) {
        GL20 gl = Gdx.graphics.getGL20();
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (startmenuViewController.render(delta) == 1) {
            this.dispose();
            keldeGame.setScreen(new IntroScreen(keldeGame));
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
