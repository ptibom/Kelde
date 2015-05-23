package se.computerscience.kelde.model.inventory;



import se.computerscience.kelde.model.items.IItem;
import java.util.ArrayList;
import java.util.List;



/**
 * @author: Daniel Olsson
 */

// The inventory can take items and display them inside the inventory tab.
public class Inventory {

    private final String INVENTORY_GUI_IMAGE = "inventory/inventorygui.png";
    List<IItem> inventoryObjectsPathsImage;

    public Inventory(){

        inventoryObjectsPathsImage = new ArrayList<IItem>();

        
    }

    public void update(IItem newItem){

        inventoryObjectsPathsImage.add(newItem);
    }

    public  List<IItem> getInventoryItems(){

        return inventoryObjectsPathsImage;
    }

    public String getInventoryGuiImage(){
        return INVENTORY_GUI_IMAGE;
    }




}
