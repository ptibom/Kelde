/**
 * @author: Daniel Olsson
 */

package se.computerscience.kelde.view.inventory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.inventory.IInventoryGui;
import se.computerscience.kelde.model.items.IItem;

import java.util.List;


public class InventoryView {

    private final IInventoryGui inventoryModel;
    private final List<IItem> inventoryItems;
    private final List<int[]> itemPositions;
    private final Texture inventoryGuiTexture;

    public InventoryView(IInventoryGui inventoryModel) {

        // Inventory GUI texture
        inventoryGuiTexture = new Texture(inventoryModel.getInventoryGuiImage());
        this.inventoryModel = inventoryModel;
        inventoryItems = inventoryModel.getInventoryItems();
        this.itemPositions = inventoryModel.getItemPositions();
    }

    // Draw the items in the inventory
    public void draw(SpriteBatch batch) {

        batch.draw(inventoryGuiTexture, inventoryModel.getInventoryPositionX(), inventoryModel.getInventoryPositionY());

        if (!inventoryItems.isEmpty()) {
            // We draw out all items
            for (int i = 0; i < inventoryItems.size(); i++) {

                inventoryItems.get(i).getItemSprite().getSprite().setPosition(itemPositions.get(i)[0], itemPositions.get(i)[1]);
                inventoryItems.get(i).getItemSprite().getSprite().draw(batch);

            }
        }
    }
}
