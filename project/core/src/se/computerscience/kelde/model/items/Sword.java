/** Description: A sword item. Used by player to damage enemies.
 *  @author: Philip Tibom
 *  @co-author Hossein Husain
 */

package se.computerscience.kelde.model.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;

public class Sword implements IItem {
    private boolean isConsumable = false;
    private boolean isWeapon = true;
    private final int damage = 10;
    private float itemPostionX;
    private float itemPostionY;
    private Sprite sprite = new Sprite(new Texture("sword_1.png"),32,32);
    public Sword() {
    }
    public int getDamage() {
        return damage;
    }
    @Override
    public boolean isConsumable() {
        return isConsumable;
    }
    @Override
    public boolean isWeapon() {
        return isWeapon;
    }
    @Override
    public Sprite getSprite() {
        return sprite;
    }
    @Override
    public void setItemPostionX(float itemPostionX) {
        this.itemPostionX = itemPostionX;
    }
    @Override
    public float getItemPostionY() {
        return itemPostionY;
    }
    @Override
    public float getItemPostionX() {
        return itemPostionX;
    }
    @Override
    public void setItemPostionY(float itemPostionY) {
        this.itemPostionY = itemPostionY;
    }
}