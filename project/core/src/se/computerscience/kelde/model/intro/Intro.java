package se.computerscience.kelde.model.intro;

import se.computerscience.kelde.model.startmenu.Timer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Daniel on 5/20/2015.
 */
public class Intro {

    private static final int[] INTRO_WIZARD_ANIMATION_LENGTH_DATA = new int[]{3, 3, 2};
    private static final int[] INTRO_WIZARD_TALK_COORDINATES = new int[18];
    private static final String[] INFO_TEXT_PATH_IMAGES = new String[8];
    private static final String[] INTRO_DIALOGUE_IMAGES = new String[30];
    private static final int[] INTRO_DEMON_ANIMATION_COORDINATES = new int[84];
    private int INTRO_DEMON_SPRITE_SIZE = 128, INTRO_WIZARD_SPRITE_SIZE = 300, INTRO_SPELL_SPRITE_SIZE  = 100;
    private static final int[] INTRO_SPELL_ANIMATION_LENGTH_DATA = new int[]{3, 5, 4};
    private static final int[] INTRO_SPELL_ANIMATION_COORDINATES = new int[26];
    private static final String INTRO_SPELL_PATH_IMAGE = "intro/spell.png";
    private static final String INTRO_DEMON_ANIMATION_PATH_IMAGE = "intro/introsprites.png";
    private static final String INTRO_WIZARD_ANIMATION_PATH_IMAGE = "intro/introtalk.png";
    private static final int[] INTRO_DEMON_ANIMATION_LENGTH_DATA = new int[]{4, 3, 2, 1, 3, 2, 4, 3, 3, 3, 1, 1, 1, 3,3, 4};
    private static final String INTRO_BORDER_PATH_IMAGE = "intro/borderintro.png";
    private static final String INTRO_BACKGROUND_PATH_IMAGE = "intro/backgroundintro.png";
    private static final String INTRO_SOUND_PATH = "intro/dfear2.mp3";
    private static final String FOREGROUND_INTRO_PATH_IMAGE = "intro/foregroundintro.png";
    private static final String INTRO_CAVE_BACKGROUND = "intro/cavebackground.png";

    Timer menuTimer;

