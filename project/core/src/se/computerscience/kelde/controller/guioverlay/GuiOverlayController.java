package se.computerscience.kelde.controller.guioverlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.controller.events.ScreenEventBus;
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