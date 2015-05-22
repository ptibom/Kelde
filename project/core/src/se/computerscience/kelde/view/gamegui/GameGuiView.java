package se.computerscience.kelde.view.gamegui;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import se.computerscience.kelde.model.gamegui.GameGui;

import java.awt.*;


/**
 * Created by MonoMan on 5/22/2015.
 */
public class GameGuiView {
    SpriteBatch batch;

    GameGui gameGuiModel;
    Texture menuRectangle;
    TextButton textButtonName, questButton, inventoryButton, mainMenuButton;
    // Gui health bars, possible to initialize with value
    Bar healthBar;
    Bar manaBar;
    Stage guiStage;
    Viewport viewPort;


    public GameGuiView(GameGui gameGuiModel){

        guiStage = new Stage();
        Gdx.input.setInputProcessor(guiStage);


        menuRectangle = new Texture(gameGuiModel.getMenuRectangleImagePath());
        textButtonName = new TextButton("myName", createSkin(gameGuiModel.getTextBoxImagePath()));
        questButton = new TextButton("Quest Log",createSkin(gameGuiModel.getGuiButtonImagePath()));
        mainMenuButton = new TextButton("Main Menu",createSkin(gameGuiModel.getGuiButtonImagePath()));
        inventoryButton = new TextButton("Inventory",createSkin(gameGuiModel.getGuiButtonImagePath()));
        this.gameGuiModel = gameGuiModel;
        healthBar = new HealthBar(gameGuiModel,100);
        manaBar = new ManaBar(gameGuiModel,100);
        batch = new SpriteBatch();

        // Trying to fix viewport
        viewPort =new ScreenViewport();



        textButtonName.setPosition(685, 540);
        questButton.setPosition(685, 200);
        inventoryButton.setPosition(685, 285);
        mainMenuButton.setPosition(685, 115);

        guiStage.addActor(questButton);
        guiStage.addActor(mainMenuButton);
        guiStage.addActor(inventoryButton);

    }
/*
    public void resize(int width, int height) {
        viewPort.update(width, height);
        guiStage.setViewport(viewPort);
    }
*/
    public void update(float delta){
        batch.begin();
        batch.draw(menuRectangle, 640, 0);
        healthBar.render(batch, 100);
        manaBar.render(batch, 100);

        if(questButton.isPressed()){
            System.out.print("questing!");
        }

        guiStage.act();
        guiStage.draw();



        batch.end();
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
