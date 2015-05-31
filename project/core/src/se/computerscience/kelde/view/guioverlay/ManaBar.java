package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.graphics.Texture;
import se.computerscience.kelde.model.guioverlay.GuiOverlay;

/**
 * @author: Daniel Olsson
 */

// Defines the position and texture of the bar
public class ManaBar extends Bar {

    private static final int STATUS_BAR = 0, BACKGROUND_BAR = 2, FOREGROUND_BAR = 3;

    public ManaBar(GuiOverlay gameGuiModel, int mana) {
        // Sends the original bar X-position and Y-position to the superclass
        super(662, 420);
        final String[] assets = gameGuiModel.getBarAssets();
        progressBarForeground = new Texture(assets[FOREGROUND_BAR]);
        progressBarBackground = new Texture(assets[BACKGROUND_BAR]);
        progressBar = new Texture(assets[STATUS_BAR]);
        progressBarForeground = new Texture(assets[FOREGROUND_BAR]);
        initBar(mana);
    }


}
