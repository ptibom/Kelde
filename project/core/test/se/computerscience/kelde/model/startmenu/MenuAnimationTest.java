package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */

public class MenuAnimationTest {


    MenuAnimation menuAnim;
    @Before
    public void setup(){



            List<MenuSprite> menuSpriteList = new ArrayList<>();
            menuSpriteList.add(new MenuSprite(1,2,3,4));
            menuSpriteList.add(new MenuSprite (2,3,4,5));
             menuAnim = new MenuAnimation(menuSpriteList);






    }

    @Test
    public void testGetMenuSpriteFrames() throws Exception {

        assertTrue(menuAnim.getMenuSpriteFrames().size() == 2);
    }
}