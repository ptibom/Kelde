package se.computerscience.kelde.view.intro;
/**
 * @author: Daniel Olsson
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import se.computerscience.kelde.model.intro.AnimationService;
import se.computerscience.kelde.model.intro.Intro;

public class IntroView {

    // Intro model that returns the data, and introhandler that handles animations
    private final static int ORIGINAL_SCREEN_WIDTH = 1920, ORIGINAL_SCREEN_HEIGHT = 1080;
    private final Intro introModel;
    private final IntroHandler introHandler;
    private final Stage stage;
    private final IntroButton quitIntro;
    private final Viewport viewport;

    public IntroView(Intro introModel) {

        stage = new Stage();

        Gdx.input.setInputProcessor(stage);

        // The hidden button for quitting the intro
        quitIntro = new IntroButton( "",IntroButton.createSkin());

        introModel.resetTimer();
        this.introModel = introModel;
        introHandler = new IntroHandler(introModel, new AnimationService(introModel));
        introHandler.setScale(Gdx.graphics.getHeight(), Gdx.graphics.getWidth());
        introHandler.startIntroMusic();
        stage.addActor(quitIntro);

        // Custom viewport for keeping ratio when scaling
        viewport = new FitViewport(ORIGINAL_SCREEN_WIDTH, ORIGINAL_SCREEN_HEIGHT, stage.getCamera());

        stage.setViewport(viewport);


    }

    // Need to resize, incase user resizes screen
    public void resize(int width, int height) {
        stage.getCamera().position.x = width;
        viewport.update(width, height, true);
    }

    public void render(float delta) {
        stage.draw();
        stage.act();

        //We need to update the state time to get different animation frames.
        introModel.updateStateTime(delta);

        //We need to update the timer, because all the instructions are dependent on them.
        introModel.updateTimer();

        //Here we tell the handler to draw the intro, instructions are included in model
        introHandler.drawIntro(delta);
    }

    public TextButton getButton(){
        return quitIntro;
    }

    public IntroHandler getHandler(){
        return introHandler;
    }

    public void dispose(){
       introHandler.dispose();
    }

    public double getTime(){
        return introModel.getMenuTime();
    }

}
