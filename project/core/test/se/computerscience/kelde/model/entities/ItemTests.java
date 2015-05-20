/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.entities;

import org.junit.Assert;
import org.junit.Test;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.model.items.Sword;

public class ItemTests {
    @Test
    public void testItemAxeWeapon(){
        Axe axe = new Axe();
        Assert.assertEquals(true, axe.isWeapon());
    }
    @Test
    public void testItemSwordWeapon(){
        Sword sword = new Sword();
        Assert.assertEquals(true, sword.isWeapon());
    }
}