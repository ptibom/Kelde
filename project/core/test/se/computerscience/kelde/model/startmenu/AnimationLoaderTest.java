package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.intro.AnimationService;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */

public class AnimationLoaderTest {

    StartMenu menu;
    AnimationLoader animLoader;

    @Before
    public void setUp(){
        menu = new StartMenu();
        animLoader = new AnimationLoader();
    }

    @Test
    public void testLoadWalkingCharacters() throws Exception {

       List<MenuAnimation> anims = animLoader.loadWalkingCharacters(menu);
        assertTrue(anims.size()==15);

    }
}