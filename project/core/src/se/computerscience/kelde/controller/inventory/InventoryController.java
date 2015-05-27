package se.computerscience.kelde.controller.inventory;

import se.computerscience.kelde.model.inventory.Inventory;
import se.computerscience.kelde.model.items.IItem;
import se.computerscience.kelde.view.inventory.InventoryView;

/**
 * @author: Daniel Olsson
 */
public class InventoryController {


    private final Inventory inventoryModel;
    private final InventoryView inventoryView;

    public InventoryController(Inventory inventoryModel, InventoryView inventoryView){

        this.inventoryModel = new Inventory();
        this.inventoryView = new InventoryView(inventoryModel);
    }

    public void update(IItem newItem){
            inventoryModel.update(newItem);
    }


    public InventoryView getInventoryView(){

        return inventoryView;
    }







}
