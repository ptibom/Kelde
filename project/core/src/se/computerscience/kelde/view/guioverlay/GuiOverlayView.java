package se.computerscience.kelde.view.guioverlay;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.ui.*;

import se.computerscience.kelde.model.guioverlay.GuiOverlay;



/**
 * Created by MonoMan on 5/22/2015.
 */
public class GuiOverlayView {
    SpriteBatch batch;

    GuiOverlay guiOverlayModel;
    Texture menuRectangle;
    GuiButton  questButton, inventoryButton, mainMenuButton;
    TextButton textButtonName;
    // Gui health bars, possible to initialize with value
    Bar healthBar;
    Bar manaBar;

    GuiButton testButton;

    float testTime;


    public GuiOverlayView(GuiOverlay gameGuiModel){

        // The real coordinates do not coorialate with the buttons, because, you add viewport heigth.
        testButton = new GuiButton("myName", createSkin(gameGuiModel.getTextBoxImagePath()),500,500);
        menuRectangle = new Texture(gameGuiModel.getMenuRectangleImagePath());
        textButtonName = new TextButton("myName", createSkin(gameGuiModel.getTextBoxImagePath()));
        questButton = new GuiButton("Quest Log",createSkin(gameGuiModel.getGuiButtonImagePath()),685,200);
        mainMenuButton = new GuiButton("Main Menu",createSkin(gameGuiModel.getGuiButtonImagePath()),685,115);
        inventoryButton = new GuiButton("Inventory",createSkin(gameGuiModel.getGuiButtonImagePath()),685,285);
        this.guiOverlayModel = gameGuiModel;


        healthBar = new HealthBar(gameGuiModel,100);
        manaBar = new ManaBar(gameGuiModel,100);


        batch = new SpriteBatch();



        // Trying to fix viewport

        testButton.setPosition(500,500);
        textButtonName.setPosition(685, 540);
        questButton.setPosition(685, 200);
        inventoryButton.setPosition(685, 285);
        mainMenuButton.setPosition(685, 115);


    }

    public void resize(int width, int height) {

        // stageGui.getViewport().update((int)stageGui.getWidth(), (int)stageGui.getHeight(),true);
    }

    public void draw(SpriteBatch batch) {


        batch.draw(menuRectangle, 640, 0);
        healthBar.render(batch, guiOverlayModel.getCurrentHealth());
        manaBar.render(batch, guiOverlayModel.getCurrentMana());



        System.out.println(Gdx.input.getX());
        System.out.println(Gdx.input.getY());


        if(questButton.isTouched()){
            System.out.println("questing!");
        }

        if(mainMenuButton.isTouched()){
            System.out.println("maining");
        }

        if(inventoryButton.isTouched()){
            System.out.println("inveinting");
        }


        questButton.draw(batch,1);
        mainMenuButton.draw(batch, 1);
        inventoryButton.draw(batch,1);
        textButtonName.draw(batch, 1);


    }

    public Skin createSkin( String imageFilePath) {
        Skin skin = new Skin();
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        skin.add("background", new Texture(imageFilePath));

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background");

        textButtonStyle.font = skin.getFont("default");
        textButtonStyle.fontColor=Color.ORANGE;
        skin.add("default", textButtonStyle);

        return skin;
    }












}