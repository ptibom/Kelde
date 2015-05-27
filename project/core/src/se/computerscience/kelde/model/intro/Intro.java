package se.computerscience.kelde.model.intro;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class Intro {



    // Coordinates on spritesheet used to read them in and create TextureRegion
    private  int[] INTRO_WIZARD_SPRITE_COORDINATES = new int[18];
    private  int[] INTRO_DEMON_SPRITE_COORDINATES = new int[84];
    private  int[] INTRO_SPELL_SPRITE_COORDINATES = new int[26];

    // Dialogue and Text images
    private  final String[] INFO_TEXT_PATH_IMAGES = new String[8];
    private  final String[] INTRO_DIALOGUE_IMAGES = new String[30];

    //
    private  final float ANIMATION_SPEED = 0.27f;

    private  final String INTRO_SOUND_PATH = "intro/dfear.mp3";

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
        INTRO_DEMON_SPRITE_COORDINATES = AnimationToolsUtilites.loadTextureRegionData(INTRO_DEMON_SPRITE_SIZE, introDemonData);
        INTRO_WIZARD_SPRITE_COORDINATES = AnimationToolsUtilites.loadTextureRegionData(INTRO_WIZARD_SPRITE_SIZE, introWizardData);
        INTRO_SPELL_SPRITE_COORDINATES = AnimationToolsUtilites.loadTextureRegionData(INTRO_SPELL_SPRITE_SIZE, introSpellData);

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



    public int[] getWizardTalkCoordinates() {


        return Arrays.copyOf(INTRO_WIZARD_SPRITE_COORDINATES,INTRO_WIZARD_SPRITE_COORDINATES.length);

    }

    public int[] getSpellIntroCoordinaters() {

        return Arrays.copyOf(INTRO_SPELL_SPRITE_COORDINATES,INTRO_SPELL_SPRITE_COORDINATES.length);
    }


    public String[] getDialogues() { return Arrays.copyOf(INTRO_DIALOGUE_IMAGES,INTRO_DIALOGUE_IMAGES.length);

    }

    public String[] getIntroTextImages() {
        return Arrays.copyOf(INFO_TEXT_PATH_IMAGES, INFO_TEXT_PATH_IMAGES.length);

    }

    public int[] getIntroDemonCoordinates() {

        return Arrays.copyOf(INTRO_DEMON_SPRITE_COORDINATES,INTRO_DEMON_SPRITE_COORDINATES.length);

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
