package se.computerscience.kelde.controller.startmenu;

import se.computerscience.kelde.view.startMenu.StartMenuView;
import se.computerscience.kelde.model.startmenu.StartMenu;
/**
 * Created by MonoMan on 4/27/2015.
 */
public class StartMenuController {

   private StartMenu startMenuModel;
   private StartMenuView startMenuView;

    public StartMenuController(StartMenu startMenuModel, StartMenuView startMenuView ){
        this.startMenuModel = startMenuModel;
        this.startMenuView = startMenuView;
    }


    public void render(float delta) {


    }
}
