package se.computerscience.kelde.model.inventory;

import se.computerscience.kelde.model.items.IItem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

// The inventory can take items and display them inside the inventory tab.
public class Inventory implements IInventoryGui {

    private static final int INVENTORY_POSITIONX = 690, INVENTORY_POSITIONY = 170;
    private static final int INVENTORY_GUI_IMAGE_HEIGHT = 250;
    private static final int ITEM_OFFSET_X = 10, ITEM_OFFSET_Y = -50;
    private static final int ROW_LENGTH = 29, ROW_HEIGHT = 35, AMOUNT_OF_ITEMS_PER_ROW = 4;
    private static final String INVENTORY_GUI_IMAGE = "inventory/inventorygui.png";
    private final List<IItem> inventoryItems;
    private final List<int[]> itemPosition;


    public Inventory() {

        inventoryItems = new ArrayList<>();
        itemPosition = new ArrayList<>();

    }

    public void update(IItem newItem) {

        // We want to calculate the position of the new item
        final int rest = inventoryItems.size() % AMOUNT_OF_ITEMS_PER_ROW;
        int x = rest * ROW_LENGTH;
        int y;

        y = inventoryItems.size() / AMOUNT_OF_ITEMS_PER_ROW;
        y *= -ROW_HEIGHT;
        x += INVENTORY_POSITIONX + ITEM_OFFSET_X;
        y += INVENTORY_POSITIONY + ITEM_OFFSET_Y + INVENTORY_GUI_IMAGE_HEIGHT;

        // There cant be more than 16 items in the inventory
        if (inventoryItems.size() < 17) {
            inventoryItems.add(newItem);
            itemPosition.add(new int[]{x, y});
        }
    }

    public List<IItem> getInventoryItems() {

        return inventoryItems;
    }

    public String getInventoryGuiImage() {
        return INVENTORY_GUI_IMAGE;
    }

    public List<int[]> getItemPositions() {

        return itemPosition;
    }

    public int getInventoryPositionX() {
        return INVENTORY_POSITIONX;
    }

    public int getInventoryPositionY() {

        return INVENTORY_POSITIONY;
    }

}
