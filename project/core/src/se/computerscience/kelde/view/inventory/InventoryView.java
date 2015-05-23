/**
 * @author: Daniel Olsson
 */

package se.computerscience.kelde.view.inventory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.inventory.Inventory;
import se.computerscience.kelde.model.items.Axe;
import se.computerscience.kelde.model.items.IItem;

import java.util.List;



public class InventoryView {

    final int INVENTORY_POSITIONX = 685, INVENTORY_POSITIONY = 300;
    final int ROW_LENGTH = 29, ROW_HEIGHT =35, AMOUNT_OF_ITEMS_PER_ROW = 3;
    Inventory inventoryModel;
    List<IItem> inventoryItems;
    Texture inventoryGuiTexture;

    public InventoryView(Inventory inventoryModel){

        // Inventory texture
        inventoryGuiTexture = new Texture(inventoryModel.getInventoryGuiImage());

        this.inventoryModel = inventoryModel;
        inventoryItems = inventoryModel.getInventoryItems();

        inventoryItems.add(new Axe());

    }


    public void draw(SpriteBatch batch){



        // Check if the new inventoryList is larger, then an item has been added



        batch.draw(inventoryGuiTexture, INVENTORY_POSITIONX, INVENTORY_POSITIONY);

        if(!inventoryItems.isEmpty()){
        for(IItem item: inventoryItems) {

            for (int i = 0, x = 0, y = 0; i < inventoryItems.size(); i++, x += ROW_LENGTH) {

                if (x > ROW_LENGTH * AMOUNT_OF_ITEMS_PER_ROW) {

                    y -= ROW_HEIGHT;
                    x = 0;
                }

                Sprite spriteToDraw = item.getItemSprite().getSprite();

                spriteToDraw.setPosition(INVENTORY_POSITIONX + 10 + x, INVENTORY_POSITIONY + y - 50 + inventoryGuiTexture.getHeight());
                spriteToDraw.draw(batch);

            }
        }

        }












    }








}
