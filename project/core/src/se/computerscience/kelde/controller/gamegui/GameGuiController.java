package se.computerscience.kelde.controller.gamegui;

import se.computerscience.kelde.model.gamegui.GameGui;
import se.computerscience.kelde.view.gamegui.GameGuiView;

/**
 * Created by MonoMan on 5/22/2015.
 */
public class GameGuiController {


    GameGui gameGuiModel;
    GameGuiView gameGuiView;


    public GameGuiController(GameGui gameGuiModel, GameGuiView gameGuiView){

       this.gameGuiModel = gameGuiModel;
        this.gameGuiView = gameGuiView;



    }
/*
    public void resizeCamera(int width, int height){

        gameGuiView.resize(width,height);
    }
*/

    public void update(float delta){

        gameGuiView.update(delta);
    }
}
