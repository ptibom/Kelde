package se.computerscience.kelde.model.intro;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
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
            
            File file = new File("/core/assets/intro/introsprites.txt");
            File file2 = new File("/core/assets/intro/introtalk.txt");
            File file3 = new File("/core/assets/intro/animationdemon.intro");
            File file4 = new File("/core/assets/intro/animationwizardinstr.intro");
            File file5 = new File("/core/assets/intro/animationwizardinstr.intro");
            File file6 = new File("/core/assets/intro/animationwizard2instr.intro");
            File file7 = new File("/core/assets/intro/animationwizarddialogue.intro");
            File file8 = new File("/core/assets/intro/animationdemondialog.intro");
            File file9 = new File("/core/assets/intro/animationspellinstr.intro");

            System.out.println(file.getAbsoluteFile());
            allData.add(Files.readAllLines(Paths.get((file.getAbsolutePath())), charset));

            allData.add(Files.readAllLines(Paths.get(file2.getAbsolutePath()), charset));
            allData.add(Files.readAllLines(Paths.get(file3.getAbsolutePath()), charset));
            allData.add(Files.readAllLines(Paths.get(file4.getAbsolutePath()), charset));
            allData.add(Files.readAllLines(Paths.get(file5.getAbsolutePath()), charset));
            allData.add(Files.readAllLines(Paths.get(file6.getAbsolutePath()), charset));
            allData.add(Files.readAllLines(Paths.get(file7.getAbsolutePath()), charset));
            allData.add(Files.readAllLines(Paths.get(file8.getAbsolutePath()), charset));
            allData.add(Files.readAllLines(Paths.get(file9.getAbsolutePath()), charset));

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