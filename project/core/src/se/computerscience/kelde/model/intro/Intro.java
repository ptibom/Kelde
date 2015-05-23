package se.computerscience.kelde.model.intro;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class Intro {



    // Coordinates on spritesheet used to read them in and create TextureRegion
    private static  int[] INTRO_WIZARD_SPRITE_COORDINATES = new int[18];
    private static  int[] INTRO_DEMON_SPRITE_COORDINATES = new int[84];
    private static  int[] INTRO_SPELL_SPRITE_COORDINATES = new int[26];

    // Dialogue and Text images
    private static final String[] INFO_TEXT_PATH_IMAGES = new String[8];
    private static final String[] INTRO_DIALOGUE_IMAGES = new String[30];

    //
    private static final float ANIMATION_SPEED = 0.27f;

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

        // Reads the input strings to an array of values for each image
        INTRO_DEMON_SPRITE_COORDINATES = AnimationTools.loadTextureRegionData(INTRO_DEMON_SPRITE_SIZE,introDemonData);
        INTRO_WIZARD_SPRITE_COORDINATES =AnimationTools.loadTextureRegionData(INTRO_WIZARD_SPRITE_SIZE, introWizardData);
        INTRO_SPELL_SPRITE_COORDINATES =AnimationTools.loadTextureRegionData(INTRO_SPELL_SPRITE_SIZE, introSpellData);

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
        return ConstantsAnimation.INTRO_WIZARD_ANIMATION_LENGTH_DATA;
    }

    public int[] getWizardTalkCoordinates() {

        return INTRO_WIZARD_SPRITE_COORDINATES;
    }

    public int[] getSpellIntroCoordinaters() {

        return INTRO_SPELL_SPRITE_COORDINATES;
    }

    public int[] getSpellAnimationLength() {

        return ConstantsAnimation.INTRO_SPELL_ANIMATION_LENGTH_DATA;
    }

    public String[] getDialogues() {
        return INTRO_DIALOGUE_IMAGES;
    }

    public String[] getIntroTextImages() {
        return INFO_TEXT_PATH_IMAGES;
    }

    public int[] getIntroDemonCoordinates() {

        return INTRO_DEMON_SPRITE_COORDINATES;
    }

    public String getSpellSpritePath() {

        return ConstantsAnimation.INTRO_SPELL_PATH_IMAGE;
    }

    public String getDemonAnd2ndWizardImage() {

        return ConstantsAnimation.INTRO_DEMON_ANIMATION_PATH_IMAGE;
    }

    public int[] getDemonAnimationData() {

        return ConstantsAnimation.INTRO_DEMON_ANIMATION_LENGTH_DATA;
    }

    public String getIntroWizardTalkImage() {
        return ConstantsAnimation.INTRO_WIZARD_ANIMATION_PATH_IMAGE;
    }

    public String getIntroBorderImage() {

        return ConstantsAnimation.INTRO_BORDER_PATH_IMAGE;
    }

    public String getIntroBackgroundImage() {

        return ConstantsAnimation.INTRO_BACKGROUND_PATH_IMAGE;

    }

    public String getIntroSound() {

        return INTRO_SOUND_PATH;
    }

    public String getForegroundIntroImage() {
        return ConstantsAnimation.FOREGROUND_INTRO_PATH_IMAGE;
    }

    public String getCaveBackground() {
        return ConstantsAnimation.INTRO_CAVE_BACKGROUND;
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
        return ConstantsAnimation.animPathCordsX;

    }

    public int[] getYAnimPathArray() {
        return ConstantsAnimation.animPathCordsY;

    }

    public float getStateTime() {
        return introTimer.getStateTime();
    }

    public void updateStateTime(float delta) {
        introTimer.updateStateTime(delta);
    }

    public float getAnimationSpeed(){
            return ANIMATION_SPEED;
    }

}
