package se.computerscience.kelde.model.intro;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author: Daniel Olsson
 */

// Testing if an Instruction can be created correctly
public class IntroInstructionTest {

    private final IntroInstruction test;
    private final IntroInstruction test2;
    private final IntroInstruction test3;
    private final IntroInstructData testData;

    public IntroInstructionTest() {
        test = new IntroInstruction(5, 4, 3f, 2, 6, 7, 8, "goforward");
        test2 = new IntroInstruction(15, 4, 4);
        test3 = new IntroInstruction(12, 4, 4, "goforth");
        testData = new IntroInstructData(1, 2, 3, 4);

    }

    @Test
    public void testGetKeyFrame() throws Exception {

        assertEquals((int) 3f, (int) test.getKeyFrame());

    }

    @Test
    public void testGetStartTime() throws Exception {

        assertEquals((int) 5, (int) test.getStartTime());
    }

    @Test
    public void testGetEndTime() throws Exception {
        assertEquals(4, (int) test.getEndTime());
    }

    @Test
    public void testGetInstructData() throws Exception {
        assertEquals(1, testData.getXvel());

    }


    @Test
    public void testIsFlipped() throws Exception {
        assertTrue(!test.isFlipped());
    }

    @Test
    public void testGetAnimationName() throws Exception {

        assertEquals("goforward", test.getAnimationName());

    }

    @Test
    public void testGetDialogNumber() throws Exception {

        assertEquals(15, test2.getDialogNumber());
    }

    @Test
    public void testGetStartCount() throws Exception {
        assertEquals(12, (int) test3.getStartCount());

    }
}