package se.computerscience.kelde.model.intro;

import org.junit.Rule;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */
public class AnimationServiceTest {
    Charset charset = Charset.forName("UTF-8");





    public ArrayList<List<String>> allData = new ArrayList<List<String>>();


    Intro introModel;

    public AnimationServiceTest(){
        try{
            //URL url = this.getClass().getResource("intro/introsprites.txt");
            //File testWsdl = new File(url.getFile());
           // / allData.add(Files.readAllLines(Paths.get(testWsdl.getAbsolutePath()), charset));
            allData.add(Files.readAllLines(Paths.get("intro/introsprites.txt"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/introtalk.txt"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/spell.txt"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationdemon.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationwizardinstr.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationwizard2instr.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationwizarddialogue.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationdemondialog.intro"), charset));
            allData.add(Files.readAllLines(Paths.get("intro/animationspellinstr.intro"), charset));




        Intro introModel = new Intro(allData);}
        catch(IOException e){
            System.out.println("A file not found");
        }
    }



    @Test
    public void testGetWizardAnimations() throws Exception {


        AnimationService animService = new AnimationService(introModel);

        HashMap<String, IntroAnimation> mappedWizardTalkAnimation = animService.getWizardAnimations();

        int wizardLength = mappedWizardTalkAnimation.size();
        assertEquals(3, wizardLength);
    }

    @Test
    public void testGetWizard2Animations() throws Exception {


        AnimationService animService = new AnimationService(introModel);

        HashMap<String, IntroAnimation> mappedWizard2TalkAnimation = animService.getWizard2Animations();

        int wizardLength2 = mappedWizard2TalkAnimation.size();

        assertEquals(7, wizardLength2);

    }

    @Test
    public void testGetDemonAnimations() throws Exception {


        AnimationService animService = new AnimationService(introModel);

        HashMap<String, IntroAnimation> mappedDemonTalkAnimation = animService.getDemonAnimations();

        int demonLength = mappedDemonTalkAnimation.size();

        assertEquals(9, demonLength);
    }

    @Test
    public void testGetSpellAnimations() throws Exception {


        AnimationService animService = new AnimationService(introModel);

        HashMap<String, IntroAnimation> mappedSpellAnimation = animService.getSpellAnimations();

        int spellLength = mappedSpellAnimation.size();

        assertEquals(3, spellLength);
    }

    @Test
    public void testGetInterpolDataX() throws Exception {



        AnimationService animService = new AnimationService(introModel);
        int[] Xpoldata = animService.getInterpolDataX();

        assertEquals(introModel.getXAnimPathArray().length*4, Xpoldata.length);

    }

    @Test
    public void testGetInterpolDataY() throws Exception {



        AnimationService animService = new AnimationService(introModel);

        int[] Ypoldata = animService.getInterpolDataY();

        assertEquals(introModel.getYAnimPathArray().length*4, Ypoldata.length);
    }
}