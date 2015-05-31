package se.computerscience.kelde.view.intro;
/**
 * @author: Daniel Olsson
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import se.computerscience.kelde.model.intro.AnimationService;
import se.computerscience.kelde.model.intro.Intro;

;


public class IntroView {


    // Intro model that returns the data, and introhandler that handles animations
    private final Intro introModel;
    private final IntroHandler introHandler;
    private final Stage stage;
    private final IntroButton test;

    public IntroView(Intro introModel) {
        stage = new Stage();
        Gdx.input.setInputProcessor(stage);
        test = new IntroButton( "",IntroButton.createSkin());
        introModel.resetTimer();
        this.introModel = introModel;
        introHandler = new IntroHandler(introModel, new AnimationService(introModel));
        introHandler.startIntroMusic();
        stage.addActor(test);
    }
    // Need to resize, incase user resizes screen
    public void resize(int width, int height) {

        introHandler.setScale(width);

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
