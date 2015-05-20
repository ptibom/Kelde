package se.computerscience.kelde.model.startmenu;

import se.computerscience.kelde.model.startmenu.Timer;

import java.io.IOException;

/**
 * @author: Daniel Olsson
 */

public class StartMenu {

    private static final String BACKGROUND = "StartMenuBackground.png";
    private static final String FOREGROUND = "StartMenuForeground.png";
    private static final String WALKING_CHARACTER_PATH_PICTURE = "walkingcharacters.png";
    private static final String BACKGROUND_SOUND = "dethrone.mp3";

    Timer menuTimer = new Timer();


    private static final String FADE_SCREEN_PATH_IMAGE = "intro/blackfadescreen.png";


    public StartMenu() throws IOException {

    }

    public String getFadeScreen() {

        return FADE_SCREEN_PATH_IMAGE;
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

    public String getForegorund() {

        return FOREGROUND;
    }

    public float getStateTime() {
        return menuTimer.getStateTime();
    }

    public void updateStateTime(float delta) {
        menuTimer.updateStateTime(delta);
    }


}