    public Intro() throws IOException {

        menuTimer = new Timer();

        for (int i = 0; i < 8; i++) {
            INFO_TEXT_PATH_IMAGES[i] = "intro/introtext" + (i + 1) + ".png";
        }

        for (int i = 0; i < 30; i++) {
            INTRO_DIALOGUE_IMAGES[i] = "intro/dialogues/dialogue" + (i + 1) + ".png";
        }



        char[] introDemonTemp;
        char[] introWizardTemp;
        char[] introSpellTemp;
        String introDemonData;
        String introWizardData;
        String introSpellData;
        File textfile1 = new File("intro/introtalk.txt");
        File textfile2 = new File("intro/introsprites.txt");
        File textfile3 = new File("intro/spell.txt");
        FileReader textReader = new FileReader(textfile1);
        FileReader textReader2 = new FileReader(textfile2);
        FileReader textReader3 = new FileReader(textfile3);
        introWizardTemp = new char[(int) textfile1.length()];
        introDemonTemp = new char[(int) textfile2.length()];
        introSpellTemp = new char[(int) textfile3.length()];
        textReader.read(introWizardTemp);
        textReader2.read(introDemonTemp);
        textReader3.read(introSpellTemp);
        introDemonData = new String(introDemonTemp);
        introWizardData = new String(introWizardTemp);
        introSpellData = new String(introSpellTemp);
        String[] demonDataLines = introDemonData.split("\n");
        String[] wizardDataLines = introWizardData.split("\n");
        String[] spellDataLines =  introSpellData.split("\n");



        int dataIndex = 2;
        INTRO_DEMON_ANIMATION_COORDINATES[0] = INTRO_DEMON_SPRITE_SIZE;
        INTRO_DEMON_ANIMATION_COORDINATES[1] = INTRO_DEMON_SPRITE_SIZE;

        for (int i = 7; i < demonDataLines.length; i += 7) {

            String[] tempFormat = demonDataLines[i-1].split(" ");
            INTRO_DEMON_ANIMATION_COORDINATES[dataIndex] = Integer.parseInt(tempFormat[3]);
            INTRO_DEMON_ANIMATION_COORDINATES[dataIndex+1] = Integer.parseInt(tempFormat[4].replaceAll("\r",""));
            dataIndex += 2;
        }

        dataIndex = 2;

        INTRO_WIZARD_TALK_COORDINATES[0] = INTRO_WIZARD_SPRITE_SIZE;
        INTRO_WIZARD_TALK_COORDINATES[1] = INTRO_WIZARD_SPRITE_SIZE;

        for(int i = 7; i< wizardDataLines.length; i+=7){

            String[] tempFormat = wizardDataLines[i-1].split(" ");
            INTRO_WIZARD_TALK_COORDINATES[dataIndex] = Integer.parseInt(tempFormat[3]);
            INTRO_WIZARD_TALK_COORDINATES[dataIndex+1] = Integer.parseInt(tempFormat[4].replaceAll("\r",""));
            dataIndex += 2;
        }

        INTRO_SPELL_ANIMATION_COORDINATES[0] = INTRO_SPELL_SPRITE_SIZE;
        INTRO_SPELL_ANIMATION_COORDINATES[1] = INTRO_SPELL_SPRITE_SIZE;

        dataIndex = 2;

        for(int i = 7; i< spellDataLines.length; i+=7){

            String[] tempFormat = spellDataLines[i-1].split(" ");
            INTRO_SPELL_ANIMATION_COORDINATES[dataIndex] = Integer.parseInt(tempFormat[3]);
            INTRO_SPELL_ANIMATION_COORDINATES[dataIndex+1] = Integer.parseInt(tempFormat[4].replaceAll("\r",""));
            dataIndex += 2;

        }
        dataIndex = 2;





    }

    public int[] getWizardAnimationData(){
        return INTRO_WIZARD_ANIMATION_LENGTH_DATA;
    }

    public int[] getWizardTalkCoordinates() {

        return INTRO_WIZARD_TALK_COORDINATES;
    }

    public int[] getSpellIntroCoordinaters(){

        return INTRO_SPELL_ANIMATION_COORDINATES;
    }
    public int[] getSpellAnimationLength(){

        return INTRO_SPELL_ANIMATION_LENGTH_DATA;
    }
    public String[] getDialogues(){
        return INTRO_DIALOGUE_IMAGES;
    }
    public String[] getIntroTextImages(){
        return INFO_TEXT_PATH_IMAGES;
    }

    public int[] getIntroDemonCoordinates() {

        return INTRO_DEMON_ANIMATION_COORDINATES;
    }

    public String getSpellSpritePath(){

             return INTRO_SPELL_PATH_IMAGE;
    }
    public String getDemonAnd2ndWizardImage(){

        return INTRO_DEMON_ANIMATION_PATH_IMAGE;
    }
    public int[] getDemonAnimationData(){

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
    public String getIntroSound(){

        return INTRO_SOUND_PATH;
    }

    public String getForegroundIntroImage() {
        return FOREGROUND_INTRO_PATH_IMAGE;
    }

    public String getCaveBackground(){
        return INTRO_CAVE_BACKGROUND;
    }

    public double getMenuTime(){

        return menuTimer.getMenuTime();
    }

    public float getDeltaTime(){

        return menuTimer.getDeltaTime();
    }

    public void updateTimer(){

        menuTimer.updateTimer();
    }

    public void resetTimer(){

        menuTimer.resetTimer();
    }

    public float getStateTime(){
        return menuTimer.getStateTime();
    }

    public void updateStateTime(){
        menuTimer.updateStateTime();
    }





    public String[] getInfoTextImages() {
        return INFO_TEXT_PATH_IMAGES;
    }


}
