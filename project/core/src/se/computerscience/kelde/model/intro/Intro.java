package se.computerscience.kelde.model.intro;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

public class Intro {

    private static final int[] INTRO_WIZARD_ANIMATION_LENGTH_DATA = new int[]{3, 3, 2};
    private static final int[] INTRO_WIZARD_TALK_COORDINATES = new int[18];
    private static final String[] INFO_TEXT_PATH_IMAGES = new String[8];
    private static final String[] INTRO_DIALOGUE_IMAGES = new String[30];
    private static final int[] INTRO_DEMON_ANIMATION_COORDINATES = new int[84];
    private static final int[] INTRO_SPELL_ANIMATION_LENGTH_DATA = new int[]{3, 5, 4};
    private static final int[] INTRO_SPELL_ANIMATION_COORDINATES = new int[26];
    private static final String INTRO_SPELL_PATH_IMAGE = "intro/spell.png";
    private static final String INTRO_DEMON_ANIMATION_PATH_IMAGE = "intro/introsprites.png";
    private static final String INTRO_WIZARD_ANIMATION_PATH_IMAGE = "intro/introtalk.png";
    private static final int[] INTRO_DEMON_ANIMATION_LENGTH_DATA = new int[]{4, 3, 2, 1, 3, 2, 4, 3, 3, 3, 1, 1, 1, 3, 3, 4};
    private static final String INTRO_BORDER_PATH_IMAGE = "intro/borderintro.png";
    private static final String INTRO_BACKGROUND_PATH_IMAGE = "intro/backgroundintro.png";
    private static final String INTRO_SOUND_PATH = "intro/dfear2.mp3";
    private static final String FOREGROUND_INTRO_PATH_IMAGE = "intro/foregroundintro.png";
    private static final String INTRO_CAVE_BACKGROUND = "intro/cavebackground.png";
    List<List<IntroInstruction>> allInstructions = new ArrayList<List<IntroInstruction>>();


    Timer introTimer;

