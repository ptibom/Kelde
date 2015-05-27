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

    public void update(float delta, int health, int mana){

        gameGuiModel.update(health, mana);
    }

    public GuiOverlayView getGuiView(){
        return gameGuiView;
    }
}