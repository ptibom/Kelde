package se.computerscience.kelde.model.inventory;

import se.computerscience.kelde.model.items.IItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Daniel Olsson
 */

// The inventory can take items and display them inside the inventory tab.
public class Inventory {

    final int INVENTORY_POSITIONX = 685, INVENTORY_POSITIONY = 300;
    final int INVENTORY_GUI_IMAGE_HEIGHT =250;
    final int ITEM_OFFSET_X = 10, ITEM_OFFSET_Y = -50;
    final int ROW_LENGTH = 29, ROW_HEIGHT =35, AMOUNT_OF_ITEMS_PER_ROW = 4;
    private final String INVENTORY_GUI_IMAGE = "inventory/inventorygui.png";
    List<IItem> inventoryObjectsPathsImage;
    List<int[]> itemPosition;


    public Inventory(){

        inventoryObjectsPathsImage = new ArrayList<>();
        itemPosition = new ArrayList<>();
        
    }

    public void update(IItem newItem){

        // We want to calculate the position of the new item
        int rest = inventoryObjectsPathsImage.size()%AMOUNT_OF_ITEMS_PER_ROW;
        int x = rest*ROW_LENGTH;
        int y;

        y = inventoryObjectsPathsImage.size()/AMOUNT_OF_ITEMS_PER_ROW;
        y*=-ROW_HEIGHT;
        x += INVENTORY_POSITIONX + ITEM_OFFSET_X;
        y += INVENTORY_POSITIONY + ITEM_OFFSET_Y + INVENTORY_GUI_IMAGE_HEIGHT;

        // There cant be more than 16 items in the inventory
        if(inventoryObjectsPathsImage.size()<17) {
            inventoryObjectsPathsImage.add(newItem);
            itemPosition.add(new int[]{x,y});
        }
    }

    public  List<IItem> getInventoryItems(){

        return inventoryObjectsPathsImage;
    }

    public String getInventoryGuiImage(){
        return INVENTORY_GUI_IMAGE;
    }

    public List<int[]> getItemPositions(){

        return itemPosition;
    }

}
