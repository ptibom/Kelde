package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.intro.AnimationLoader;
import se.computerscience.kelde.model.intro.Intro;
import se.computerscience.kelde.model.intro.IntroInstruction;


import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class IntroHandler {


    private final Music introMusic;
    private final List<List<IntroInstruction>> allInstructions;
    private final AnimationHandler animationHandlerWizard1;
    private final AnimationHandler animationHandlerDemon;
    private final AnimationHandler animationHandlerWizard2;
    private final AnimationHandler animationHandlerSpell;
    private float delta;

    private Texture introBackgroundTexture1, introBackgroundTexture2;
    private Texture introForegroundTexture, introBorderTexture;
    private AnimationLoader animationLoader;

    private final Intro introModel;
    private final DialogueHandler dialogueHandler;

    public IntroHandler(Intro IntroModel, AnimationLoader animationLoader) {

        introMusic = Gdx.audio.newMusic(new FileHandle(IntroModel.getIntroSound()));
        introBackgroundTexture1 = new Texture(IntroModel.getIntroBackgroundImage());
        introBorderTexture = new Texture(IntroModel.getIntroBorderImage());
        introForegroundTexture = new Texture(IntroModel.getForegroundIntroImage());
        introBackgroundTexture2 = new Texture(IntroModel.getCaveBackground());

        this.introModel = IntroModel;
        this.animationLoader = animationLoader;
        dialogueHandler = new DialogueHandler(IntroModel, 47);
        this.animationHandlerWizard1 = new AnimationHandler(IntroModel, animationLoader.getWizardAnimations(), 1350, 200, IntroModel.getWizardTalkCoordinates()[0], IntroModel.getWizardTalkCoordinates()[1], 0);
        this.animationHandlerDemon = new AnimationHandler(IntroModel, animationLoader.getDemonAnimations(), 1285, 580, 128, 128, 47);
        this.animationHandlerWizard2 = new AnimationHandler(IntroModel, animationLoader.getWizard2Animations(), -200, 90, 420, 420, 47);
        this.animationHandlerSpell = new AnimationHandler(IntroModel, animationLoader.getSpellAnimations(), 740, 400, 128, 128, 47);

        allInstructions = introModel.getInstructions();
    }

    public void startIntroMusic() {

        introMusic.play();
    }

    public void stopIntroMusic() {

        introMusic.dispose();
    }

    public void drawIntro(SpriteBatch batch, float delta) {
        this.delta = delta;
        batch.begin();

        if (introModel.getMenuTime() < 47000) {

            batch.draw(introBackgroundTexture1, 0, 0);
        } else if (introModel.getMenuTime() >= 47000) {

            batch.draw(introBackgroundTexture2, 0, 0);
        }

        //Drawing the intro text

        for (int i = 0; i < 8; i++) {

            dialogueHandler.drawDialogue(i, batch, 8 + i * 4, 47, delta);
        }

        //Drawing the demon in intro
        for (IntroInstruction instruct : allInstructions.get(0)) {
            drawHelper(batch, animationHandlerDemon, instruct);
        }
        //Drawing his dialogues
        for (IntroInstruction instruct : allInstructions.get(1)) {
            drawHelper(batch, dialogueHandler, instruct);
        }
        //Drawing second wiz dialogues
        for (IntroInstruction instruct : allInstructions.get(2)) {
            drawHelper(batch, dialogueHandler, instruct);
        }
        //Drawing the first wiz in intro
        for (IntroInstruction instruct : allInstructions.get(3)) {
            drawHelper(batch, animationHandlerWizard1, instruct);
        }
        //Drawing the second wiz in intro
        for (IntroInstruction instruct : allInstructions.get(4)) {
            drawHelper(batch, animationHandlerWizard2, instruct);
        }

        //Drawing the spell animation
        for (IntroInstruction instruct : allInstructions.get(5)) {
            drawHelper(batch, animationLoader, animationHandlerSpell, instruct);

        }

        if (introModel.getMenuTime() < 47000) {

            batch.draw(introForegroundTexture, 0, 0);
        }

        batch.draw(introBorderTexture, 0, 0);
        batch.end();
    }

    public void drawHelper(SpriteBatch batch, AnimationHandler animationHandler, IntroInstruction instruct) {
        // if We did not specifiy a keyFrame in the instruction file
        if (!(instruct.getKeyFrame() == -1)) {
            animationHandler.drawAnimation(batch, instruct.getStartTime(), instruct.getEndTime(), instruct.getKeyFrame(),
                    (int) instruct.getWidthChange(), (int) instruct.getHeightChange(), (int) instruct.getXVelocity(),
                    (int) instruct.getYVelocity(), instruct.getAnimationName(), delta);

        } else {
            animationHandler.drawAnimation(batch, instruct.getStartTime(), instruct.getEndTime(),
                    (int) instruct.getWidthChange(), (int) instruct.getHeightChange(), (int) instruct.getXVelocity(),
                    (int) instruct.getYVelocity(), instruct.getAnimationName(), delta);
        }
    }

    public void drawHelper(SpriteBatch batch, AnimationLoader animationloader, AnimationHandler animationHandler,
                           IntroInstruction instruct) {
        animationHandler.drawAnimation(batch, animationloader, instruct.getStartCount(), instruct.getStartTime(),
                instruct.getEndTime(), instruct.getAnimationName());
    }

    public void drawHelper(SpriteBatch batch, DialogueHandler dialogHandler, IntroInstruction instruct) {

        dialogHandler.drawChatDialogue(batch, instruct.getDialogNumber(), instruct.getStartTime(), instruct.getEndTime());

    }
}