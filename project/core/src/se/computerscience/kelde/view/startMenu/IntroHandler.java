package se.computerscience.kelde.view.startmenu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.intro.AnimationLoader;
import se.computerscience.kelde.model.startmenu.StartMenu;

/**
 * Created by Daniel on 5/19/2015.
 */
public class IntroHandler
{

    Music introMusic;

    private final AnimationHandler animationHandlerWizard1;
    private final AnimationHandler animationHandlerDemon;
    private final AnimationHandler animationHandlerWizard2;
    private final AnimationHandler animationHandlerSpell;

    private final FirstIntroSlave intro1Slave;
    private final SecondIntroSlave intro2Slave;

    Texture  introBackgroundTexture1, introBackgroundTexture2;
    Texture introForegroundTexture, introBorderTexture;

    AnimationLoader animationLoader;

    private final StartMenu startMenuModel;
    private final DialogueHandler dialogueHandler;
    private final int SECOND_INTRO_DELAY = 47;

    //private final int SECOND_INTRO_DELAY = 0;

    public IntroHandler(StartMenu startMenuModel,AnimationLoader animationLoader){




        introMusic = Gdx.audio.newMusic(new FileHandle(startMenuModel.getIntroSound()));

        introBackgroundTexture1 = new Texture(startMenuModel.getIntroBackgroundImage());
        introBorderTexture = new Texture(startMenuModel.getIntroBorderImage());
        introForegroundTexture = new Texture(startMenuModel.getForegroundIntroImage());
        introBackgroundTexture2 = new Texture(startMenuModel.getCaveBackground());

        this.startMenuModel = startMenuModel;
        dialogueHandler = new DialogueHandler(startMenuModel);
        this.animationHandlerWizard1 = new AnimationHandler(startMenuModel, animationLoader.getWizardAnimations(), 1350, 200,startMenuModel.getWizardTalkCoordinates()[0], startMenuModel.getWizardTalkCoordinates()[1]);
        this.animationHandlerDemon = new AnimationHandler(startMenuModel, animationLoader.getDemonAnimations(),1285,580,128,128 );
        this.animationHandlerWizard2 = new AnimationHandler(startMenuModel, animationLoader.getWizard2Animations(),-200,90, 420,420);
        this.animationHandlerSpell = new AnimationHandler(startMenuModel, animationLoader.getSpellAnimations(), 740,400,128,128);
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

        if(startMenuModel.getMenuTime() <47000){

            drawFirstIntro(batch);
        }
        else if(startMenuModel.getMenuTime()>=47000){

            drawSecondIntro(batch);
        }

        System.out.println(startMenuModel.getMenuTime());


    }

    public void drawFirstIntro(SpriteBatch batch){
        intro1Slave.draw(batch);
/*

        // First draw the background texture
        batch.draw(introBackgroundTexture1, 0, 0);


        //Dialogerna kommer renderas in och stanna där tills tiden gått till 50
        dialogueHandler.drawDialogue(0,batch, 8,50);

        dialogueHandler.drawDialogue(1,batch, 12,50);

        dialogueHandler.drawDialogue(2,batch, 16,50);

        dialogueHandler.drawDialogue(3,batch, 20,50);

        dialogueHandler.drawDialogue(4,batch, 24,50);

        dialogueHandler.drawDialogue(5,batch, 28,50);

        dialogueHandler.drawDialogue(6,batch, 32,50);

        dialogueHandler.drawDialogue(7,batch, 36,50);

        // Trollkarlen som går och gör saker
        animationHandlerWizard1.drawAnimation(batch,0, 2,4, 0, 0,0,0, "walkforward");
        animationHandlerWizard1.drawAnimation(batch,2, 6, 30, 30, -120,-40, "walkforward");
        animationHandlerWizard1.drawAnimation(batch,6,8,4, 0, 0,0,0, "walkforward");
        animationHandlerWizard1.drawAnimation(batch,8,40, 0, 0,0,0, "wandlight");
        animationHandlerWizard1.drawAnimation(batch,40,43,4, 0, 0,0,0, "walkforward");
        animationHandlerWizard1.drawAnimation(batch,43,50, -15, -15,60,20, "backwalk");

        // Allting som är längst fram
        batch.draw(introForegroundTexture, 0, 0);
        batch.draw(introBorderTexture, 0, 0);

*/

    }

