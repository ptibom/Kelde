package se.computerscience.kelde.model.startmenu;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: Daniel Olsson
 */
public class StartMenu {

    private static final String BACKGROUND = "StartMenuBackground.png";
    private static final String FOREGROUND = "StartMenuForeground.png";
    private static final String WALKING_CHARACTER_PATH_PICTURE = "walkingcharacters.png";
    private static final String WALKING_CHARACTER_PATH_DATA = "walkingcharacters.txt";
    private static final String BACKGROUND_SOUND = "dethrone.mp3";
    private static final String NEW_GAME_BUTTON_PATH_PICTURE = "loadbutton.png";
    private static final String LOAD_GAME_BUTTON_PATH_PICTURE = "newgamebutton.png";
    private static final String DEMON_STATUES_PATH_PICTURE = "demonsbackground.png";







    private static final String FADE_SCREEN_PATH_IMAGE = "intro/blackfadescreen.png";

    private static Timer menuTimer;





    public StartMenu() throws IOException {

        menuTimer = new Timer();


        }






public String getFadeScreen(){

    return FADE_SCREEN_PATH_IMAGE;
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



    public void addTimerTime(double t){

        menuTimer.addTimerTIme(t);
    }

}
