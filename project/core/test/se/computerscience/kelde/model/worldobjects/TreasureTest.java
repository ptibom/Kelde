package se.computerscience.kelde.model.worldobjects;


import org.junit.Before;
import org.junit.Test;
import se.computerscience.kelde.model.encapsulation.box2d.B2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodyStatic;
import se.computerscience.kelde.model.items.IItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: Daniel Olsson
 */
public class TreasureTest {



    TreasureTesting treasure;

    @Before
    public void setUp() throws Exception {

        treasure  = new TreasureTesting(new B2DWorld(),1,1,"test");
    }

    @Test
    public void testSetIsOpen() throws Exception {
        treasure.setIsOpen(true);
        assertEquals(true, treasure.isCheastOpen());
    }

    @Test
    public void testIsCheastOpen() throws Exception {
        assertEquals(false, treasure.isCheastOpen());
    }

    @Test
    public void testGetPositionY() throws Exception {

        assertEquals(-15, (int)treasure.getPositionY());
    }

    @Test
    public void testGetPositionX() throws Exception {
        assertEquals(-15, (int)treasure.getPositionX());
    }

    @Test
    public void testGetItemslist() throws Exception {
        assertEquals(0, treasure.getItemslist().size());
    }



    class TreasureTesting{

        private static final float BODY_WIDTH = 16;
        private static final float BODY_HEIGHT = 16;
        private boolean isOpen;
        private final List<IItem> itemslist = new ArrayList<>();
        private final IPhysicalBody entityBody;

        public TreasureTesting(IB2DWorld ib2DWorld, float positionX, float positionY, String itemSset) {

            entityBody = new PhysicalBodyStatic(positionX, positionY, BODY_WIDTH, BODY_HEIGHT, ib2DWorld, this);

        }

        public void setIsOpen(boolean isOpen) {
            this.isOpen = isOpen;
            itemslist.clear();
        }

        public boolean isCheastOpen() {
            return isOpen;
        }


        public float getPositionY() {
            return entityBody.getPositionY() - BODY_HEIGHT;
        }


        public float getPositionX() {
            return entityBody.getPositionX() - BODY_WIDTH;
        }

        public List<IItem> getItemslist() {
            return itemslist;
        }




    }






}