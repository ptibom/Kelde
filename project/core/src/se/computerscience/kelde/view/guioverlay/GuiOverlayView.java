package se.computerscience.kelde.view.guioverlay;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import se.computerscience.kelde.model.guioverlay.GuiOverlay;


/**
 * @author: Daniel Olsson
 */

// This class takes care of the rendering of the Graphical User Interface
public class GuiOverlayView {
    static final private int BUTTON_X = 685, BUTTON_TEXT = 540;
    static final private int BUTTON_INVENTORY_TRUE_Y = 370, BUTTON_MAIN_MENU_TRUE_Y = 470;
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
        mainMenuButton = new GuiButton("Main Menu",
                GuiButton.createSkin(gameGuiModel.getGuiButtonImagePath()),BUTTON_X, BUTTON_INVENTORY_TRUE_Y);

        exitButton = new GuiButton("Exit",
                GuiButton.createSkin(gameGuiModel.getGuiButtonImagePath()),
                BUTTON_X, BUTTON_MAIN_MENU_TRUE_Y);

        this.guiOverlayModel = gameGuiModel;

        //Refresh the hp and mana of player
        healthBar = new HealthBar(gameGuiModel, gameGuiModel.getCurrentHealth());
        manaBar = new ManaBar(gameGuiModel, gameGuiModel.getCurrentMana());

        //Setting the position of the textButton
        textButtonName.setPosition(BUTTON_X, BUTTON_TEXT);



        guiTable.add(mainMenuButton);
        guiTable.row();
        guiTable.add(exitButton);
        guiTable.setPosition(700, 30);
        mainMenuButton.setPosition(700, 50);
        exitButton.setPosition(700, 120);
        guiTable.setHeight(116);
        guiTable.setWidth(150);
        guiStage.addActor(guiTable);

        System.out.println(mainMenuButton.getX());
        System.out.println(mainMenuButton.getY());
        System.out.println(mainMenuButton.getHeight());
        System.out.println(mainMenuButton.getWidth());
        System.out.println(exitButton.getX());
        System.out.println(exitButton.getX());
        System.out.println(exitButton.getHeight());
        System.out.println(exitButton.getWidth());




    }

    public void resize(int width, int height){

    }

    public void draw(SpriteBatch batch) {
        batch.setProjectionMatrix(sharedViewport.getCamera().combined);
        batch.draw(menuRectangle, 640, 0);
        healthBar.render(batch, guiOverlayModel.getCurrentHealth());
        manaBar.render(batch, guiOverlayModel.getCurrentMana());

        // Things that will happen when you press
        mainMenuButton.draw(batch, 1);
        exitButton.draw(batch, 1);
        batch.end();

        guiStage.getBatch().setProjectionMatrix(sharedViewport.getCamera().combined);

        batch.begin();

        if (exitButton.isTouched()) {



        }


       //   System.out.println(Gdx.input.getY());
      //  System.out.println(Gdx.input.getX());


        System.out.println();
        if (exitButton.isTouched()) {
            //   System.out.println("TUU2T");
            Gdx.app.exit();
        }

        // Draw the button with full opacity
        //   mainMenuButton.draw(batch, 1);
        // exitButton.draw(batch, 1);
        textButtonName.draw(batch, 1);

    }

    public GuiButton getMainMenuButton(){

        return mainMenuButton;
    }

    public GuiButton getExitButton(){
        return exitButton;
    }




}