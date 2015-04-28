package se.computerscience.kelde.view.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import se.computerscience.kelde.controller.startmenu.StartMenuController;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.startMenu.StartMenuView;

/**
 * Created by MonoMan on 4/27/2015.
 */
public class MenuScreen implements Screen {

    StartMenu startMenuModel;
    StartMenuView startmenuView;
    StartMenuController startmenuViewController;


    @Override
    public void show() {

         startMenuModel = new StartMenu();
         startmenuView = new StartMenuView(startMenuModel);
         startmenuViewController = new StartMenuController(startMenuModel, startmenuView);


    }

    @Override
    public void render(float delta) {
    startmenuView.renderStartMenu();
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
