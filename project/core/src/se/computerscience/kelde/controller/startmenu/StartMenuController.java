package se.computerscience.kelde.controller.startmenu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.startmenu.StartMenuView;


import java.io.IOException;

/**
 * @author: Daniel Olsson
 */
public class StartMenuController {

    private StartMenu startMenuModel;
    private StartMenuView startMenuView;

    public StartMenuController() throws IOException {
        startMenuModel = new StartMenu();
        this.startMenuView = new StartMenuView(startMenuModel);
    }


    public int render(float delta) {
        return startMenuView.renderMenu(delta);

    }

    public void init() {

        startMenuView.init();

    }

    public Button[] getButton() {
        return startMenuView.getButton();

    }


}
