package se.computerscience.kelde.view.intro;
/**
 * @author: Daniel Olsson
 */

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.intro.AnimationLoader;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.startmenu.*;

/**
 * Created by Daniel on 5/20/2015.
 */
public class IntroView {


    Intro introModel;
    IntroHandler introHandler;
    AnimationLoader animationLoader;
    String[] dialogues;

    public IntroView(Intro introModel){
        this.introModel = introModel;
        SpriteBatch batch = new SpriteBatch();

        animationLoader = new AnimationLoader(introModel);
        introHandler = new IntroHandler(introModel,new AnimationLoader(introModel));
        dialogues = introModel.getDialogues();
        introHandler.stopIntroMusic();
        introHandler.startIntroMusic();
        introHandler.drawIntro(batch);

    }

    public int renderIntro(){
        SpriteBatch batch = new SpriteBatch();
        introModel.updateStateTime();
        introModel.updateTimer();
        System.out.println(introModel.getMenuTime());
        introHandler.drawIntro(batch);
        return 0;

    }

    public void init(){

    introModel.resetTimer();

    }

}