    public void drawSecondIntro(SpriteBatch batch){


        intro2Slave.draw(batch, animationLoader);
  /*

        batch.draw(introBackgroundTexture2, 0, 0);


        //Demon animations
        animationHandlerDemon.drawAnimation(batch, 2 + SECOND_INTRO_DELAY, 3 + SECOND_INTRO_DELAY, 55, 55, 70, -50, "demonwalk", false);
        animationHandlerDemon.drawAnimation(batch, 3 + SECOND_INTRO_DELAY, 4 + SECOND_INTRO_DELAY, 55, 55, -80, -45, "demonwalk", true);
        animationHandlerDemon.drawAnimation(batch,4+SECOND_INTRO_DELAY,6+SECOND_INTRO_DELAY,55,55,70,-50,"demonwalk",false);
        animationHandlerDemon.drawAnimation(batch, 6 + SECOND_INTRO_DELAY, 9 + SECOND_INTRO_DELAY, 55, 55, -80, -45, "demonwalk", true);
        animationHandlerDemon.drawAnimation(batch, 9 + SECOND_INTRO_DELAY, 10 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 10 + SECOND_INTRO_DELAY, 12 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkleft", true);
        dialogueHandler.drawChatDialogue(batch, 0, 10+ SECOND_INTRO_DELAY, 12+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 12 + SECOND_INTRO_DELAY, 14 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonlaughleft", true);
        animationHandlerDemon.drawAnimation(batch, 14 + SECOND_INTRO_DELAY, 17 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkleft", true);
        dialogueHandler.drawChatDialogue(batch, 1, 14+ SECOND_INTRO_DELAY, 17+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 17 + SECOND_INTRO_DELAY, 33 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 33 + SECOND_INTRO_DELAY, 35 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkleft", true);
        dialogueHandler.drawChatDialogue(batch, 4, 33+ SECOND_INTRO_DELAY, 35+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 35 + SECOND_INTRO_DELAY, 36 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonbreathe", true);
        animationHandlerDemon.drawAnimation(batch, 36 + SECOND_INTRO_DELAY, 38 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkleft", true);
        dialogueHandler.drawChatDialogue(batch, 5, 36+ SECOND_INTRO_DELAY, 38+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 38 + SECOND_INTRO_DELAY, 41 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonbreathe", true);
        animationHandlerDemon.drawAnimation(batch, 41 + SECOND_INTRO_DELAY, 47 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 47 + SECOND_INTRO_DELAY, 49 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkleft", true);
        dialogueHandler.drawChatDialogue(batch, 8, 47+ SECOND_INTRO_DELAY, 49+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 49 + SECOND_INTRO_DELAY, 50 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 50 + SECOND_INTRO_DELAY, 52 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkleft", true);
        dialogueHandler.drawChatDialogue(batch, 9, 50+ SECOND_INTRO_DELAY, 52+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 52 + SECOND_INTRO_DELAY, 53 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 53 + SECOND_INTRO_DELAY, 55 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkleft", true);
        dialogueHandler.drawChatDialogue(batch, 10, 53+ SECOND_INTRO_DELAY, 55+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 55 + SECOND_INTRO_DELAY, 56 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonspellhit", true);
        animationHandlerDemon.drawAnimation(batch, 56 + SECOND_INTRO_DELAY, 57 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 57 + SECOND_INTRO_DELAY, 59 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkleft", true);
        dialogueHandler.drawChatDialogue(batch, 11, 57+ SECOND_INTRO_DELAY, 59+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 59 + SECOND_INTRO_DELAY, 60 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 60 + SECOND_INTRO_DELAY, 61.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 12, 60+ SECOND_INTRO_DELAY, 61.5+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 61.5 + SECOND_INTRO_DELAY, 62 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 62 + SECOND_INTRO_DELAY, 64 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 13, 62+ SECOND_INTRO_DELAY, 64+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 64 + SECOND_INTRO_DELAY, 65 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 14, 64+ SECOND_INTRO_DELAY, 65+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 65 + SECOND_INTRO_DELAY, 66.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 66.5 + SECOND_INTRO_DELAY, 69 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 15, 66.5+ SECOND_INTRO_DELAY, 69+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 69 + SECOND_INTRO_DELAY, 69.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 69.5 + SECOND_INTRO_DELAY, 72 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 16, 69.5+ SECOND_INTRO_DELAY, 72+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 72 + SECOND_INTRO_DELAY, 72.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 72.5 + SECOND_INTRO_DELAY, 75 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 17, 72.5+ SECOND_INTRO_DELAY, 75+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 75 + SECOND_INTRO_DELAY, 75.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 75.5 + SECOND_INTRO_DELAY, 77.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 18, 75.5+ SECOND_INTRO_DELAY, 77.5+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 77.5 + SECOND_INTRO_DELAY, 78 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 78 + SECOND_INTRO_DELAY, 80 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 19, 78+ SECOND_INTRO_DELAY, 80+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 80 + SECOND_INTRO_DELAY, 81 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 81 + SECOND_INTRO_DELAY, 83 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 20, 81+ SECOND_INTRO_DELAY, 83+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 83 + SECOND_INTRO_DELAY, 84 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 84 + SECOND_INTRO_DELAY, 86 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 21, 84+ SECOND_INTRO_DELAY, 86+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 86 + SECOND_INTRO_DELAY, 94 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 94 + SECOND_INTRO_DELAY, 95 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 25, 94+ SECOND_INTRO_DELAY, 95+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 95 + SECOND_INTRO_DELAY, 99.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 99.5 + SECOND_INTRO_DELAY, 103 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 103 + SECOND_INTRO_DELAY,111 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);
        animationHandlerDemon.drawAnimation(batch, 111 + SECOND_INTRO_DELAY, 114 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demontalkright", true);
        dialogueHandler.drawChatDialogue(batch, 29, 111+ SECOND_INTRO_DELAY, 114+ SECOND_INTRO_DELAY);
        animationHandlerDemon.drawAnimation(batch, 114 + SECOND_INTRO_DELAY,140 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "demonsideleft", true);


        //WizardAnimations
        animationHandlerWizard2.drawAnimation(batch, 17 + SECOND_INTRO_DELAY, 22 + SECOND_INTRO_DELAY, 0, 0, 120, 2, "wizardwalk", false);
        animationHandlerWizard2.drawAnimation(batch, 22 + SECOND_INTRO_DELAY, 24 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 24 + SECOND_INTRO_DELAY, 26 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 2, 24+ SECOND_INTRO_DELAY, 26+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 26 + SECOND_INTRO_DELAY, 28 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 28 + SECOND_INTRO_DELAY, 32 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 3, 28+ SECOND_INTRO_DELAY, 32+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 32 + SECOND_INTRO_DELAY, 39 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 39 + SECOND_INTRO_DELAY, 43 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 6, 39+ SECOND_INTRO_DELAY, 43+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 43 + SECOND_INTRO_DELAY, 44 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 44 + SECOND_INTRO_DELAY, 46 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 7, 44+ SECOND_INTRO_DELAY, 46+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 46 + SECOND_INTRO_DELAY, 51 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 51 + SECOND_INTRO_DELAY, 52 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardshoot", false);
        animationHandlerSpell.drawAnimation(batch,animationLoader,51.5+ SECOND_INTRO_DELAY, 51.5+ SECOND_INTRO_DELAY,52+ SECOND_INTRO_DELAY,"start");
        animationHandlerSpell.drawAnimation(batch,animationLoader,51.5+ SECOND_INTRO_DELAY, 52+ SECOND_INTRO_DELAY,54.5+ SECOND_INTRO_DELAY,"loop");
        animationHandlerWizard2.drawAnimation(batch, 52 + SECOND_INTRO_DELAY, 54.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 54.5 + SECOND_INTRO_DELAY, 55 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 55 + SECOND_INTRO_DELAY, 86 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 86 + SECOND_INTRO_DELAY, 88 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 22, 86+ SECOND_INTRO_DELAY, 88+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 88 + SECOND_INTRO_DELAY, 89 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 89 + SECOND_INTRO_DELAY, 91 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 23, 89+ SECOND_INTRO_DELAY, 91+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 91 + SECOND_INTRO_DELAY, 92 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 92 + SECOND_INTRO_DELAY, 94 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 24, 92+ SECOND_INTRO_DELAY, 94+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 94 + SECOND_INTRO_DELAY, 96 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 96 + SECOND_INTRO_DELAY, 97 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardshoot", false);
        animationHandlerWizard2.drawAnimation(batch, 96.5 + SECOND_INTRO_DELAY, 97 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerSpell.drawAnimation(batch,animationLoader,96.5+ SECOND_INTRO_DELAY, 96.5+ SECOND_INTRO_DELAY,97+ SECOND_INTRO_DELAY,"start");
        animationHandlerSpell.drawAnimation(batch,animationLoader,96.5+ SECOND_INTRO_DELAY, 97+ SECOND_INTRO_DELAY,99.5+ SECOND_INTRO_DELAY,"loop");
        animationHandlerWizard2.drawAnimation(batch, 97 + SECOND_INTRO_DELAY, 99.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 99.5 + SECOND_INTRO_DELAY, 103 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 103 + SECOND_INTRO_DELAY, 104.5 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 26, 103+ SECOND_INTRO_DELAY, 104.5+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 104.5 + SECOND_INTRO_DELAY, 106 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 106 + SECOND_INTRO_DELAY, 108 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 27, 106+ SECOND_INTRO_DELAY, 108+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 108 + SECOND_INTRO_DELAY, 109 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardstandleft", false);
        animationHandlerWizard2.drawAnimation(batch, 109 + SECOND_INTRO_DELAY, 111 + SECOND_INTRO_DELAY, 0, 0, 0, 0, "wizardtalkright", false);
        dialogueHandler.drawChatDialogue(batch, 28, 109+ SECOND_INTRO_DELAY, 111+ SECOND_INTRO_DELAY);
        animationHandlerWizard2.drawAnimation(batch, 111 + SECOND_INTRO_DELAY, 116 + SECOND_INTRO_DELAY, 0, 0, -120, -2, "wizardwalk", false);

        batch.draw(introBorderTexture, 0, 0);
*/
    }



}
