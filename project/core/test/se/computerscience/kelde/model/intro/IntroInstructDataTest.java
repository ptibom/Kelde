package se.computerscience.kelde.model.intro;

import junit.framework.TestCase;
import org.junit.Before;

/**
 * @author: Daniel Olsson
 */
public class IntroInstructDataTest extends TestCase {

    IntroInstructData test;
    @Before
    public void setUp(){
        test  = new IntroInstructData(1,2,3,4);
    }

    public void testGetXvel() throws Exception {
        assertEquals(1, test.getXvel());

    }

    public void testGetYvel() throws Exception {
        assertEquals(2,test.getYvel());
    }

    public void testGetHeightChange() throws Exception {
        assertEquals(3,test.getHeightChange());
    }

    public void testGetWidthChange() throws Exception {
        assertEquals(4,test.getWidthChange());
    }
}