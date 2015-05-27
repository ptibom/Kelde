package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */
// Checks if a menu sprite can be created correctly
public class MenuSpriteTest {

    private MenuSprite test;

    @Before
    public void setUp() throws Exception {
        test = new MenuSprite(1, 2, 3, 4);
    }

    @Test
    public void testGetSpriteStartXPosition() throws Exception {
        assertEquals(1, test.getSpriteStartXPosition());
    }

    @Test
    public void testGetSpriteStartYPosition() throws Exception {
        assertEquals(2, test.getSpriteStartYPosition());
    }

    @Test
    public void testGetSpriteWidth() throws Exception {
        assertEquals(3, test.getSpriteWidth());
    }

    @Test
    public void testGetSpriteHeight() throws Exception {
        assertEquals(4, test.getSpriteHeight());
    }
}