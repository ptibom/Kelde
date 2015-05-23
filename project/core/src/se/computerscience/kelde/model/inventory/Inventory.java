package se.computerscience.kelde.model.inventory;



import se.computerscience.kelde.model.items.IItems;

import java.util.ArrayList;
import java.util.List;



/**
 * @author: Daniel Olsson
 */

// The inventory can take items and display them inside the inventory tab.
public class Inventory {

    private final String INVENTORY_GUI_IMAGE = "inventory/inventorygui.png";
    List<IItems> inventoryObjectsPathsImage;

    public Inventory(){

        inventoryObjectsPathsImage = new ArrayList<IItems>();

        
    }

    public void update(IItems newItem){

        inventoryObjectsPathsImage.add(newItem);
    }

    public  List<IItems> getInventoryItems(){

        return inventoryObjectsPathsImage;
    }

    public String getInventoryGuiImage(){
        return INVENTORY_GUI_IMAGE;
    }




}
