package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by MonoMan on 5/31/2015.
 */
public class IntroButton extends TextButton {

    private static final int SCREEN_W = 1920, SCREEN_H = 1080;

    private IntroButton() {
        super("not used", createSkin());
    }

    public IntroButton(String label, Skin skin) {
        super(label, skin);
    }

    public static Skin createSkin() {
        final String def = "default";
        final String bak = "background";

        final Skin skin = new Skin();
        final BitmapFont font = new BitmapFont();
        skin.add(def, font);

        final Pixmap pixmap = new Pixmap(SCREEN_W, SCREEN_H, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable(bak, Color.BLACK);
        textButtonStyle.down = skin.newDrawable(bak, Color.BLACK);
        textButtonStyle.checked = skin.newDrawable(bak, Color.BLACK);
        textButtonStyle.over = skin.newDrawable(bak, Color.BLACK);
        textButtonStyle.font = skin.getFont(def);
        skin.add(def, textButtonStyle);
        return skin;
    }
}
