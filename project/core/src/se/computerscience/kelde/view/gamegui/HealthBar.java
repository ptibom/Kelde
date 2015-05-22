package se.computerscience.kelde.view.gamegui;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import se.computerscience.kelde.model.gamegui.GameGui;

/**
 * Created by MonoMan on 5/22/2015.
 */
public class HealthBar extends Bar {
    private final int STATUS_BAR =1, BACKGROUND_BAR =2, FOREGROUND_BAR = 4;


    public HealthBar(GameGui gameGuiModel, int health){
        // Sends the original bar X-position and Y-position to the superclass
        super(662,480);
        String[] assets =  gameGuiModel.getBarAssets();
         progressBarBackground = new Texture(assets[BACKGROUND_BAR]);
         progressBar = new Texture(assets[STATUS_BAR]);
         progressBarForeground = new Texture(assets[FOREGROUND_BAR]);

        initBar(health);

    }



}
