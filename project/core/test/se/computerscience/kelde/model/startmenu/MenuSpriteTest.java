package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */

public class MenuSpriteTest {

    MenuSprite test;

    @Before
    public void setUp() throws Exception {
        test = new MenuSprite(1,2,3,4);
    }

    @Test
    public void testGetSpriteStartXPosition() throws Exception {
        assertTrue(1 == test.getSpriteStartXPosition());
    }

    @Test
    public void testGetSpriteStartYPosition() throws Exception {
        assertTrue(2 == test.getSpriteStartYPosition());
    }

    @Test
    public void testGetSpriteWidth() throws Exception {
        assertTrue(3 == test.getSpriteWidth());
    }

    @Test
    public void testGetSpriteHeight() throws Exception {
        assertTrue(4 == test.getSpriteHeight());
    }
}