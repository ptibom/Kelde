package se.computerscience.kelde.model.guioverlay;

import junit.framework.TestCase;
import org.junit.Before;

/**
 * @author: Daniel Olsson
 */
public class GuiOverlayTest extends TestCase {


    GuiOverlay guiOverlay= new GuiOverlay();

    @Before
    public void setUp(){

    }

    public void testGetBarAssets() throws Exception {

        String[] assets = guiOverlay.getBarAssets();
        assertEquals(5, assets.length);

    }

    public void testUpdate() throws Exception {
        guiOverlay.update(100,100);
        assertEquals(200, guiOverlay.getCurrentHealth() + guiOverlay.getCurrentMana());
    }

    public void testGetCurrentMana() throws Exception {

        guiOverlay.update(100,100);

        assertEquals(100,guiOverlay.getCurrentMana());
    }

    public void testGetCurrentHealth() throws Exception {
        guiOverlay.update(100,100);
        assertEquals(100, guiOverlay.getCurrentHealth());
    }

    public void testGetMenuRectangleImagePath() throws Exception {
        assertEquals("gui/menu_rectangle.png", guiOverlay.getMenuRectangleImagePath());
    }

    public void testGetTextBoxImagePath() throws Exception {
        assertEquals("gui/textbox_name.png", guiOverlay.getTextBoxImagePath());
    }

    public void testGetGuiButtonImagePath() throws Exception {
        assertEquals("gui/gui_button.png", guiOverlay.getGuiButtonImagePath());
    }
}