package se.computerscience.kelde.view.intro;
/**
 * @author: Daniel Olsson
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import se.computerscience.kelde.model.intro.AnimationService;
import se.computerscience.kelde.model.intro.Intro;

;


public class IntroView {


    // Intro model that returns the data, and introhandler that handles animations
    private static final int SCREEN_W = 1920, SCREEN_H = 1080;
    private Intro introModel;
    private IntroHandler introHandler;
    private Stage stage;
    private TextButton test;

    public IntroView(Intro introModel) {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        Skin skin = new Skin();
        BitmapFont font = new BitmapFont();
        skin.add("default", font);

        Pixmap pixmap = new Pixmap(SCREEN_W,SCREEN_H, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.RED);
        textButtonStyle.down = skin.newDrawable("background", Color.GREEN);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.BLUE);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);



        textButtonStyle.up = skin.newDrawable("background", Color.RED);
        textButtonStyle.down = skin.newDrawable("background", Color.GREEN);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.BLUE);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);
        test = new TextButton( "transparent",skin);

        introModel.resetTimer();
        this.introModel = introModel;
        introHandler = new IntroHandler(introModel, new AnimationService(introModel));
        introHandler.startIntroMusic();
        stage.addActor(test);
    }
    // Need to resize, incase user resizes screen
    public void resize(int width, int height) {
        stage.getCamera().position.x = width;
        stage.getCamera().viewportWidth = width;
        stage.getCamera().viewportHeight = height;

    }

    public void render(float delta) {


        stage.draw();
        stage.act();
        SpriteBatch batch = new SpriteBatch();

        //We need to update the state time to get different animation frames.
        introModel.updateStateTime(delta);

        //We need to update the timer, because all the instructions are dependent on them.
        introModel.updateTimer();


        //Here we tell the handler to draw the intro, instructions are included in model
        introHandler.drawIntro(batch, delta);

        //Check for touch, if so we change screen



    }


    public TextButton getButton(){
        return test;
    }

    public IntroHandler getHandler(){
        return introHandler;
    }





}
