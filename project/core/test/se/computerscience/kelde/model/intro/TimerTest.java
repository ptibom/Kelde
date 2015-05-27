package se.computerscience.kelde.model.intro;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

/**
 * @author: Daniel Olsson
 */

//Testing and validating the timer class and if it's working correctly.
public class TimerTest {
    private final Timer test;

    public TimerTest() {
        test = new Timer();
    }

    @Test
    public void testUpdateTimer() throws Exception {

        test.resetTimer();
        test.updateTimer();
        final double test2 = test.getMenuTime();
        assertEquals(0, (int) test2);
    }

    @Test
    public void testUpdateStateTime() throws Exception {

        final float noupdate = test.getStateTime();
        test.updateStateTime(0.5f);
        final float update = test.getStateTime();
        assertNotSame(noupdate, update);
    }

    @Test
    public void testGetStateTime() throws Exception {
        assertEquals(0, (int) test.getStateTime());
    }

    @Test
    public void testGetMenuTime() throws Exception {
        assertEquals(0, (int) test.getMenuTime());
    }

    @Test
    public void testResetTimer() throws Exception {
        test.resetTimer();
        test.updateTimer();
        test.resetTimer();
        assertEquals(0, (int) test.getMenuTime());
    }
}