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
public class GuiButton extends TextButton  {

    // The original height and X Y origin.
    private final int oldScreenHeight = Gdx.graphics.getHeight();
    private final int originX, originY;

    private GuiButton(){
        super("not used", createSkin(""));
        originX = 0;
        originY = 0;
    }

    GuiButton(String title, Skin skin, int originX, int originY){

        super(title, skin);
        this.originX = originX;
        this.originY = originY;
    }


    public boolean isTouched(){

        // Read out the current mouse position of the mouse, and get the current height of the window.
        // If it has changed, the coordinates for the button has changed, so we must adjust the offset.
        final  int mouseXPos = Gdx.input.getX();
        final int mouseYPos = Gdx.input.getY();
        final int screenHeight = Gdx.graphics.getHeight();

        final  int deltaHeight;
        deltaHeight = screenHeight - oldScreenHeight;

        // A regular collision-check with the button
        if(mouseXPos > originX  && mouseXPos <  originX + getWidth() && mouseYPos >
                originY + deltaHeight && mouseYPos <  originY  +getHeight() +deltaHeight
                &&Gdx.input.isButtonPressed(Input.Buttons.LEFT)){

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
