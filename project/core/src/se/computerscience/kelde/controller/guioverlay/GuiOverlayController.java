package se.computerscience.kelde.controller.guioverlay;


import se.computerscience.kelde.model.guioverlay.GuiOverlay;
import se.computerscience.kelde.view.guioverlay.GuiOverlayView;

/**
 * Created by MonoMan on 5/22/2015.
 */
public class GuiOverlayController {


    GuiOverlay gameGuiModel;
    GuiOverlayView gameGuiView;


    public GuiOverlayController(GuiOverlay gameGuiModel, GuiOverlayView gameGuiView){

        this.gameGuiModel = gameGuiModel;
        this.gameGuiView = gameGuiView;



    }

    public void resizeCamera(int width, int height){
        gameGuiView.resize(width,height);
    }


    public void update(float delta){

        gameGuiModel.update(75,75);
    }
}