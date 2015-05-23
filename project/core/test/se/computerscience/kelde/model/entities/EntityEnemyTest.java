package se.computerscience.kelde.model.entities;


import org.junit.Test;

import static org.junit.Assert.assertFalse;

/**
 * @author: Philip Tibom
 */
public class EntityEnemyTest {

    @Test
    public void testIsFriendly() throws Exception {
        final EntityEnemy entityEnemy = new EntityEnemy();
        assertFalse(entityEnemy.isFriendly());
    }
}