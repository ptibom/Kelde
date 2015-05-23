package se.computerscience.kelde.model.startmenu;

import java.io.IOException;

/**
 * @author: Daniel Olsson
 */

public class StartMenu {

    private static final String BACKGROUND = "menu/background.png";
    private static final String MIDDLEGROUND = "menu/backgroundmid.png";
    private static final String FOREGROUND = "menu/foreground.png";
    private static final String WALKING_CHARACTER_PATH_PICTURE = "menu/walkingcharacters.png";
    private static final String BACKGROUND_SOUND = "menu/dethrone.mp3";

    Timer menuTimer = new Timer();


    public StartMenu() throws IOException {

    }

    public String getWalkingCharacterPathPicture() {

        return WALKING_CHARACTER_PATH_PICTURE;

    }


    public String getBackgroundSoundPath() {
        return BACKGROUND_SOUND;
    }

    public String getBackground() {

        return BACKGROUND;
    }

    public String getForeground() {

        return FOREGROUND;
    }

    public String getMidGround(){
        return MIDDLEGROUND;
    }

    public float getStateTime() {
        return menuTimer.getStateTime();
    }

    public void updateStateTime(float delta) {
        menuTimer.updateStateTime(delta);
    }


}
