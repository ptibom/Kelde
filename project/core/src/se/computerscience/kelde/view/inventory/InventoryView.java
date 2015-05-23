/**
 * @author: Daniel Olsson
 */

package se.computerscience.kelde.view.inventory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.inventory.Inventory;
import se.computerscience.kelde.model.items.IItem;

import java.util.List;


public class InventoryView {

    final int INVENTORY_POSITION_X = 685, INVENTORY_POSITION_Y = 300;

    Inventory inventoryModel;
    List<IItem> inventoryItems;
    List<int[]> itemPositions;
    Texture inventoryGuiTexture;

    public InventoryView(Inventory inventoryModel) {

        // Inventory GUI texture
        inventoryGuiTexture = new Texture(inventoryModel.getInventoryGuiImage());
        this.inventoryModel = inventoryModel;
        inventoryItems = inventoryModel.getInventoryItems();
        this.itemPositions = inventoryModel.getItemPositions();
    }

    // Draw the items in the inventory
    public void draw(SpriteBatch batch) {

        batch.draw(inventoryGuiTexture, INVENTORY_POSITION_X, INVENTORY_POSITION_Y);

        if (!inventoryItems.isEmpty()) {
            // We draw out all items
            for (int i = 0; i < inventoryItems.size(); i++) {

                inventoryItems.get(i).getItemSprite().getSprite().setPosition(itemPositions.get(i)[0], itemPositions.get(i)[1]);
                inventoryItems.get(i).getItemSprite().getSprite().draw(batch);

            }
        }
    }
}
