package se.computerscience.kelde.model.intro;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author: Daniel Olsson
 */
public class ConstantsPathTest extends TestCase {

    @Test
    public void testGetIntroBorderPathImage() throws Exception {

        assertEquals("intro/borderintro.png", ConstantsPath.getIntroBorderPathImage());

    }
    @Test
    public void testGetIntroBackgroundPathImage() throws Exception {
        assertEquals("intro/backgroundintro.png", ConstantsPath.getIntroBackgroundPathImage());
    }
    @Test
    public void testGetForegroundIntroPathImage() throws Exception {
        assertEquals("intro/foregroundintro.png", ConstantsPath.getForegroundIntroPathImage());
    }
    @Test
    public void testGetIntroCaveBackground() throws Exception {
        assertEquals("intro/cavebackground.png", ConstantsPath.getIntroCaveBackground());
    }
    @Test
    public void testGetIntroSpellPathImage() throws Exception {
        assertEquals("intro/spell.png", ConstantsPath.getIntroSpellPathImage());
    }
    @Test
    public void testGetIntroDemonAnimationPathImage() throws Exception {
        assertEquals("intro/introsprites.png", ConstantsPath.getIntroDemonAnimationPathImage());
    }
    @Test
    public void testGetIntroWizardAnimationPathImage() throws Exception {
        assertEquals("intro/introtalk.png", ConstantsPath.getIntroWizardAnimationPathImage());
    }
    @Test
    public void testGetIntroMusic() throws Exception {
        assertEquals("intro/dfear.mp3", ConstantsPath.getIntroMusic());
    }


}