package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

/**
 * @author: Daniel Olsson
 */
public class GuiButton extends TextButton {

    // The original height and X Y origin.
    private final int oldScreenHeight = Gdx.graphics.getHeight();
    private final int oldScreenWidth = Gdx.graphics.getWidth();
    private final int originX, originY;
    private int extraOffsetX;
    private int extraOffsetY;

    private GuiButton() {
        super("not used", createSkin(""));
        originX = 0;
        originY = 0;

    }

    // Initializing button with it's clicking position x and y
    GuiButton(String title, Skin skin, int originX, int originY) {

        super(title, skin);
        this.originX = originX-75;
        this.originY = originY-30;
    }


    public boolean isTouched() {

        // Read out the current mouse position of the mouse, and get the current height of the window.
        // If it has changed, the coordinates for the button has changed, so we must adjust the offset.
        final int mouseXPos = Gdx.input.getX();
        final int mouseYPos = Gdx.input.getY();
        final int screenHeight = Gdx.graphics.getHeight();
        final int screenWidth = Gdx.graphics.getWidth();

        final int deltaHeight;

        final double ratio = screenHeight / oldScreenHeight;
        final double ratio2 = screenWidth / oldScreenWidth;
        deltaHeight = screenHeight - oldScreenHeight;


        // We need to adjust for viewport adjusting scaling width
        if ((double) screenWidth / (double) screenHeight > 1.5) {
            extraOffsetX = (int) (((double) screenWidth / (double) screenHeight - 1.5) * 200);
            extraOffsetY = 0;
        }
        // We need to adjust for viewport adjusting scaling right
        if ((double) screenWidth / (double) screenHeight < 1.5) {
            extraOffsetY = (int) ((1.5 - (double) screenWidth / (double) screenHeight) * 200);
            extraOffsetX = 0;
        }

        // A regular collision-check with the button
        if (mouseXPos > ratio2 * (originX + extraOffsetX) && mouseXPos < ratio2 * (originX + extraOffsetX) + getWidth() * ratio2
                && mouseYPos > ratio * (originY + extraOffsetY) && mouseYPos < ratio * (originY + extraOffsetY)
                + getHeight() * ratio + deltaHeight && Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {

            return true;
        }

        return false;
    }

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
