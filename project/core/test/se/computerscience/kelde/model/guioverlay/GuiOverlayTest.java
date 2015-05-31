package se.computerscience.kelde.model.guioverlay;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: Daniel Olsson
 */
public class GuiOverlayTest extends TestCase {


    GuiOverlay guiOverlay = new GuiOverlay();

    @Before
    public void setUp() {

    }

    @Test
    public void testGetBarAssets() throws Exception {

        String[] assets = guiOverlay.getBarAssets();
        assertEquals(5, assets.length);

    }
    @Test
    public void testUpdate() throws Exception {
        guiOverlay.update(100, 100);
        assertEquals(200, guiOverlay.getCurrentHealth() + guiOverlay.getCurrentMana());
    }
    @Test
    public void testGetCurrentMana() throws Exception {

        guiOverlay.update(100, 100);

        assertEquals(100, guiOverlay.getCurrentMana());
    }
    @Test
    public void testGetCurrentHealth() throws Exception {
        guiOverlay.update(100, 100);
        assertEquals(100, guiOverlay.getCurrentHealth());
    }
    @Test
    public void testGetMenuRectangleImagePath() throws Exception {
        assertEquals("gui/menu_rectangle.png", guiOverlay.getMenuRectangleImagePath());
    }
    @Test
    public void testGetTextBoxImagePath() throws Exception {
        assertEquals("gui/textbox_name.png", guiOverlay.getTextBoxImagePath());
    }
    @Test
    public void testGetGuiButtonImagePath() throws Exception {
        assertEquals("gui/gui_button.png", guiOverlay.getGuiButtonImagePath());
    }
}