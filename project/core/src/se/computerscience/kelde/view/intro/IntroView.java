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
    private final Intro introModel;
    private final IntroHandler introHandler;
    private final Stage stage;
    private final TextButton test;

    public IntroView(Intro introModel) {
        stage = new Stage();
        final String def = "default";
        final String bak = "background";
        Gdx.input.setInputProcessor(stage);
        final Skin skin = new Skin();
        final BitmapFont font = new BitmapFont();
        skin.add(def, font);

        final Pixmap pixmap = new Pixmap(SCREEN_W,SCREEN_H, Pixmap.Format.RGB888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        final TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable(bak, Color.RED);
        textButtonStyle.down = skin.newDrawable(bak, Color.GREEN);
        textButtonStyle.checked = skin.newDrawable(bak, Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable(bak, Color.BLUE);
        textButtonStyle.font = skin.getFont(def);
        skin.add(def, textButtonStyle);



        textButtonStyle.up = skin.newDrawable(bak, Color.RED);
        textButtonStyle.down = skin.newDrawable(bak, Color.GREEN);
        textButtonStyle.checked = skin.newDrawable(bak, Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable(bak, Color.BLUE);
        textButtonStyle.font = skin.getFont(def);
        skin.add(def, textButtonStyle);
        test = new TextButton( bak,skin);

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
        final SpriteBatch batch = new SpriteBatch();

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
