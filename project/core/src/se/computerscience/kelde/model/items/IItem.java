/** Description: Interface to abstract various game-items that a player can use.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.libgdx.SpriteEncaps;

public interface IItem {
    public boolean isConsumable();
    public boolean isWeapon();
    public SpriteEncaps getSpriteEncaps();
    public void setItemPositionY(float y);
    public void setItemPositionX(float x);
    public float getItemPositionY();
    public float getItemPositionX();
}
