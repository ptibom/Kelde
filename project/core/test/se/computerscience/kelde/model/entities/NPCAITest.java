package se.computerscience.kelde.model.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */
public class NPCAITest {



    @Test
    public void testGetVelocity() throws Exception {

        assertEquals(0, (int) NPCAI.getVelocity(0.5f) );
    }

    @Test
    public void testDeltaX() throws Exception {
        assertEquals(32, (int)NPCAI.deltaX(5f,5f));
    }

    @Test
    public void testDeltaY() throws Exception {
        assertEquals(8, (int)NPCAI.deltaY(3f, 3f));
    }

    @Test
    public void testDistance() throws Exception {

        assertEquals(27, (int)NPCAI.distance(5,5,10,10));
    }
}