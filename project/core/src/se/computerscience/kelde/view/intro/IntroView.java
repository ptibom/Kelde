package se.computerscience.kelde.view.intro;
/**
 * @author: Daniel Olsson
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.intro.AnimationLoader;
import se.computerscience.kelde.model.intro.Intro;


public class IntroView {


    private Intro introModel;
    private IntroHandler introHandler;


    public IntroView(Intro introModel) {
        this.introModel = introModel;
        SpriteBatch batch = new SpriteBatch();
        introHandler = new IntroHandler(introModel, new AnimationLoader(introModel));
        introHandler.stopIntroMusic();
        introHandler.startIntroMusic();
    }

    public int renderIntro(float delta) {
        SpriteBatch batch = new SpriteBatch();
        introModel.updateStateTime(delta);
        introModel.updateTimer();
        System.out.println(introModel.getMenuTime());
        introHandler.drawIntro(batch, delta);
        if (Gdx.input.isTouched()) {
            introHandler.stopIntroMusic();
            return 1;
        }
        return 0;

    }

    public void init() {

        introModel.resetTimer();

    }

}
