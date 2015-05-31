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
                introModel.getAnimationSpeed(), new Texture(ConstantsPath.getIntroWizardAnimationPathImage()));
        final Map<String, Animation> demonAnimations = AnimationConverter.convertToLibgdxAnimation(animationService.getDemonAnimations(),
                introModel.getAnimationSpeed(), new Texture(ConstantsPath.getIntroDemonAnimationPathImage()));
        final Map<String, Animation> wizard2 = AnimationConverter.convertToLibgdxAnimation(animationService.getWizard2Animations(),
                introModel.getAnimationSpeed(), new Texture(ConstantsPath.getIntroDemonAnimationPathImage()));
        final Map<String, Animation> spellAnimations = AnimationConverter.convertToLibgdxAnimation(animationService.getSpellAnimations(),
                introModel.getAnimationSpeed(), new Texture(ConstantsPath.getIntroSpellPathImage()));

        final int introLength = 47;
        final int wizardOriginX = 1350;
        final int wizardOriginY = 200;
        final int demonOriginX = 1285;
        final int demonOriginY = 580;
        final int demonSpriteSize = 128;
        final int wizard2OriginX = -200;
        final int wizard2OriginY = 90;
        final int wizard2SpriteSize = 420;
        final int spellOriginX = 740;
        final int spellOriginY = 400;
        final int spellSpriteSize = 128;

         animationHandlerWizard1 = new AnimationHandler(introModel,wizardAnimations, wizardOriginX, wizardOriginY,
                introModel.getWizardTalkCoordinates()[0], introModel.getWizardTalkCoordinates()[1], 0);

        animationHandlerDemon = new AnimationHandler(introModel, demonAnimations, demonOriginX, demonOriginY,
                demonSpriteSize, demonSpriteSize, introLength);

        animationHandlerWizard2 = new AnimationHandler(introModel, wizard2, wizard2OriginX, wizard2OriginY,
                wizard2SpriteSize, wizard2SpriteSize, introLength);

        animationHandlerSpell = new AnimationHandler(introModel, spellAnimations, spellOriginX, spellOriginY,
                spellSpriteSize, spellSpriteSize, introLength);

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
                dialogueHandler.drawTextDialogue(i, batch, introModel.getOriginOfText() +
                        i * introModel.getTextSpeed(), introModel.getTextLengthOfStaying(), delta, scale);
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

