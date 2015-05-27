package se.computerscience.kelde.model.intro;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */
public class AnimationServiceTest {

    private final Charset charset = Charset.forName("UTF-8");
    private final List<List<String>> allData = new ArrayList<List<String>>();
    private Intro introModel;

    @Before
    public void initTest() {
        try {

            allData.add(Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/introsprites.txt"), charset));
            allData.add(Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/introtalk.txt"), charset));
            allData.add(Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/spell.txt"), charset));
            allData.add(Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/animationdemon.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/animationwizardinstr.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/animationwizard2instr.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/animationwizarddialogue.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/animationdemondialog.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("C:/FixingTheBranch/sixthTry/EIGTHTRY/Kelde/project/core/assets/intro/animationspellinstr.intro"), charset));

            introModel = new Intro(allData);
        } catch (IOException e) {
            final Logger alog = Logger.getLogger("test");
            alog.isLoggable(Level.FINE);
        }
    }

    @Test
    public void testGetWizardAnimations() throws Exception {

        final AnimationService animService = new AnimationService(introModel);
        final Map<String, IntroAnimation> mappedWizardTalkAnimation = animService.getWizardAnimations();
        final int wizardLength = mappedWizardTalkAnimation.size();
        assertEquals(3, wizardLength);
    }

    @Test
    public void testGetWizard2Animations() throws Exception {

        final AnimationService animService = new AnimationService(introModel);
        final Map<String, IntroAnimation> mappedWizard2TalkAnimation = animService.getWizard2Animations();
        final int wizardLength2 = mappedWizard2TalkAnimation.size();
        assertEquals(7, wizardLength2);

    }

    @Test
    public void testGetDemonAnimations() throws Exception {

        final AnimationService animService = new AnimationService(introModel);
        final Map<String, IntroAnimation> mappedDemonTalkAnimation = animService.getDemonAnimations();
        final int demonLength = mappedDemonTalkAnimation.size();

        assertEquals(9, demonLength);
    }

    @Test
    public void testGetSpellAnimations() throws Exception {

        final AnimationService animService = new AnimationService(introModel);
        final Map<String, IntroAnimation> mappedSpellAnimation = animService.getSpellAnimations();
        final int spellLength = mappedSpellAnimation.size();

        assertEquals(3, spellLength);
    }

    @Test
    public void testGetInterpolDataX() throws Exception {

        final AnimationService animService = new AnimationService(introModel);
        final int[] Xpoldata = animService.getInterpolDataX();
        assertEquals(ConstantsAnimation.getAnimXCords().length * 4, Xpoldata.length);

    }

    @Test
    public void testGetInterpolDataY() throws Exception {

        final AnimationService animService = new AnimationService(introModel);
        final int[] Ypoldata = animService.getInterpolDataY();
        assertEquals(ConstantsAnimation.getAnimYCords().length * 4, Ypoldata.length);
    }
}