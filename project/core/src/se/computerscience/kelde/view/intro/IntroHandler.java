package se.computerscience.kelde.view.intro;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.intro.*;

import java.util.List;
import java.util.Map;

/**
 * @author: Daniel Olsson
 */

// This class does all the hard work, it uses the instruction files that the model prepared.

public class IntroHandler {

    private double scale = 0.5;

    private final static int MAX_WIDTH = 1920;
    private final static int MAX_HEIGHT = 1080;
    private static final int FIRST_INTRO_LENGTH = 47000;
    private static final int FIRST_INTRO_TEXT_LENGTH = 45000;
    private static final int LENGTH_OF_TEXT_STAYING = 47;
    private static final int ORIGIN_OF_TEXT = 8;
    private static final int TEXT_MOVEMENT_SPEED = 4;

    private final Music introMusic;
    private final List<List<IntroInstruction>> allInstructions;
    private final AnimationHandler animationHandlerWizard1;
    private final AnimationHandler animationHandlerDemon;
    private final AnimationHandler animationHandlerWizard2;
    private final AnimationHandler animationHandlerSpell;
    private float delta;

    // Background and foreground textures
    final private Texture introBackgroundTexture1, introBackgroundTexture2;
    final private Texture introForegroundTexture, introBorderTexture;

    //The animation loader loads the actual animations from the sprite sheet
   final  private AnimationService animationService;

    //Intro model is needed to keep time, and dialoguehandler to draw the dialogue/texts
    private final Intro introModel;
    private final DialogueHandler dialogueHandler;

    public IntroHandler(Intro introModel, AnimationService animationService) {

        //The textures and music is loaded
        introMusic = Gdx.audio.newMusic(new FileHandle(ConstantsPath.getIntroMusic()));
        introBackgroundTexture1 = new Texture(ConstantsPath.getIntroBackgroundPathImage());
        introBorderTexture = new Texture(ConstantsPath.getIntroBorderPathImage());
        introForegroundTexture = new Texture(ConstantsPath.getForegroundIntroPathImage());
        introBackgroundTexture2 = new Texture(ConstantsPath.getIntroCaveBackground());

        // Here we create the handlers that takes care of the animation of
        // each specific sprite, be it demon, wizard etc.
        this.introModel = introModel;
        this.animationService = animationService;
        dialogueHandler = new DialogueHandler(introModel, 47);
        scale = 0.5;

        //Converting animations
        final  Map<String, Animation> wizardAnimations = AnimationConverter.convertToLibgdxAnimation(animationService.getWizardAnimations(),
                this.introModel.getAnimationSpeed(), new Texture(ConstantsPath.getIntroWizardAnimationPathImage()));
        final Map<String, Animation> demonAnimations = AnimationConverter.convertToLibgdxAnimation(animationService.getDemonAnimations(),
                this.introModel.getAnimationSpeed(), new Texture(ConstantsPath.getIntroDemonAnimationPathImage()));
        final Map<String, Animation> wizard2 = AnimationConverter.convertToLibgdxAnimation(animationService.getWizard2Animations(),
                this.introModel.getAnimationSpeed(), new Texture(ConstantsPath.getIntroDemonAnimationPathImage()));
        final Map<String, Animation> spellAnimations = AnimationConverter.convertToLibgdxAnimation(animationService.getSpellAnimations(),
                this.introModel.getAnimationSpeed(), new Texture(ConstantsPath.getIntroSpellPathImage()));

        this.animationHandlerWizard1 = new AnimationHandler(this.introModel,wizardAnimations, 1350, 200, this.introModel
                .getWizardTalkCoordinates()[0], this.introModel.getWizardTalkCoordinates()[1], 0);

        this.animationHandlerDemon = new AnimationHandler(this.introModel, demonAnimations, 1285, 580, 128, 128, 47);
        this.animationHandlerWizard2 = new AnimationHandler(this.introModel, wizard2, -200, 90, 420, 420, 47);
        this.animationHandlerSpell = new AnimationHandler(this.introModel, spellAnimations, 740, 400, 128, 128, 47);

        //Retrieving the instructions.
        allInstructions = this.introModel.getInstructions();
    }