    public Intro(List<List<String>> inputData) throws IOException {


        List<String> introDemonData = inputData.get(0);
        List<String> introWizardData = inputData.get(1);
        List<String> introSpellData = inputData.get(2);
        List<String> introDemonInstructions = inputData.get(3);
        List<String> introWizard1Instructions = inputData.get(4);
        List<String> introWizard2Instructions = inputData.get(5);
        List<String> introWizardDialogueInstructions = inputData.get(6);
        List<String> introDemonDialogueInstructions = inputData.get(7);
        List<String> introSpellInstructions = inputData.get(8);

        introTimer = new Timer();

        for (int i = 0; i < 8; i++) {
            INFO_TEXT_PATH_IMAGES[i] = "intro/introtext" + (i + 1) + ".png";
        }

        for (int i = 0; i < 30; i++) {
            INTRO_DIALOGUE_IMAGES[i] = "intro/dialogues/dialogue" + (i + 1) + ".png";
        }


        int dataIndex = 2;
        int INTRO_DEMON_SPRITE_SIZE = 128;
        INTRO_DEMON_ANIMATION_COORDINATES[0] = INTRO_DEMON_SPRITE_SIZE;
        INTRO_DEMON_ANIMATION_COORDINATES[1] = INTRO_DEMON_SPRITE_SIZE;

        for (int i = 7; i < introDemonData.size(); i += 7) {

            String[] tempFormat = introDemonData.get(i - 1).split(" ");
            INTRO_DEMON_ANIMATION_COORDINATES[dataIndex] = Integer.parseInt(tempFormat[3]);
            INTRO_DEMON_ANIMATION_COORDINATES[dataIndex + 1] = Integer.parseInt(tempFormat[4].replaceAll("\r", ""));
            dataIndex += 2;
        }

        dataIndex = 2;
        int INTRO_WIZARD_SPRITE_SIZE = 300;
        INTRO_WIZARD_TALK_COORDINATES[0] = INTRO_WIZARD_SPRITE_SIZE;
        INTRO_WIZARD_TALK_COORDINATES[1] = INTRO_WIZARD_SPRITE_SIZE;

        for (int i = 7; i < introWizardData.size(); i += 7) {

            String[] tempFormat = introWizardData.get(i - 1).split(" ");
            INTRO_WIZARD_TALK_COORDINATES[dataIndex] = Integer.parseInt(tempFormat[3]);
            INTRO_WIZARD_TALK_COORDINATES[dataIndex + 1] = Integer.parseInt(tempFormat[4].replaceAll("\r", ""));
            dataIndex += 2;
        }
        int INTRO_SPELL_SPRITE_SIZE = 100;
        INTRO_SPELL_ANIMATION_COORDINATES[0] = INTRO_SPELL_SPRITE_SIZE;
        INTRO_SPELL_ANIMATION_COORDINATES[1] = INTRO_SPELL_SPRITE_SIZE;

        dataIndex = 2;

        for (int i = 7; i < introSpellData.size(); i += 7) {

            String[] tempFormat = introSpellData.get(i - 1).split(" ");
            INTRO_SPELL_ANIMATION_COORDINATES[dataIndex] = Integer.parseInt(tempFormat[3]);
            INTRO_SPELL_ANIMATION_COORDINATES[dataIndex + 1] = Integer.parseInt(tempFormat[4].replaceAll("\r", ""));
            dataIndex += 2;

        }
        dataIndex = 2;
        // Loading data for the demon's animation.
        List<IntroInstruction> demonInstructions = new ArrayList<IntroInstruction>();
        ;
        for (String data : introDemonInstructions) {
            String[] splitData = data.split(" ");
            double startTime = Double.parseDouble(splitData[0]);
            double endTime = Double.parseDouble(splitData[1]);
            int heightChange = Integer.parseInt(splitData[2]);
            int widthChange = Integer.parseInt(splitData[3]);
            int xChange = Integer.parseInt(splitData[4]);
            int yChange = Integer.parseInt(splitData[5]);
            String animationName = splitData[6];

            demonInstructions.add(new IntroInstruction(startTime, endTime, heightChange, widthChange, xChange, yChange, animationName));
        }
        allInstructions.add(demonInstructions);
        // Loading data for the demon's dialoges.
        List<IntroInstruction> demonDialogInstructions = new ArrayList<>();
        for (String data : introDemonDialogueInstructions) {

            String[] splitData = data.split(" ");
            int dialogNumber = Integer.parseInt(splitData[0]);
            double startTime = Double.parseDouble(splitData[1]);
            double endTime = Double.parseDouble(splitData[2]);

            demonDialogInstructions.add(new IntroInstruction(dialogNumber, startTime, endTime));

        }
        allInstructions.add(demonDialogInstructions);
        //loading wizard's dialogues
        List<IntroInstruction> wizardDialogInstructions = new ArrayList<>();
        for (String data : introWizardDialogueInstructions) {

            String[] splitData = data.split(" ");
            int dialogNumber = Integer.parseInt(splitData[0]);
            double startTime = Double.parseDouble(splitData[1]);
            double endTime = Double.parseDouble(splitData[2]);

            wizardDialogInstructions.add(new IntroInstruction(dialogNumber, startTime, endTime));

        }
        allInstructions.add(wizardDialogInstructions);

        List<IntroInstruction> wizardInstructions = new ArrayList<>();
        for (String data : introWizard1Instructions) {
            String[] splitData = data.split(" ");
            double startTime = Double.parseDouble(splitData[0]);
            double endTime = Double.parseDouble(splitData[1]);
            int heightChange = Integer.parseInt(splitData[2]);
            int widthChange = Integer.parseInt(splitData[3]);
            int xChange = Integer.parseInt(splitData[4]);
            int yChange = Integer.parseInt(splitData[5]);
            String animationName = splitData[6];
            if (splitData.length == 8) {
                float keyFrame = Integer.parseInt(splitData[7]);
                wizardInstructions.add(new IntroInstruction(startTime, endTime, keyFrame, heightChange, widthChange, xChange, yChange, animationName));
            } else {
                wizardInstructions.add(new IntroInstruction(startTime, endTime, heightChange, widthChange, xChange, yChange, animationName));
            }

        }
        allInstructions.add(wizardInstructions);

        List<IntroInstruction> wizard2Instructions = new ArrayList<>();
        for (String data : introWizard2Instructions) {
            String[] splitData = data.split(" ");
            double startTime = Double.parseDouble(splitData[0]);
            double endTime = Double.parseDouble(splitData[1]);
            int heightChange = Integer.parseInt(splitData[2]);
            int widthChange = Integer.parseInt(splitData[3]);
            int xChange = Integer.parseInt(splitData[4]);
            int yChange = Integer.parseInt(splitData[5]);
            String animationName = splitData[6];

            wizard2Instructions.add(new IntroInstruction(startTime, endTime, heightChange, widthChange, xChange, yChange, animationName));
        }
        allInstructions.add(wizard2Instructions);

        List<IntroInstruction> spellInstructions = new ArrayList<>();
        for (String data : introSpellInstructions) {

            String[] splitData = data.split(" ");
            double startCount = Double.parseDouble(splitData[0]);
            double startTime = Double.parseDouble(splitData[1]);
            double endTime = Double.parseDouble(splitData[2]);
            String animationName = splitData[3];

            spellInstructions.add(new IntroInstruction(startCount, startTime, endTime, animationName));

        }
        allInstructions.add(spellInstructions);


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
