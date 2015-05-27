package se.computerscience.kelde.model.intro;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */
public class IntroSpriteFrameTest {

    // Testing if a sprite can be created correctly
    IntroSpriteFrame test;

    public IntroSpriteFrameTest() {
        test = new IntroSpriteFrame(10, 120, 40, 30);
    }

    @Test
    public void testSpriteStartXPosition() throws Exception {

        assertEquals(10, test.getSpriteStartXPosition());
    }

    @Test
    public void testGetSpriteStartYPosition() throws Exception {
        assertEquals(120, test.getSpriteStartYPosition());
    }

    @Test
    public void testGetSpriteWidth() throws Exception {
        assertEquals(40, test.getSpriteWidth());
    }

    @Test
    public void testGetSpriteHeight() throws Exception {
        assertEquals(30, test.getSpriteHeight());
    }
}