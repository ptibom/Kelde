package se.computerscience.kelde.controller.startmenu;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import se.computerscience.kelde.view.startmenu.StartMenuView;
import se.computerscience.kelde.model.startmenu.StartMenu;
/**
 * @author: Daniel Olsson
 */
public class StartMenuController {

   private StartMenu startMenuModel;
   private StartMenuView startMenuView;

    public StartMenuController(StartMenu startMenuModel, StartMenuView startMenuView ){
        this.startMenuModel = startMenuModel;
        this.startMenuView = startMenuView;
    }


    public int render(float delta) {
        return startMenuView.renderMenu();

    }

    public void init() {

        startMenuView.init();

    }

    public Button[] getButton(){
        return startMenuView.getButton();

    }


}
