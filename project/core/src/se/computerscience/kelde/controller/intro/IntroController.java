package se.computerscience.kelde.controller.intro;

import com.badlogic.gdx.scenes.scene2d.ui.Button;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.intro.IntroView;
import se.computerscience.kelde.view.startmenu.StartMenuView;

/**
 * Created by Daniel on 5/20/2015.
 */
public class IntroController {


    private Intro introModel;
    private IntroView introView;

    public IntroController(Intro introModel, IntroView introView ){
        this.introModel = introModel;
        this.introView = introView;
    }


    public int render(float delta) {
        return introView.renderIntro();

    }

    public void init() {

        introView.init();

    }


}
