package se.computerscience.kelde.model.intro;

import junit.framework.TestCase;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */
public class AnimationBuilderTest extends TestCase {



    @Before
    public void setUp(){

    }


    public void testCreateListofAnimations() throws Exception {

        List<IntroAnimation> introAnimTest = AnimationBuilder.createListofAnimations( new int[]{2,2}, new int[]{120,120,12,13,12,13,12,13,12,13});
        assertEquals(2,introAnimTest.size());

    }

    public void testCreateIntroAnimation() throws Exception {

        List<IntroSpriteFrame> frames = new ArrayList<>();
        frames.add(new IntroSpriteFrame(1,2,3,4));
        frames.add(new IntroSpriteFrame(1,4,3,4));
        frames.add(new IntroSpriteFrame(1,2,5,4));
        IntroAnimation introAnims = new IntroAnimation(frames);

        assertEquals(3, introAnims.getIntroSpriteFrames().size());
    }

    public void testCreateNewIntroSpriteList() throws Exception {

        assertEquals(0, AnimationBuilder.createNewIntroSpriteList().size());
    }

    public void testCreateNewInstance() throws Exception {

        IntroSpriteFrame frame =  AnimationBuilder.createNewInstance(0, new int[]{128,128,1,2});
        assertEquals(1, frame.getSpriteStartXPosition());
    }
}