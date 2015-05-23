
/**
 * @author: Daniel Olsson
 */

package se.computerscience.kelde.view.inventory;


import com.badlogic.gdx.Gdx;

import java.util.List;

public class InventoryInputCheck {


    private final static int ORIGINAL_SCREEN_HEIGHT =Gdx.graphics.getHeight();
    private static int inventoryStartX, inventoryStartY;

    public InventoryInputCheck(int inventoryStartX, int inventoryStartY){

        this.inventoryStartX = inventoryStartX;
        this.inventoryStartY = inventoryStartY;

    }





    public static boolean checkToRemove(int x, int y, int width, int height){

        int mousePositionX = Gdx.input.getX();
        int mousePositionY = Gdx.input.getY();
        int deltaY = Gdx.graphics.getHeight() - ORIGINAL_SCREEN_HEIGHT;

        if((mousePositionX>inventoryStartX + x && mousePositionX < inventoryStartX + x + width)&&(mousePositionY>inventoryStartY + y &&
        mousePositionY < inventoryStartY + y + height)){
            return true;
        }


        return false;


    }

}


