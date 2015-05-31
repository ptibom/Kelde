package se.computerscience.kelde.model.worldobjects;

import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;
import se.computerscience.kelde.model.encapsulation.libgdx.ISprite;
import se.computerscience.kelde.model.items.IItem;

import static org.junit.Assert.*;

/**
 * Created by Daniel on 5/31/2015.
 */
public class ItemEntityTest {

    IItem testItem;
    ItemEntity itemEntity;
    @Before
    public void setUp() throws Exception {

        testItem = new TestItem();
        itemEntity = new ItemEntity(1,1,new B2DWorld(),testItem);
    }

    @Test
    public void testPlayerPickUp() throws Exception {

        itemEntity.playerPickUp();
        assertEquals(testItem, itemEntity.getItem());
    }

    @Test
    public void testDispose() throws Exception {
        itemEntity.dispose();
        assertEquals(testItem, itemEntity.getItem());
    }

    @Test
    public void testGetItem() throws Exception {
        assertEquals(testItem, itemEntity.getItem());
    }

    @Test
    public void testGetPositionY() throws Exception {
        assertEquals(-15, (int)itemEntity.getPositionY());

    }

    @Test
    public void testGetPositionX() throws Exception {
        assertEquals(-15, (int)itemEntity.getPositionX());
    }

    @Test
    public void testIsVisible() throws Exception {
        assertEquals(true, itemEntity.isVisible());
    }

    @Test
    public void testSetVisible() throws Exception {
        itemEntity.setVisible(false);
        assertEquals(false, itemEntity.isVisible());

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