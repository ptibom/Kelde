package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */

public class TimerTest {

    Timer t;
    @Before
    public void setUp() throws Exception {
    t = new Timer();
    }

    @Test
    public void testUpdateStateTime() throws Exception {
    t.updateStateTime(5f);
       assertTrue(t.getStateTime() == 5f);
    }

    @Test
    public void testGetStateTime() throws Exception {
        assertTrue(t.getStateTime() == 0f);
    }
}