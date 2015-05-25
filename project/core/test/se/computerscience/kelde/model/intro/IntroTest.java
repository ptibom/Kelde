package se.computerscience.kelde.model.intro;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */
public class IntroTest {

   Intro introModel;


    public IntroTest(){
        Charset charset = Charset.forName("UTF-8");
        ArrayList<List<String>> allData = new ArrayList<List<String>>();
        try {
            allData.add(Files.readAllLines(Paths.get("intro/introsprites.txt"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/introtalk.txt"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/spell.txt"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationdemon.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationwizardinstr.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationwizard2instr.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationwizarddialogue.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationdemondialog.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationspellinstr.intro"), charset));
            this.introModel = new Intro(allData);
        }
        catch (IOException e){
            System.out.println("file not found");
        }


    }

    @Test
    public void testGetInstructions() throws Exception {

            assertEquals(6, introModel.getInstructions());

    }

    @Test
    public void testGetWizardAnimationData() throws Exception {

        assertEquals(3, ConstantsAnimation.getWizardLength().length);

    }

    @Test
    public void testGetWizardTalkCoordinates() throws Exception {

        assertEquals(18, introModel.getWizardAnimationData().length);
    }

    @Test
    public void testGetSpellIntroCoordinaters() throws Exception {

        assertEquals(26, introModel.getSpellIntroCoordinaters().length);
    }

    @Test
    public void testGetSpellAnimationLength() throws Exception {
        assertEquals(3, introModel.getSpellAnimationLength().length);
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
        assertEquals(84, introModel.getIntroDemonCoordinates().length);
    }
    public static final String INTRO_BORDER_PATH_IMAGE = "intro/borderintro.png";
    public static final String INTRO_BACKGROUND_PATH_IMAGE = "intro/backgroundintro.png";
    public static final String FOREGROUND_INTRO_PATH_IMAGE = "intro/foregroundintro.png";
    public static final String INTRO_CAVE_BACKGROUND = "intro/cavebackground.png";
    public static final String INTRO_SPELL_PATH_IMAGE = "intro/spell.png";
    public static final String INTRO_DEMON_ANIMATION_PATH_IMAGE = "intro/introsprites.png";
    public static final String INTRO_WIZARD_ANIMATION_PATH_IMAGE = "intro/introtalk.png";
    @Test
    public void testGetSpellSpritePath() throws Exception {
        assertTrue("intro/spell.png".equals(introModel.getSpellSpritePath()));
    }

    @Test
    public void testGetDemonAnd2ndWizardImage() throws Exception {
        assertTrue("intro/introsprites.png".equals( introModel.getDemonAnd2ndWizardImage()));
    }

    @Test
    public void testGetDemonAnimationData() throws Exception {
        assertEquals(16,introModel.getDemonAnimationData().length);
    }

    @Test
    public void testGetIntroWizardTalkImage() throws Exception {
        assertTrue("intro/spell.png".equals(introModel.getSpellSpritePath()));
    }

    @Test
    public void testGetIntroBorderImage() throws Exception {
        assertTrue("intro/borderintro.png".equals(introModel.getIntroBorderImage()));
    }

    @Test
    public void testGetIntroBackgroundImage() throws Exception {
        assertTrue("intro/backgroundintro.png".equals(introModel.getIntroBackgroundImage()));
    }

    @Test
    public void testGetIntroSound() throws Exception {
        assertTrue("dfear.mp3".equals(introModel.getIntroSound()));
    }

    @Test
    public void testGetForegroundIntroImage() throws Exception {
        assertTrue("intro/foregroundintro.png".equals(introModel.getForegroundIntroImage()));
    }

    @Test
    public void testGetCaveBackground() throws Exception {
        assertTrue("intro/cavebackground.png".equals(introModel.getCaveBackground()));
    }

    @Test
    public void testGetMenuTime() throws Exception {
        assertTrue(0 == introModel.getMenuTime());
    }

    @Test
    public void testUpdateTimer() throws Exception {
        introModel.updateStateTime(0.5f);
        assertTrue(0 != introModel.getStateTime());
    }

    @Test
    public void testResetTimer() throws Exception {
        introModel.updateTimer();
        introModel.resetTimer();
        assertTrue(0 != introModel.getMenuTime());

    }

    @Test
    public void testGetXAnimPathArray() throws Exception {
        assertEquals(20, introModel.getXAnimPathArray().length);
    }

    @Test
    public void testGetYAnimPathArray() throws Exception {
        assertEquals(20,introModel.getXAnimPathArray().length);

    }

    @Test
    public void testGetStateTime() throws Exception {
        assert(0f == introModel.getStateTime());
    }

    @Test
    public void testUpdateStateTime() throws Exception {
        introModel.updateStateTime(0.5f);
        assert(0.5f == introModel.getStateTime());
    }

    @Test
    public void testGetAnimationSpeed() throws Exception {
        assert(0.27f ==introModel.getAnimationSpeed());

    }
}