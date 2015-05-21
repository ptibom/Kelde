package se.computerscience.kelde.model.intro;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class Intro {

    // Coordinates on spritesheet used to read them in and create TextureRegion
    private static final int[] INTRO_WIZARD_TALK_COORDINATES = new int[18];
    private static final int[] INTRO_DEMON_ANIMATION_COORDINATES = new int[84];
    private static final int[] INTRO_SPELL_ANIMATION_COORDINATES = new int[26];

    //The length of all animations, used to read in right amount of frame into the animation
    private static final int[] INTRO_WIZARD_ANIMATION_LENGTH_DATA = new int[]{3, 3, 2};
    private static final int[] INTRO_SPELL_ANIMATION_LENGTH_DATA = new int[]{3, 5, 4};
    private static final int[] INTRO_DEMON_ANIMATION_LENGTH_DATA = new int[]{4, 3, 2, 1, 3, 2, 4, 3, 3, 3, 1, 1, 1, 3, 3, 4};

    // Dialogue and Text images
    private static final String[] INFO_TEXT_PATH_IMAGES = new String[8];
    private static final String[] INTRO_DIALOGUE_IMAGES = new String[30];

    // The spritesheets
    private static final String INTRO_SPELL_PATH_IMAGE = "intro/spell.png";
    private static final String INTRO_DEMON_ANIMATION_PATH_IMAGE = "intro/introsprites.png";
    private static final String INTRO_WIZARD_ANIMATION_PATH_IMAGE = "intro/introtalk.png";

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

        loadTextureRegionData(INTRO_DEMON_SPRITE_SIZE,INTRO_DEMON_ANIMATION_COORDINATES,introDemonData );

        loadTextureRegionData(INTRO_WIZARD_SPRITE_SIZE,INTRO_WIZARD_TALK_COORDINATES,introWizardData );

        loadTextureRegionData(INTRO_SPELL_SPRITE_SIZE,INTRO_SPELL_ANIMATION_COORDINATES,introSpellData );


        List<String> introDemonInstructions = inputData.get(3);
        List<String> introWizard1Instructions = inputData.get(4);
        List<String> introWizard2Instructions = inputData.get(5);
        List<String> introWizardDialogueInstructions = inputData.get(6);
        List<String> introDemonDialogueInstructions = inputData.get(7);
        List<String> introSpellInstructions = inputData.get(8);


        // Loading data for the demon's dialoges.
        loadAndGatherInstructions( introDemonInstructions);
        loadAndGatherInstructions(introDemonDialogueInstructions);

        loadAndGatherInstructions(introWizardDialogueInstructions);

        // Loading data for the sprite animation.

        loadAndGatherInstructions(introWizard1Instructions);
        loadAndGatherInstructions(introWizard2Instructions);
        loadAndGatherInstructions(introSpellInstructions);

    }


    public List<List<IntroInstruction>> getInstructions() {
        return allInstructions;
    }

    // Loading the coordinates for each TextureRegion
    public void loadTextureRegionData(int spriteSize, int[] TextureRegionCoordinatesOut, List<String> data){
        for (int i = 7, dataIndex =2; i < data.size(); i += 7) {

            TextureRegionCoordinatesOut[0] = spriteSize;
            TextureRegionCoordinatesOut[1] = spriteSize;

            String[] tempFormat = data.get(i - 1).split(" ");
            TextureRegionCoordinatesOut[dataIndex] = Integer.parseInt(tempFormat[3]);
            TextureRegionCoordinatesOut[dataIndex + 1] = Integer.parseInt(tempFormat[4].replaceAll("\r", ""));
            dataIndex += 2;
        }

    }


    // Takes a string with instructions and converts it into instruction class to feed the animationhandler
    public void loadAndGatherInstructions(List<String> instructionString){

        List<IntroInstruction> setOfInstruction = new ArrayList<>();
        for (String data : instructionString) {
            String[] splitData = data.split(" ");

            if(splitData.length>6) {
                double startTime = Double.parseDouble(splitData[0]);
                double endTime = Double.parseDouble(splitData[1]);
                int heightChange = Integer.parseInt(splitData[2]);
                int widthChange = Integer.parseInt(splitData[3]);
                int xChange = Integer.parseInt(splitData[4]);
                int yChange = Integer.parseInt(splitData[5]);
                String animationName = splitData[6];


                // Check if it's an still keyframe or regular animaton
                if (splitData.length == 8) {
                    float keyFrame = Integer.parseInt(splitData[7]);
                    setOfInstruction.add(new IntroInstruction(startTime, endTime, keyFrame, heightChange, widthChange, xChange, yChange, animationName));
                } else {
                    setOfInstruction.add(new IntroInstruction(startTime, endTime, heightChange, widthChange, xChange, yChange, animationName));
                }


            }

            // Checks if it it's a interpolated X Y coordinates instruction
            else if (splitData.length == 4){

                    double startCount = Double.parseDouble(splitData[0]);
                    double startTime = Double.parseDouble(splitData[1]);
                    double endTime = Double.parseDouble(splitData[2]);
                    String animationName = splitData[3];

                    setOfInstruction.add(new IntroInstruction(startCount, startTime, endTime, animationName));

            }

            // Checks if it's an dialogue
            else if (splitData.length == 3){

                    int dialogNumber = Integer.parseInt(splitData[0]);
                    double startTime = Double.parseDouble(splitData[1]);
                    double endTime = Double.parseDouble(splitData[2]);
                    setOfInstruction.add(new IntroInstruction(dialogNumber, startTime, endTime));
            }
        }
        allInstructions.add(setOfInstruction);
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

    public int[] getXAnimPathArray(){
        return animPathCordsX;

    }

    public int[] getYAnimPathArray(){
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
