/**
 * @author: Daniel Olsson
 */

package se.computerscience.kelde.view.inventory;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import se.computerscience.kelde.model.inventory.Inventory;

import java.util.ArrayList;
import java.util.List;



public class InventoryView {

    final int INVENTORY_POSITIONX = 685, INVENTORY_POSITIONY = 600;
    final int ROW_LENGTH = 29, ROW_HEIGHT =35, AMOUNT_OF_ITEMS_PER_ROW = 3;
    Inventory inventoryModel;
    List<Texture> inventoryItemsSprites;
    Texture inventoryGuiTexture;

    public InventoryView(Inventory inventoryModel){

        this.inventoryModel = inventoryModel;
        inventoryItemsSprites = new ArrayList<Texture>();
        inventoryGuiTexture = new Texture(inventoryModel.getInventoryGuiImage());
        List<String> initialInventory = inventoryModel.getInventoryItems();

        for(int i = inventoryItemsSprites.size(); i<initialInventory.size(); i++){
            inventoryItemsSprites.add(new Texture(initialInventory.get(i)));
        }

    }


    public void draw(SpriteBatch batch){

        List<String> newInventoryList = inventoryModel.getInventoryItems();

        int newItemsAmount = inventoryItemsSprites.size()-newInventoryList.size();
        // Check if the new inventoryList is larger, then an item has been added
        if (newItemsAmount>0){

            // For each new item that has been added, we create a new button.
            for(int i = inventoryItemsSprites.size(); i<inventoryItemsSprites.size()+newItemsAmount; i++){
                inventoryItemsSprites.add(new Texture(newInventoryList.get(i)));
            }

        }

        batch.draw(inventoryGuiTexture,INVENTORY_POSITIONX,INVENTORY_POSITIONY);
        for(Texture texture: inventoryItemsSprites){

            for (int i = 0, x = 0, y = 0; i<inventoryItemsSprites.size(); i++, x +=ROW_LENGTH){

                if(x>ROW_LENGTH*AMOUNT_OF_ITEMS_PER_ROW){

                    y-=ROW_HEIGHT;
                    x=0;
                }


                batch.draw(texture, INVENTORY_POSITIONX+10+x,INVENTORY_POSITIONY+y-50+inventoryGuiTexture.getHeight());

            }

        }












    }








}
