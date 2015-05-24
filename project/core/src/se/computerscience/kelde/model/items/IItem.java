/** Description: Interface to abstract various game-items that a player can use.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.libgdx.ISprite;

public interface IItem {
    boolean isConsumable();
    boolean isWeapon();
    ISprite getItemSprite();
    void setItemPositionY(float y);
    void setItemPositionX(float x);
    float getItemPositionY();
    float getItemPositionX();
}
