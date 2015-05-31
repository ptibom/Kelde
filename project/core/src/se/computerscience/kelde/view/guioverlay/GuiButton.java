package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * @author: Daniel Olsson
 * @revised: Philip Tibom
 */
public class GuiButton {


    // Creating a new skin for the buttons
    public static Skin createSkin(String imageFilePath) {
        final Skin skin = new Skin();
        final BitmapFont font = new BitmapFont();
        skin.add("default", font);
        skin.add("background", new Texture(imageFilePath));

        final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background");
        textButtonStyle.over = skin.newDrawable("background", Color.BLUE);
        textButtonStyle.font = skin.getFont("default");
        textButtonStyle.fontColor = Color.ORANGE;
        skin.add("default", textButtonStyle);

        return skin;
    }
}
