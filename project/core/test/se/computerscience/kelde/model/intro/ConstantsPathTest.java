package se.computerscience.kelde.model.intro;

import junit.framework.TestCase;
import org.junit.Before;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author: Daniel Olsson
 */
public class ConstantsPathTest extends TestCase {



    public void testGetIntroBorderPathImage() throws Exception {

        assertEquals("intro/borderintro.png", ConstantsPath.getIntroBorderPathImage());

    }

    public void testGetIntroBackgroundPathImage() throws Exception {
        assertEquals( "intro/backgroundintro.png", ConstantsPath.getIntroBackgroundPathImage());
    }

    public void testGetForegroundIntroPathImage() throws Exception {
        assertEquals("intro/foregroundintro.png", ConstantsPath.getForegroundIntroPathImage());
    }

    public void testGetIntroCaveBackground() throws Exception {
        assertEquals("intro/cavebackground.png", ConstantsPath.getIntroCaveBackground());
    }

    public void testGetIntroSpellPathImage() throws Exception {
        assertEquals("intro/spell.png", ConstantsPath.getIntroSpellPathImage());
    }

    public void testGetIntroDemonAnimationPathImage() throws Exception {
        assertEquals("intro/introsprites.png", ConstantsPath.getIntroDemonAnimationPathImage());
    }

    public void testGetIntroWizardAnimationPathImage() throws Exception {
        assertEquals("intro/introtalk.png",ConstantsPath.getIntroWizardAnimationPathImage());
    }

    public void testGetIntroMusic() throws Exception {
        assertEquals("intro/dfear.mp3", ConstantsPath.getIntroMusic());
    }


}