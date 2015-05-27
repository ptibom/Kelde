package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */

// Checks if a menu animation can be created correctly.
public class MenuAnimationTest {

    private MenuAnimation menuAnim;

    @Before
    public void setUp() {

        final List<MenuSprite> menuSpriteList = new ArrayList<>();
        menuSpriteList.add(new MenuSprite(1, 2, 3, 4));
        menuSpriteList.add(new MenuSprite(2, 3, 4, 5));
        menuAnim = new MenuAnimation(menuSpriteList);
    }

    @Test
    public void testGetMenuSpriteFrames() throws Exception {

        assertEquals(menuAnim.getMenuSpriteFrames().size(), 2);
    }
}