package se.computerscience.kelde.model.startmenu;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: Daniel Olsson
 */

public class TimerTest {

    private Timer t;
    @Before
    public void setUp() throws Exception {
    t = new Timer();
    }

    @Test
    public void testUpdateStateTime() throws Exception {
    t.updateStateTime(5f);
       assertEquals((int) t.getStateTime(),5);
    }

    @Test
    public void testGetStateTime() throws Exception {
        assertEquals((int)t.getStateTime(),0);
    }
}