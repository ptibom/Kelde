package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.intro.AnimationLoader;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.startmenu.StartMenu;
import se.computerscience.kelde.view.startmenu.FirstIntroSlave;
import se.computerscience.kelde.view.startmenu.SecondIntroSlave;

/**
 * @author: Daniel Olsson
 */

public class IntroHandler {


    Music introMusic;

    private final AnimationHandler animationHandlerWizard1;
    private final AnimationHandler animationHandlerDemon;
    private final AnimationHandler animationHandlerWizard2;
    private final AnimationHandler animationHandlerSpell;

    private final FirstIntroSlave intro1Slave;
    private final SecondIntroSlave intro2Slave;

    Texture introBackgroundTexture1, introBackgroundTexture2;
    Texture introForegroundTexture, introBorderTexture;

    AnimationLoader animationLoader;

    private final Intro IntroModel;
    private final DialogueHandler dialogueHandler;
    private final int SECOND_INTRO_DELAY = 47;

    //private final int SECOND_INTRO_DELAY = 0;

    public IntroHandler(Intro IntroModel,AnimationLoader animationLoader){




        introMusic = Gdx.audio.newMusic(new FileHandle(IntroModel.getIntroSound()));

        introBackgroundTexture1 = new Texture(IntroModel.getIntroBackgroundImage());
        introBorderTexture = new Texture(IntroModel.getIntroBorderImage());
        introForegroundTexture = new Texture(IntroModel.getForegroundIntroImage());
        introBackgroundTexture2 = new Texture(IntroModel.getCaveBackground());

        this.IntroModel = IntroModel;
        dialogueHandler = new DialogueHandler(IntroModel);
        this.animationHandlerWizard1 = new AnimationHandler(IntroModel, animationLoader.getWizardAnimations(), 1350, 200,IntroModel.getWizardTalkCoordinates()[0], IntroModel.getWizardTalkCoordinates()[1]);
        this.animationHandlerDemon = new AnimationHandler(IntroModel, animationLoader.getDemonAnimations(),1285,580,128,128 );
        this.animationHandlerWizard2 = new AnimationHandler(IntroModel, animationLoader.getWizard2Animations(),-200,90, 420,420);
        this.animationHandlerSpell = new AnimationHandler(IntroModel, animationLoader.getSpellAnimations(), 740,400,128,128);
        this.animationLoader = animationLoader;


        intro1Slave = new FirstIntroSlave(dialogueHandler,animationHandlerWizard1, introBackgroundTexture1, introForegroundTexture
                , introBorderTexture);

        intro2Slave = new SecondIntroSlave(dialogueHandler,animationHandlerWizard2, animationHandlerDemon, animationHandlerSpell, introBackgroundTexture2, introBorderTexture);

    }


    public void startIntroMusic(){

        introMusic.play();
    }

    public void stopIntroMusic(){

        introMusic.dispose();
    }

    public void drawIntro(SpriteBatch batch){

        if(IntroModel.getMenuTime() <47000){

            drawFirstIntro(batch);
        }
        else if(IntroModel.getMenuTime()>=47000){

            drawSecondIntro(batch);
        }

        System.out.println(IntroModel.getMenuTime());


    }

    public void drawFirstIntro(SpriteBatch batch){
        intro1Slave.draw(batch);



    }

    public void drawSecondIntro(SpriteBatch batch) {


        intro2Slave.draw(batch, animationLoader);

    }




}
