package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.ui.*;

import se.computerscience.kelde.model.guioverlay.GuiOverlay;


/**
 * @author: Daniel Olsson
 */

// This class takes care of the rendering of the Graphical User Interface
public class GuiOverlayView {
    static final private int BUTTON_X = 685, BUTTON_MAIN_MENU_Y = 90, BUTTON_INVENTORY_Y = 180, BUTTON_TEXT = 540;
    static final private int BUTTON_INVENTORY_TRUE_Y = 310, BUTTON_MAIN_MENU_TRUE_Y = 400;
   private final GuiOverlay guiOverlayModel;
    private final Texture menuRectangle;
    private final  GuiButton inventoryButton, mainMenuButton;
    private final TextButton textButtonName;
    // Gui health bars, possible to initialize with value
    private final Bar healthBar;
    private final Bar manaBar;

    public GuiOverlayView(GuiOverlay gameGuiModel) {
        // The real coordinates do not coorialate with the buttons, because, you add viewport height
        menuRectangle = new Texture(gameGuiModel.getMenuRectangleImagePath());
        // The buttons Questlog and MainMenu are switched, but this has no ope
        textButtonName = new TextButton("myName", createSkin(gameGuiModel.getTextBoxImagePath()));

        // Set out position Y does not correlate to input Y, had to switch check.
        inventoryButton = new GuiButton("Main Menu",
                createSkin(gameGuiModel.getGuiButtonImagePath()),BUTTON_X, BUTTON_INVENTORY_TRUE_Y);

        mainMenuButton = new GuiButton("Exit",
                createSkin(gameGuiModel.getGuiButtonImagePath()),
                BUTTON_X, BUTTON_MAIN_MENU_TRUE_Y);

        this.guiOverlayModel = gameGuiModel;

        //Refresh the hp and mana of player
        healthBar = new HealthBar(gameGuiModel, gameGuiModel.getCurrentHealth());
        manaBar = new ManaBar(gameGuiModel, gameGuiModel.getCurrentMana());


        //Setting the position of the buttons,
        textButtonName.setPosition(BUTTON_X, BUTTON_TEXT);
        inventoryButton.setPosition(BUTTON_X, BUTTON_INVENTORY_Y);
        mainMenuButton.setPosition(BUTTON_X, BUTTON_MAIN_MENU_Y);

    }

    public void draw(SpriteBatch batch) {

        batch.draw(menuRectangle, 640, 0);
        healthBar.render(batch, guiOverlayModel.getCurrentHealth());
        manaBar.render(batch, guiOverlayModel.getCurrentMana());

        // Things that will happen when you press


      //  if (inventoryButton.isTouched()) {
            // nothing
        //}

        if (mainMenuButton.isTouched()) {
           Gdx.app.exit();
        }

        // Draw the button with full opacity
        inventoryButton.draw(batch, 1);
        mainMenuButton.draw(batch, 1);
        textButtonName.draw(batch, 1);


    }

    // Creating a new skin for the buttons
    public Skin createSkin(String imageFilePath) {
        final Skin skin = new Skin();
        final BitmapFont font = new BitmapFont();
        skin.add("default", font);

        skin.add("background", new Texture(imageFilePath));

       final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background");

        textButtonStyle.font = skin.getFont("default");
        textButtonStyle.fontColor = Color.ORANGE;
        skin.add("default", textButtonStyle);

        return skin;
    }


}