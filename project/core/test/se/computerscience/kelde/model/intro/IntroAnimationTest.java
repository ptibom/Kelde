package se.computerscience.kelde.model.intro;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */
// Testing if IntroAnimation can be created correctly.
public class IntroAnimationTest {
    private IntroAnimation introAnim;

    @Before
    public void setUp() {

        List<IntroSpriteFrame> allFrames;
        allFrames = new ArrayList<>();
        final IntroSpriteFrame aFrame = new IntroSpriteFrame(1, 2, 1, 3);
        final IntroSpriteFrame aFrame2 = new IntroSpriteFrame(1, 2, 1, 3);
        final IntroSpriteFrame aFrame3 = new IntroSpriteFrame(1, 2, 1, 3);
        allFrames.add(aFrame);
        allFrames.add(aFrame2);
        allFrames.add(aFrame3);
        introAnim = new IntroAnimation(allFrames);
    }

    @Test
    public void testGetIntroSpriteFrames() {

        assertEquals(3, introAnim.getIntroSpriteFrames().size());

    }
}