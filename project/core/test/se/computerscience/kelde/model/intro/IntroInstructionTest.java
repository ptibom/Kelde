package se.computerscience.kelde.model.intro;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */
public class IntroInstructionTest {

    IntroInstruction test;
    IntroInstruction test2;
    IntroInstruction test3;
    public IntroInstructionTest(){
        test = new IntroInstruction(5,4,3f,2,6,7,8, "goforward");
        test2 = new IntroInstruction(15,4,4);
        test3 = new IntroInstruction(12,4,4, "goforth");

    }
    @Test
    public void testGetKeyFrame() throws Exception {

        assert(3f == test.getKeyFrame());

    }

    @Test
    public void testGetStartTime() throws Exception {

        assert(5 == test.getStartTime());
    }

    @Test
    public void testGetEndTime() throws Exception {
        assert(4 == test.getEndTime());
    }

    @Test
    public void testGetXVelocity() throws Exception {
        assert(7 == test.getXVelocity());
    }

    @Test
    public void testGetYVelocity() throws Exception {
        assert(8 == test.getYVelocity());
    }

    @Test
    public void testGetWidthChange() throws Exception {
        assert(2 == test.getWidthChange());
    }

    @Test
    public void testGetHeightChange() throws Exception {
        assert(2 == test.getWidthChange());
    }

    @Test
    public void testIsFlipped() throws Exception {
        assert(!test.isFlipped());
    }

    @Test
    public void testGetAnimationName() throws Exception {

        assert("goforward".equals(test.getAnimationName()));

    }

    @Test
    public void testGetDialogNumber() throws Exception {

        assertEquals(15, test2.getDialogNumber());
    }

    @Test
    public void testGetStartCount() throws Exception {
        assert(12 == test3.getStartCount());

    }
}