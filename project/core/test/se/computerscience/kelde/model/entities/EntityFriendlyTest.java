package se.computerscience.kelde.model.entities;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


/**
 * @author: Daniel Olsson
 */
public class EntityFriendlyTest {

    EntityFriendly entityFriendly;

    @Before
    public void setUp() throws Exception {
        entityFriendly = new EntityFriendly();

    }

    @Test
    public void testIsFriendly() throws Exception {
        assertEquals(true,entityFriendly.isFriendly() );
    }
}