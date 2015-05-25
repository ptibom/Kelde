package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */

public class StartMenuTest {

    StartMenu startMenu;
    @Before
    public void setup(){
        try {
            startMenu = new StartMenu();
        }
        catch(IOException e){
            System.out.println("no file");
        }
    }

    @Test
    public void testGetWalkingCharacterPathPicture() throws Exception {

        assertTrue(startMenu.getWalkingCharacterPathPicture() == "menu/walkingcharacters.png");


    }

    @Test
    public void testGetBackgroundSoundPath() throws Exception {

        assertTrue(startMenu.getBackgroundSoundPath() == "menu/dethrone.mp3");
    }

    @Test
    public void testGetBackground() throws Exception {
        assertTrue(startMenu.getBackground()=="menu/background.png");
    }

    @Test
    public void testGetForeground() throws Exception {
        assertTrue(startMenu.getForeground()=="menu/foreground.png");
    }

    @Test
    public void testGetMidGround() throws Exception {
        assertTrue(startMenu.getMidGround() == "menu/backgroundmid.png");
    }

    @Test
    public void testGetStateTime() throws Exception {
        assertTrue(0f == startMenu.getStateTime());

    }

    @Test
    public void testUpdateStateTime() throws Exception {
        startMenu.updateStateTime(5f);
        assertTrue(startMenu.getStateTime()==5f);
    }
}