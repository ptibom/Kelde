package se.computerscience.kelde.view.screens;

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
import se.computerscience.kelde.view.startMenu.StartMenuView;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by MonoMan on 4/27/2015.
 */
public class MenuScreen implements Screen {

    StartMenuController startmenuViewController;
    Game keldeGame;
    Stage menuStage;

    public MenuScreen(Game g){
        keldeGame = g;
        menuStage = new Stage();

    }


    @Override
    public void show() {
    try {
        StartMenu startMenuModel = new StartMenu();

        startmenuViewController = new StartMenuController(startMenuModel, new StartMenuView(startMenuModel, keldeGame));
        startmenuViewController.init();
    }
    catch( IOException e){
        System.out.println(e.toString());
    }

    }

    @Override
    public void render(float delta) {
        startmenuViewController.render(1);
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
