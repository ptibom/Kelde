package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */
// Cheecks the startmenu model clas if it's working correctly
public class StartMenuTest {

    private StartMenu startMenu;

    @Before
    public void setUp() {
        startMenu = new StartMenu();
    }

    @Test
    public void testGetWalkingCharacterPathPicture() throws Exception {

        assertSame(startMenu.getWalkingCharacterPathPicture(), "menu/walkingcharacters.png");
    }

    @Test
    public void testGetBackgroundSoundPath() throws Exception {
        assertSame(startMenu.getBackgroundSoundPath(), "menu/dethrone.mp3");
    }

    @Test
    public void testGetBackground() throws Exception {
        assertSame(startMenu.getBackground(), "menu/background.png");
    }

    @Test
    public void testGetForeground() throws Exception {
        assertSame(startMenu.getForeground(), "menu/foreground.png");
    }

    @Test
    public void testGetMidGround() throws Exception {
        assertSame(startMenu.getMidGround(), "menu/backgroundmid.png");
    }

    @Test
    public void testGetStateTime() throws Exception {
        assertEquals(0, (int) startMenu.getStateTime());
    }

    @Test
    public void testUpdateStateTime() throws Exception {
        startMenu.updateStateTime(5f);
        assertEquals((int) startMenu.getStateTime(), 5);
    }
}