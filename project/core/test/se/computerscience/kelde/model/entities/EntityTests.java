/**
 * Description: Testing methods in Entities
 *
 * @author: Philip Tibom
 */

package se.computerscience.kelde.model.entities;

import org.junit.Assert;
import org.junit.Test;

public class EntityTests {
    @Test
    public void testEntityShopFriendly() {
        INPCEntity entityShop = new EntityShop();
        Assert.assertEquals(true, entityShop.isFriendly());
    }

    @Test
    public void testEntityKnightHostile() {
        INPCEntity entityKnight = new EntityKnight();
        Assert.assertEquals(false, entityKnight.isFriendly());
    }
}
