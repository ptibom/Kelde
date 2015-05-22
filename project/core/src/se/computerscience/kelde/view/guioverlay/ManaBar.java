package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.graphics.Texture;
import se.computerscience.kelde.model.guioverlay.GuiOverlay;

/**
 * Created by MonoMan on 5/22/2015.
 */
public class ManaBar extends Bar {

    private final int STATUS_BAR =0, BACKGROUND_BAR =2, FOREGROUND_BAR = 3;

    public ManaBar(GuiOverlay gameGuiModel, int mana){
        // Sends the original bar X-position and Y-position to the superclass
        super(662,420);
        String[] assets =  gameGuiModel.getBarAssets();
        progressBarForeground = new Texture(assets[FOREGROUND_BAR]);
        progressBarBackground = new Texture(assets[BACKGROUND_BAR]);
        progressBar = new Texture(assets[STATUS_BAR]);
        progressBarForeground = new Texture(assets[FOREGROUND_BAR]);
        initBar(mana);
    }


}
