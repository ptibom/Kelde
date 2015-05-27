package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */

// Testing the animation loader  to see if it loads the characters correctly.
public class AnimationLoaderTest {

    private AnimationLoader animLoader;

    @Before
    public void setUp() {
        ;
        animLoader = new AnimationLoader();
    }

    @Test
    public void testLoadWalkingCharacters() throws Exception {

        final List<MenuAnimation> anims = animLoader.loadWalkingCharacters();
        assertEquals(anims.size(), 14);

    }
}