package se.computerscience.kelde.controller.inventory;

import se.computerscience.kelde.model.inventory.Inventory;
import se.computerscience.kelde.view.inventory.InventoryView;

/**
 * @author: Daniel Olsson
 */
public class InventoryController {


    Inventory inventoryModel;
    InventoryView inventoryView;

    public InventoryController(Inventory inventoryModel, InventoryView inventoryView){

        this.inventoryModel = new Inventory();
        this.inventoryView = new InventoryView(inventoryModel);


    }

    public void update(String newItem){

        if(newItem.length()>0) {
            inventoryModel.update(newItem);
        }
    }







}
