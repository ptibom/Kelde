/** Description: Inventory can hold items.
 *  @author: Philip Tibom
 *  @co-author: Hossein Hussain
 */

package se.computerscience.kelde.model.items;

import se.computerscience.kelde.controller.items.IitemController;

import java.util.LinkedList;
import java.util.List;

public class PlayerInventory {
    private List<IitemController> keldeinventory = new LinkedList<>();
    public void addToIventory(IitemController items){
        keldeinventory.add(items);
    }
    public void printInventory(){
        for (IitemController iItems : keldeinventory) {
            //printing to consol for test
            System.out.println(iItems.itemName());
        }
    }
}
