package se.computerscience.kelde.model.inventory;



import java.util.ArrayList;
import java.util.List;



/**
 * @author: Daniel Olsson
 */

// The inventory can take items and display them inside the inventory tab.
public class Inventory {

    private final String INVENTORY_GUI_IMAGE = "inventory/inventorygui.png";
    List<String> inventoryObjectsPathsImage;

    public Inventory(){

        inventoryObjectsPathsImage = new ArrayList<String>();

        
    }

    public void update(String newItem){

        inventoryObjectsPathsImage.add(newItem);
    }

    public  List<String> getInventoryItems(){

        return inventoryObjectsPathsImage;
    }

    public String getInventoryGuiImage(){
        return INVENTORY_GUI_IMAGE;
    }




}
