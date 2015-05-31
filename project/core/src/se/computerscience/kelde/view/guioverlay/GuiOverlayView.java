package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import com.badlogic.gdx.utils.viewport.Viewport;
import se.computerscience.kelde.model.guioverlay.GuiOverlay;


/**
 * @author: Daniel Olsson
 */

// This class takes care of the rendering of the Graphical User Interface
public class GuiOverlayView {
    static final private int BUTTON_X = 685, BUTTON_TEXT = 540;
    static final private int BUTTON_INVENTORY_TRUE_Y = 470, BUTTON_MAIN_MENU_TRUE_Y = 470;
   private final GuiOverlay guiOverlayModel;
    private final Texture menuRectangle;
    private final  GuiButton mainMenuButton, exitButton;
    private final TextButton textButtonName;
    // Gui health bars, possible to initialize with value
    private final Bar healthBar;
    private final Bar manaBar;
    private final Stage guiStage;
    private final Table guiTable;
    private final Viewport sharedViewport;



    public GuiOverlayView(GuiOverlay gameGuiModel,Viewport viewport) {
        sharedViewport = viewport;
        guiStage = new Stage( viewport);
        guiTable = new Table();
        Gdx.input.setInputProcessor(guiStage);
        // The real coordinates do not coorialate with the buttons, because, you add viewport height
        menuRectangle = new Texture(gameGuiModel.getMenuRectangleImagePath());
        // The buttons Questlog and MainMenu are switched, but this has no ope
        textButtonName = new TextButton("Kelde", GuiButton.createSkin(gameGuiModel.getTextBoxImagePath()));

        // Set out position Y does not correlate to input Y, had to switch check.
        exitButton = new GuiButton("Exit",
                GuiButton.createSkin(gameGuiModel.getGuiButtonImagePath()),BUTTON_X, BUTTON_INVENTORY_TRUE_Y);

        mainMenuButton = new GuiButton("Main Menu",
                GuiButton.createSkin(gameGuiModel.getGuiButtonImagePath()),
                BUTTON_X, BUTTON_INVENTORY_TRUE_Y);

        this.guiOverlayModel = gameGuiModel;

        //Refresh the hp and mana of player
        healthBar = new HealthBar(gameGuiModel, gameGuiModel.getCurrentHealth());
        manaBar = new ManaBar(gameGuiModel, gameGuiModel.getCurrentMana());

        //Setting the position of the textButton
        textButtonName.setPosition(BUTTON_X, BUTTON_TEXT);
        guiTable.add(exitButton);
        guiTable.row();
        guiTable.setPosition(760, 70);
        guiStage.addActor(guiTable);

    }

    public void resize(int width, int height){

    }

    public void draw(SpriteBatch batch) {
        batch.setProjectionMatrix(sharedViewport.getCamera().combined);
        batch.draw(menuRectangle, 640, 0);
        healthBar.render(batch, guiOverlayModel.getCurrentHealth());
        manaBar.render(batch, guiOverlayModel.getCurrentMana());

        // Things that will happen when you press
        exitButton.draw(batch, 1);
     //   exitButton.draw(batch, 1);
        batch.end();

        guiStage.draw();
        guiStage.act();

        batch.begin();

        if (exitButton.isTouched()) {



        }

        if (exitButton.isTouched()) {
            Gdx.app.exit();
        }


        textButtonName.draw(batch, 1);

    }

    public GuiButton getExit2Button(){

        return exitButton;
    }

    public GuiButton getExitButton(){
        return exitButton;
    }




}