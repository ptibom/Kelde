/** Description: A sword item. Used by player to damage enemies.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.items;

public class ItemSword implements IItems {
    public boolean isConsumable = false;
    public boolean isWeapon = true;

    @Override
    public boolean isConsumable() {
        return isConsumable;
    }

    @Override
    public boolean isWeapon() {
        return isWeapon;
    }
}