    public void startIntroMusic() {
        introMusic.play();
    }

    public void stopIntroMusic() {
        introMusic.dispose();
    }

    //Here we draw the intro, we switch background
    //for the two different intros.
    public void drawIntro(SpriteBatch batch, float delta) {
        this.delta = delta;
        batch.begin();



        if (introModel.getMenuTime() < FIRST_INTRO_LENGTH) {
            batch.draw(introBackgroundTexture1, 0, 0,(int)(MAX_WIDTH *scale),(int)(MAX_HEIGHT *scale));
        } else if (introModel.getMenuTime() >= FIRST_INTRO_LENGTH) {
            batch.draw(introBackgroundTexture2, 0, 0,(int)(MAX_WIDTH *scale),(int)(MAX_HEIGHT *scale));
        }

        if(introModel.getMenuTime()<FIRST_INTRO_TEXT_LENGTH) {
            //Drawing the intro text
            for (int i = 0; i < 8; i++) {
                dialogueHandler.drawTextDialogue(i, batch, ORIGIN_OF_TEXT + i * TEXT_MOVEMENT_SPEED, LENGTH_OF_TEXT_STAYING, delta, scale);
            }
        }


        drawAnimations(batch);

        // Lastly we draw the first intro's foreground.
        if (introModel.getMenuTime() < FIRST_INTRO_LENGTH) {

            batch.draw(introForegroundTexture, 0, 0, (int)(MAX_WIDTH *scale), (int)(MAX_HEIGHT *scale));
        }

        batch.draw(introBorderTexture, 0, 0, (int)(MAX_WIDTH *scale), (int)(MAX_HEIGHT *scale));
        batch.end();
    }


    // We need to choose which function in the animationhandler to activate, we check for keyframe
    public void drawHelper(SpriteBatch batch, AnimationHandler animationHandler, IntroInstruction instruct) {


        // Checking if it's an still image or not to render
        final boolean renderStillImage = instruct.getKeyFrame() != -1;

        if (renderStillImage) {
            animationHandler.drawAnimation(batch, instruct, delta,instruct.getKeyFrame() ,scale);

        }

        else {
            animationHandler.drawAnimation(batch, instruct,delta,scale);
        }
    }


    private void drawAnimations(SpriteBatch batch){
        //Drawing the demon in intro
        for (final IntroInstruction instruct : allInstructions.get(0)) {
            drawHelper(batch, animationHandlerDemon, instruct);
        }
        //Drawing his dialogues
        for (final IntroInstruction instruct : allInstructions.get(1)) {
            drawHelper(batch, dialogueHandler, instruct);
        }
        //Drawing second wiz dialogues
        for (final IntroInstruction instruct : allInstructions.get(2)) {
            drawHelper(batch, dialogueHandler, instruct);
        }
        //Drawing the first wiz in intro
        for (final IntroInstruction instruct : allInstructions.get(3)) {
            drawHelper(batch, animationHandlerWizard1, instruct);
        }
        //Drawing the second wiz in intro
        for (final IntroInstruction instruct : allInstructions.get(4)) {
            drawHelper(batch, animationHandlerWizard2, instruct);
        }

        //Drawing the spell animation
        for (final IntroInstruction instruct : allInstructions.get(5)) {
            drawHelper(batch, animationService, animationHandlerSpell, instruct);

        }
    }

    // This function takes care of interpolated X and Y animation render.
    public void drawHelper(SpriteBatch batch, AnimationService animationloader, AnimationHandler animationHandler,
                           IntroInstruction instruct) {
        animationHandler.drawAnimation(batch, animationloader, instruct,scale);
    }

    //This drawhelper renders the bubbles
    public void drawHelper(SpriteBatch batch, DialogueHandler dialogHandler, IntroInstruction instruct) {

        dialogHandler.drawChatDialogue(batch, instruct.getDialogNumber(), instruct.getStartTime(), instruct.getEndTime(), scale);

    }

    public void setScale(double height){
        scale = height / MAX_WIDTH;

    }

}

