package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * Created by MonoMan on 5/31/2015.
 */
public class MenuButton extends TextButton {

    private MenuButton(){
        super("not used", createSkin(""));
    }

    public MenuButton(String label, Skin skin){
        super(label, skin);
    }

    public static Skin createSkin(String imageFilePath){
        final Skin skin = new Skin();
        final BitmapFont font = new BitmapFont();
        final String bak = "background";
        skin.add("default", font);

        final Pixmap pixmap = new Pixmap((int) Gdx.graphics.getWidth() / 4, (int) Gdx.graphics.getHeight() / 10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add(bak, new Texture(imageFilePath));

        final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable(bak, Color.RED);
        textButtonStyle.down = skin.newDrawable(bak, Color.GREEN);
        textButtonStyle.checked = skin.newDrawable(bak, Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable(bak, Color.BLUE);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
        return skin;
    }


}
