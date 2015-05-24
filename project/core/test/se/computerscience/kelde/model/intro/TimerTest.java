package se.computerscience.kelde.model.intro;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */
public class TimerTest {
    Timer test;

    public TimerTest(){
        test = new Timer();



    }
    @Test
    public void testUpdateTimer() throws Exception {

        test.resetTimer();
        test.updateTimer();
        assert (0<test.getMenuTime());


    }

    @Test
    public void testUpdateStateTime() throws Exception {

        float noupdate = test.getStateTime();

        test.updateStateTime(0.5f);
        float update = test.getStateTime();

        assertTrue(noupdate!=update);
    }

    @Test
    public void testGetStateTime() throws Exception {

        assertTrue(0.f == test.getStateTime());

    }

    @Test
    public void testGetMenuTime() throws Exception {

        assertTrue(0 == test.getMenuTime());

    }

    @Test
    public void testResetTimer() throws Exception {
        test.resetTimer();
        test.updateTimer();
        test.resetTimer();

        assertTrue(0 == test.getMenuTime());
    }
}