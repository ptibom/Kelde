package se.computerscience.kelde.model.intro;

import org.junit.Test;


/**
 * @author: Daniel Olsson
 */
public class IntroSpriteFrameTest {

    IntroSpriteFrame test;

    public IntroSpriteFrameTest(){
        test = new IntroSpriteFrame(10,120,40,30);
    }

    @Test
    public void testSpriteStartXPosition() throws Exception {

        assert(10 == test.getSpriteStartXPosition());
    }

    @Test
    public void testGetSpriteStartYPosition() throws Exception {
    assert(120 == test.getSpriteStartYPosition());
    }

    @Test
    public void testGetSpriteWidth() throws Exception {
    assert(40 == test.getSpriteWidth());
    }

    @Test
    public void testGetSpriteHeight() throws Exception {
    assert(30 == test.getSpriteHeight());
    }
}