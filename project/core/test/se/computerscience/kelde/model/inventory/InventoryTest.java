package se.computerscience.kelde.model.inventory;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.libgdx.ISprite;
import se.computerscience.kelde.model.items.IItem;


/**
 * @author: Daniel Olsson
 */
public class InventoryTest extends TestCase {

    IItem testItem;
    Inventory inventory;

    @Before
    public void setUp() {

        testItem = new TestItem();
        inventory = new Inventory();

    }
    @Test
    public void testUpdate() throws Exception {


        inventory.update(testItem);

        assertEquals(1, inventory.getInventoryItems().size());

    }
    @Test
    public void testGetInventoryItems() throws Exception {

        assertEquals(0, inventory.getInventoryItems().size());

    }
    @Test
    public void testGetInventoryGuiImage() throws Exception {

        assertEquals(inventory.getInventoryGuiImage(), "inventory/inventorygui.png");
    }
    @Test
    public void testGetItemPositions() throws Exception {
        inventory.update(testItem);
        int[] testValue = inventory.getItemPositions().get(0);
        assertEquals(testValue[0] + testValue[1], 1070);

    }
    @Test
    public void testGetInventoryPositionX() throws Exception {
        inventory.update(testItem);
        assertEquals(inventory.getInventoryPositionX(), 690);

    }
    @Test
    public void testGetInventoryPositionY() throws Exception {
        inventory.update(testItem);
        assertEquals(inventory.getInventoryPositionY(), 170);
    }

    class TestItem implements IItem {


        @Override
        public boolean isConsumable() {
            return false;
        }

        @Override
        public boolean isWeapon() {
            return false;
        }

        @Override
        public ISprite getItemSprite() {
            return null;
        }

        @Override
        public void setItemPositionY(float y) {

        }

        @Override
        public void setItemPositionX(float x) {

        }

        @Override
        public float getItemPositionY() {
            return 0;
        }

        @Override
        public float getItemPositionX() {
            return 0;
        }
    }

}