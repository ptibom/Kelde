package se.computerscience.kelde.model.inventory;

import se.computerscience.kelde.model.items.IItem;

import java.util.List;

/**
 * Created by Daniel on 5/27/2015.
 */
public interface IInventoryGui {

    List<IItem> getInventoryItems();

    String getInventoryGuiImage();

    List<int[]> getItemPositions();

    int getInventoryPositionX();

    int getInventoryPositionY();

}
