package se.computerscience.kelde.controller.startmenu;

import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.startmenu.StartMenuView;

import java.io.IOException;

/**
 * @author: Daniel Olsson
 */
public class StartMenuController {

    private final StartMenu startMenuModel;
    private final StartMenuView startMenuView;

    public StartMenuController() throws IOException {
        startMenuModel = new StartMenu();
        this.startMenuView = new StartMenuView(startMenuModel);
    }


    public void render(float delta) {

         startMenuView.renderMenu(delta);

    }

    public void resize(int width, int height){
        startMenuView.resize(width, height);
    }



}
