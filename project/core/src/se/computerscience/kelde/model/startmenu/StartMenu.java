package se.computerscience.kelde.model.startmenu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Daniel on 4/27/2015.
 */
public class StartMenu {
    private int INTRO_DEMON_SPRITE_SIZE = 128, INTRO_WIZARD_SPRITE_SIZE = 300, INTRO_SPELL_SPRITE_SIZE  = 100;
    private static final String BACKGROUND = "StartMenuBackground.png";
    private static final String FOREGROUND = "StartMenuForeground.png";
    private static final String WALKING_CHARACTER_PATH_PICTURE = "walkingcharacters.png";
    private static final String WALKING_CHARACTER_PATH_DATA = "walkingcharacters.txt";
    private static final String BACKGROUND_SOUND = "dethrone.mp3";
    private static final String NEW_GAME_BUTTON_PATH_PICTURE = "loadbutton.png";
    private static final String LOAD_GAME_BUTTON_PATH_PICTURE = "newgamebutton.png";
    private static final String DEMON_STATUES_PATH_PICTURE = "demonsbackground.png";
    private static final String[] INFO_TEXT_PATH_IMAGES = new String[8];
    private static final String INTRO_BACKGROUND_PATH_IMAGE = "intro/backgroundintro.png";
    private static final String INTRO_BORDER_PATH_IMAGE = "intro/borderintro.png";
    private static final String FOREGROUND_INTRO_PATH_IMAGE = "intro/foregroundintro.png";
    private static final String INTRO_DEMON_ANIMATION_PATH_IMAGE = "intro/introsprites.png";
    private static final String INTRO_WIZARD_ANIMATION_PATH_IMAGE = "intro/introtalk.png";
    private static final String INTRO_CAVE_BACKGROUND = "intro/cavebackground.png";
    private static final int[] INTRO_WIZARD_ANIMATION_LENGTH_DATA = new int[]{3, 3, 2};
    private static final int[] INTRO_WIZARD_TALK_COORDINATES = new int[18];
    private static final int[] INTRO_DEMON_ANIMATION_COORDINATES = new int[84];
    private static final int[] INTRO_DEMON_ANIMATION_LENGTH_DATA = new int[]{4, 3, 2, 1, 3, 2, 4, 3, 3, 3, 1, 1, 1, 3,3, 4};
    private static final String FADE_SCREEN_PATH_IMAGE = "intro/blackfadescreen.png";
    private static final String INTRO_SOUND_PATH = "intro/dfear2.mp3";
    private static final String[] INTRO_DIALOGUE_IMAGES = new String[30];
    private static final int[] INTRO_SPELL_ANIMATION_LENGTH_DATA = new int[]{3, 5, 4};
    private static final int[] INTRO_SPELL_ANIMATION_COORDINATES = new int[26];
    private static final String INTRO_SPELL_PATH_IMAGE = "intro/spell.png";
    Timer menuTimer;




    public StartMenu() throws IOException {
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

    public String getSpellSpritePath(){

      return INTRO_SPELL_PATH_IMAGE;

    }

    public int[] getSpellIntroCoordinaters(){

        return INTRO_SPELL_ANIMATION_COORDINATES;
    }
    public int[] getSpellAnimationLength(){

        return INTRO_SPELL_ANIMATION_LENGTH_DATA;
    }

    public String getDemonAnd2ndWizardImage(){

        return INTRO_DEMON_ANIMATION_PATH_IMAGE;
    }

    public String[] getDialogues(){
        return INTRO_DIALOGUE_IMAGES;
    }
public int[] getDemonAnimationData(){

    return INTRO_DEMON_ANIMATION_LENGTH_DATA;
}
public String getCaveBackground(){
    return INTRO_CAVE_BACKGROUND;
}
    public String getIntroSound(){

    return INTRO_SOUND_PATH;
    }
public String getFadeScreen(){

    return FADE_SCREEN_PATH_IMAGE;
}
public String[] getIntroTextImages(){
        return INFO_TEXT_PATH_IMAGES;
    }
   public int[] getWizardAnimationData(){
       return INTRO_WIZARD_ANIMATION_LENGTH_DATA;
   }
    public String getIntroWizardTalkImage() {
        return INTRO_WIZARD_ANIMATION_PATH_IMAGE;
    }

    public int[] getIntroDemonCoordinates() {

        return INTRO_DEMON_ANIMATION_COORDINATES;
    }

    public int[] getWizardTalkCoordinates() {

        return INTRO_WIZARD_TALK_COORDINATES;
    }

    public String[] getInfoTextImages() {
        return INFO_TEXT_PATH_IMAGES;
    }

    public String getIntroBackgroundImage() {

        return INTRO_BACKGROUND_PATH_IMAGE;

    }

    public String getIntroBorderImage() {

        return INTRO_BORDER_PATH_IMAGE;
    }

    public String getForegroundIntroImage() {
        return FOREGROUND_INTRO_PATH_IMAGE;
    }


    public String getNewGameButtonPathPicture() {

        return NEW_GAME_BUTTON_PATH_PICTURE;

    }

    public String getDemonBackgroundPathPicture() {

        return DEMON_STATUES_PATH_PICTURE;
    }

    public String getLoadGameButtonPathPicture() {
        return LOAD_GAME_BUTTON_PATH_PICTURE;
    }

    public String getWalkingCharacterPathPicture() {

        return WALKING_CHARACTER_PATH_PICTURE;

    }

    public String getWalkingCharacterPathData() {

        return WALKING_CHARACTER_PATH_DATA;

    }

    public String getBackgroundSoundPath() {
        return BACKGROUND_SOUND;
    }

    public String getBackground() {

        return BACKGROUND;
    }

    public String getForegorund() {

        return FOREGROUND;
    }

    public void updateTimer(){

        menuTimer.updateTimer();
    }

    public void resetTimer(){

        menuTimer.resetTimer();
    }



    public double getMenuTime(){

            return menuTimer.getMenuTime();
    }

    public float getDeltaTime(){

        return menuTimer.getDeltaTime();
    }

    public float getStateTime(){
        return menuTimer.getStateTime();
    }

    public void updateStateTime(){
        menuTimer.updateStateTime();
    }

    public int[] createRandomArray() {

        Random ran = new Random();
        int[] tempRandomArray = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        int index = 0;

        while (index < 14) {

            int tempRandomNr = ran.nextInt(14);

            if (!contains(tempRandomArray, tempRandomNr)) {

                tempRandomArray[index] = tempRandomNr;
                index++;

            }

        }
        return tempRandomArray;
    }


    public boolean contains(final int[] array, final int key) {
        int[] tempCopyArray = new int[14];
        System.arraycopy(array,0,tempCopyArray,0,array.length);
        Arrays.sort(tempCopyArray);
        int i = 0;
        while(i < tempCopyArray.length){
            if(tempCopyArray[i] == key){
                return true;
            }
            i++;

        }
        return false;
    }

    public void addTimerTime(double t){

        menuTimer.addTimerTIme(t);
    }

}
