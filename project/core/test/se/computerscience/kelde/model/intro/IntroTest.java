package se.computerscience.kelde.model.intro;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


/**
 * @author: Daniel Olsson
 */

// Testing all input to intro, and if its working correctly.
public class IntroTest {

    private Intro introModel;

    public IntroTest() {
        final Charset charset = Charset.forName("UTF-8");
        final ArrayList<List<String>> allData = new ArrayList<List<String>>();
        try {
            String basepath = System.getProperty("user.dir");
            allData.add(Files.readAllLines(Paths.get(basepath +"/assets/intro/introsprites.txt"), charset));
            allData.add(Files.readAllLines(Paths.get(basepath +"/assets/intro/introtalk.txt"), charset));
            allData.add(Files.readAllLines(Paths.get(basepath +"/assets/intro/spell.txt"), charset));
            allData.add(Files.readAllLines(Paths.get(basepath +"/assets/intro/animationdemon.intro"), charset));
            allData.add(Files.readAllLines(Paths.get(basepath +"/assets/intro/animationwizardinstr.intro"), charset));
            allData.add(Files.readAllLines(Paths.get(basepath +"/assets/intro/animationwizard2instr.intro"), charset));
            allData.add(Files.readAllLines(Paths.get(basepath +"/assets/intro/animationwizarddialogue.intro"), charset));
            allData.add(Files.readAllLines(Paths.get(basepath +"/assets/intro/animationdemondialog.intro"), charset));
            allData.add(Files.readAllLines(Paths.get(basepath +"/assets/intro/animationspellinstr.intro"), charset));

            introModel = new Intro(allData);
        } catch (IOException e) {
            final Logger logg = Logger.getLogger("test");
            logg.isLoggable(Level.FINE);
        }


    }

    @Test
    public void testGetInstructions() throws Exception {

        assertEquals(6, introModel.getInstructions().size());

    }

    @Test
    public void testGetWizardAnimationData() throws Exception {

        assertEquals(3, ConstantsAnimation.getWizardLength().length);

    }


    @Test
    public void testGetSpellIntroCoordinaters() throws Exception {

        assertEquals(87, introModel.getSpellIntroCoordinaters().length);
    }


    @Test
    public void testGetDialogues() throws Exception {
        assertEquals(30, introModel.getDialogues().length);
    }

    @Test
    public void testGetIntroTextImages() throws Exception {
        assertEquals(8, introModel.getIntroTextImages().length);
    }

    @Test
    public void testGetIntroDemonCoordinates() throws Exception {
        assertEquals(290, introModel.getIntroDemonCoordinates().length);
    }


    @Test
    public void testGetMenuTime() throws Exception {
        assertEquals(0, (int) introModel.getMenuTime());
    }

    @Test
    public void testUpdateTimer() throws Exception {
        introModel.updateStateTime(0.5f);
        assertEquals(0, (int) introModel.getStateTime());
    }

    @Test
    public void testResetTimer() throws Exception {
        introModel.updateTimer();
        introModel.resetTimer();
        assertNotEquals(0f, introModel.getMenuTime(), 0f);

    }


    @Test
    public void testGetStateTime() throws Exception {
        assertEquals(0, (int) introModel.getStateTime());
    }

    @Test
    public void testUpdateStateTime() throws Exception {
        introModel.updateStateTime(1f);
        assertEquals(0.5f, (int) introModel.getStateTime(), 0.5f);
    }

    @Test
    public void testGetAnimationSpeed() throws Exception {
        assertEquals(0.27f, (int) introModel.getAnimationSpeed(), 0.27f);

    }
}