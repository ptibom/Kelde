package se.computerscience.kelde.model.intro;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */

public class ConstantsAnimationTest {

    // Testing if we get the right data from our model
    @Test
    public void testGetWizardLength() throws Exception {
        assertEquals(3, ConstantsAnimation.getWizardLength().length);
    }

    @Test
    public void testGetSpellLength() throws Exception {
        assertEquals(3, ConstantsAnimation.getSpellLength().length);
    }

    @Test
    public void testGetDemonLength() throws Exception {
        assertEquals(16, ConstantsAnimation.getDemonLength().length);
    }

    @Test
    public void testGetAnimXCords() throws Exception {
        assertEquals(20, ConstantsAnimation.getAnimXCords().length);
    }

    @Test
    public void testGetAnimYCords() throws Exception {
        assertEquals(20, ConstantsAnimation.getAnimYCords().length);
    }
}