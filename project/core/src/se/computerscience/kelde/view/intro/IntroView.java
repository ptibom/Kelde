package se.computerscience.kelde.view.intro;
/**
 * @author: Daniel Olsson
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
;
import se.computerscience.kelde.controller.events.ScreenEvent;
import se.computerscience.kelde.controller.events.ScreenEventBus;
import se.computerscience.kelde.model.intro.AnimationService;
import se.computerscience.kelde.model.intro.Intro;


public class IntroView {


    // Intro model that returns the data, and introhandler that handles animations
    private Intro introModel;
    private IntroHandler introHandler;


    public IntroView(Intro introModel) {

        introModel.resetTimer();
        this.introModel = introModel;
        SpriteBatch batch = new SpriteBatch();
        introHandler = new IntroHandler(introModel, new AnimationService(introModel));

        introHandler.startIntroMusic();
    }


    public void renderIntro(float delta) {


        SpriteBatch batch = new SpriteBatch();

        //We need to update the state time to get different animation frames.
        introModel.updateStateTime(delta);

        //We need to update the timer, because all the instructions are dependent on them.
        introModel.updateTimer();


        //Here we tell the handler to draw the intro, instructions are included in model
        introHandler.drawIntro(batch, delta);

        //Check for touch, if so we change screen
        if(Gdx.input.isTouched()){
            introHandler.stopIntroMusic();
            ScreenEventBus.INSTANCE.publish(new ScreenEvent(ScreenEvent.Tag.SET_SCREEN, ScreenEvent.ScreenTag.START_WORLD));
        }


    }






}
