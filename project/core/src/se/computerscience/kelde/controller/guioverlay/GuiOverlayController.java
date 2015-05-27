package se.computerscience.kelde.controller.guioverlay;

import se.computerscience.kelde.model.guioverlay.GuiOverlay;
import se.computerscience.kelde.view.guioverlay.GuiOverlayView;

/**
 * @author: Daniel Olsson
 */
public class GuiOverlayController {


    private final GuiOverlay gameGuiModel;
    private final GuiOverlayView gameGuiView;

    public GuiOverlayController(GuiOverlay gameGuiModel, GuiOverlayView gameGuiView){

        this.gameGuiModel = gameGuiModel;
        this.gameGuiView = gameGuiView;
    }

    public void update(float delta){

        gameGuiModel.update(75,75);
    }

    public GuiOverlayView getGuiView(){
        return gameGuiView;
    }
}