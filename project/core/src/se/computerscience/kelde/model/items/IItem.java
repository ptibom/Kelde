/** Description: Interface to abstract various game-items that a player can use.
 *  @author: Philip Tibom
 */

package se.computerscience.kelde.model.items;

import com.badlogic.gdx.graphics.g2d.Sprite;

public interface IItem {
    public boolean isConsumable();
    public boolean isWeapon();
    public Sprite getSprite();
    public void setItemPostionY(float y);
    public void setItemPostionX(float x);
    public float getItemPostionY();
    public float getItemPostionX();
}
