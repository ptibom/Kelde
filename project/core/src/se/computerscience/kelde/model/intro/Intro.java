package se.computerscience.kelde.model.intro;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class Intro {

    // The spritesheets
    private static final String INTRO_SPELL_PATH_IMAGE = "intro/spell.png";
    private static final String INTRO_DEMON_ANIMATION_PATH_IMAGE = "intro/introsprites.png";
    private static final String INTRO_WIZARD_ANIMATION_PATH_IMAGE = "intro/introtalk.png";

    // Coordinates on spritesheet used to read them in and create TextureRegion
    private static  int[] INTRO_WIZARD_TALK_COORDINATES = new int[18];
    private static  int[] INTRO_DEMON_ANIMATION_COORDINATES = new int[84];
    private static  int[] INTRO_SPELL_ANIMATION_COORDINATES = new int[26];

    //The length of all animations, used to read in right amount of frame into the animation
    private static final int[] INTRO_WIZARD_ANIMATION_LENGTH_DATA = new int[]{3, 3, 2};
    private static final int[] INTRO_SPELL_ANIMATION_LENGTH_DATA = new int[]{3, 5, 4};
    private static final int[] INTRO_DEMON_ANIMATION_LENGTH_DATA = new int[]{4, 3, 2, 1, 3, 2, 4, 3, 3, 3, 1, 1, 1, 3, 3, 4};

    // Dialogue and Text images
    private static final String[] INFO_TEXT_PATH_IMAGES = new String[8];
    private static final String[] INTRO_DIALOGUE_IMAGES = new String[30];

    //Background and foreground images used in the intro
    private static final String INTRO_BORDER_PATH_IMAGE = "intro/borderintro.png";
    private static final String INTRO_BACKGROUND_PATH_IMAGE = "intro/backgroundintro.png";
    private static final String FOREGROUND_INTRO_PATH_IMAGE = "intro/foregroundintro.png";
    private static final String INTRO_CAVE_BACKGROUND = "intro/cavebackground.png";

    int[] animPathCordsX = new int[]{740, 792, 816, 871, 921, 985, 1075, 1161, 1239, 1276, 1201, 1114, 1036, 966, 960, 1100, 1300, 1400, 1400, 1400};
    int[] animPathCordsY = new int[]{400, 666, 699, 747, 783, 814, 831, 810, 852, 801, 745, 700, 658, 582, 490, 418, 440, 500, 500, 500};

    private static final String INTRO_SOUND_PATH = "intro/dfear2.mp3";

    List<List<IntroInstruction>> allInstructions = new ArrayList<List<IntroInstruction>>();


    Timer introTimer;

    public Intro(List<List<String>> inputData) throws IOException {

        // Read from file .txt
        List<String> introDemonData = inputData.get(0);
        List<String> introWizardData = inputData.get(1);
        List<String> introSpellData = inputData.get(2);

        introTimer = new Timer();

        // read in the dialogues
        for (int i = 0; i < 8; i++) {
            INFO_TEXT_PATH_IMAGES[i] = "intro/introtext" + (i + 1) + ".png";
        }

        for (int i = 0; i < 30; i++) {
            INTRO_DIALOGUE_IMAGES[i] = "intro/dialogues/dialogue" + (i + 1) + ".png";
        }


        // Reading in the sprite sheet data
        int INTRO_DEMON_SPRITE_SIZE = 128;
        int INTRO_WIZARD_SPRITE_SIZE = 300;
        int INTRO_SPELL_SPRITE_SIZE = 100;

        INTRO_DEMON_ANIMATION_COORDINATES = AnimationTools.loadTextureRegionData(INTRO_DEMON_SPRITE_SIZE,introDemonData);
        INTRO_WIZARD_TALK_COORDINATES =AnimationTools.loadTextureRegionData(INTRO_WIZARD_SPRITE_SIZE, introWizardData);
        INTRO_SPELL_ANIMATION_COORDINATES =AnimationTools.loadTextureRegionData(INTRO_SPELL_SPRITE_SIZE, introSpellData);

        //Read from file .intro
        List<String> introDemonInstructions = inputData.get(3);
        List<String> introWizard1Instructions = inputData.get(4);
        List<String> introWizard2Instructions = inputData.get(5);
        List<String> introWizardDialogueInstructions = inputData.get(6);
        List<String> introDemonDialogueInstructions = inputData.get(7);
        List<String> introSpellInstructions = inputData.get(8);


        // Loading data for the demon's dialoges.
        allInstructions.add(InstructionTools.loadAndGatherInstructions(introDemonInstructions));
        allInstructions.add(InstructionTools.loadAndGatherInstructions(introDemonDialogueInstructions));

        allInstructions.add(InstructionTools.loadAndGatherInstructions(introWizardDialogueInstructions));

        // Loading data for the sprite animation.
        allInstructions.add(InstructionTools.loadAndGatherInstructions(introWizard1Instructions));
        allInstructions.add(InstructionTools.loadAndGatherInstructions(introWizard2Instructions));
        allInstructions.add(InstructionTools.loadAndGatherInstructions(introSpellInstructions));

    }


    public List<List<IntroInstruction>> getInstructions() {
        return allInstructions;
    }

    public int[] getWizardAnimationData() {
        return INTRO_WIZARD_ANIMATION_LENGTH_DATA;
    }

    public int[] getWizardTalkCoordinates() {

        return INTRO_WIZARD_TALK_COORDINATES;
    }

    public int[] getSpellIntroCoordinaters() {

        return INTRO_SPELL_ANIMATION_COORDINATES;
    }

    public int[] getSpellAnimationLength() {

        return INTRO_SPELL_ANIMATION_LENGTH_DATA;
    }

    public String[] getDialogues() {
        return INTRO_DIALOGUE_IMAGES;
    }

    public String[] getIntroTextImages() {
        return INFO_TEXT_PATH_IMAGES;
    }

    public int[] getIntroDemonCoordinates() {

        return INTRO_DEMON_ANIMATION_COORDINATES;
    }

    public String getSpellSpritePath() {

        return INTRO_SPELL_PATH_IMAGE;
    }

    public String getDemonAnd2ndWizardImage() {

        return INTRO_DEMON_ANIMATION_PATH_IMAGE;
    }

    public int[] getDemonAnimationData() {

        return INTRO_DEMON_ANIMATION_LENGTH_DATA;
    }

    public String getIntroWizardTalkImage() {
        return INTRO_WIZARD_ANIMATION_PATH_IMAGE;
    }

    public String getIntroBorderImage() {

        return INTRO_BORDER_PATH_IMAGE;
    }

    public String getIntroBackgroundImage() {

        return INTRO_BACKGROUND_PATH_IMAGE;

    }

    public String getIntroSound() {

        return INTRO_SOUND_PATH;
    }

    public String getForegroundIntroImage() {
        return FOREGROUND_INTRO_PATH_IMAGE;
    }

    public String getCaveBackground() {
        return INTRO_CAVE_BACKGROUND;
    }

    public double getMenuTime() {

        return introTimer.getMenuTime();
    }

    public void updateTimer() {

        introTimer.updateTimer();
    }

    public void resetTimer() {

        introTimer.resetTimer();
    }

    public int[] getXAnimPathArray() {
        return animPathCordsX;

    }

    public int[] getYAnimPathArray() {
        return animPathCordsY;

    }

    public float getStateTime() {
        return introTimer.getStateTime();
    }

    public void updateStateTime(float delta) {
        introTimer.updateStateTime(delta);
    }


    public String[] getInfoTextImages() {
        return INFO_TEXT_PATH_IMAGES;
    }

}
