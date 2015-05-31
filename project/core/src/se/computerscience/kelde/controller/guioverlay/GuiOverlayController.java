package se.computerscience.kelde.controller.guioverlay;

import com.badlogic.gdx.Gdx;
import se.computerscience.kelde.model.guioverlay.GuiOverlay;
import se.computerscience.kelde.view.guioverlay.GuiOverlayView;

/**
 * @author: Daniel Olsson
 * @revised: Philip Tibom
 */
public class GuiOverlayController {


    private final GuiOverlay gameGuiModel;
    private final GuiOverlayView gameGuiView;

    public GuiOverlayController(GuiOverlay gameGuiModel, GuiOverlayView gameGuiView) {
        this.gameGuiModel = gameGuiModel;
        this.gameGuiView = gameGuiView;
    }

    public void update(float delta, int health, int mana) {
        gameGuiModel.update(health, mana);
    }

    public void setMouseDown(int x, int y) {
        if (gameGuiView.getExitButton().isClicked(x, y)) {
            Gdx.app.exit();
        }
    }
}