package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.utils.viewport.Viewport;
import se.computerscience.kelde.model.guioverlay.GuiOverlay;

import javax.swing.text.View;


/**
 * @author: Daniel Olsson
 * @revised: Philip Tibom
 */

// This class takes care of the rendering of the Graphical User Interface
public class GuiOverlayView {
    static final private int BUTTON_X = 685, BUTTON_TEXT = 540;
    static final private int BUTTON_Y = 50;

    private final GuiOverlay guiOverlayModel;
    private final Texture menuRectangle;
    private final TextButton textButtonName;
    // Gui health bars, possible to initialize with value
    private final Bar healthBar;
    private final Bar manaBar;
    private final ButtonView exitButton;


    public GuiOverlayView(GuiOverlay gameGuiModel, Viewport viewport) {
        // The real coordinates do not coorialate with the buttons, because, you add viewport height
        menuRectangle = new Texture(gameGuiModel.getMenuRectangleImagePath());
        // The buttons Questlog and MainMenu are switched, but this has no ope
        textButtonName = new TextButton("Kelde", GuiButton.createSkin(gameGuiModel.getTextBoxImagePath()));

        // Set out position Y does not correlate to input Y, had to switch check.
        exitButton = new ButtonView("Exit", new Texture(gameGuiModel.getGuiButtonImagePath()), BUTTON_X, BUTTON_Y, viewport);

        guiOverlayModel = gameGuiModel;

        //Refresh the hp and mana of player
        healthBar = new HealthBar(gameGuiModel, gameGuiModel.getCurrentHealth());
        manaBar = new ManaBar(gameGuiModel, gameGuiModel.getCurrentMana());

        //Setting the position of the textButton
        textButtonName.setPosition(BUTTON_X, BUTTON_TEXT);

    }

    public void draw(SpriteBatch batch) {
        batch.draw(menuRectangle, 640, 0);
        healthBar.render(batch, guiOverlayModel.getCurrentHealth());
        manaBar.render(batch, guiOverlayModel.getCurrentMana());
        textButtonName.draw(batch, 1);
        exitButton.draw(batch);
    }

    public ButtonView getExitButton() {
        return exitButton;
    }
}