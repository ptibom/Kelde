/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.controller.items;

import se.computerscience.kelde.controller.worldobjects.IWorldObjectsController;
import se.computerscience.kelde.model.items.ItemEntity;
import se.computerscience.kelde.view.items.ItemEntityView;

public class ItemEntityController implements IWorldObjectsController{
    private ItemEntity itemEntity;
    private ItemEntityView itemEntityView;

    public ItemEntityController(ItemEntity itemEntity, ItemEntityView itemEntityView) {
        this.itemEntity = itemEntity;
        this.itemEntityView = itemEntityView;
    }


    @Override
    public void update(float delta) {

    }
}