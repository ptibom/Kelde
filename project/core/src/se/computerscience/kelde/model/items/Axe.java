package se.computerscience.kelde.model.items;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import se.computerscience.kelde.model.encapsulation.box2d.IB2DWorld;
import se.computerscience.kelde.model.encapsulation.box2d.IPhysicalBody;
import se.computerscience.kelde.model.encapsulation.box2d.PhysicalBodySensor;

/**
 * Description: An axe-item, makes damage.
 *
 * @author: Hossein Hussain
 */
public class Axe implements IItem {
    private final boolean isConsumable = false;
    private final boolean isWeapon = true;
    private final int damage = 10;
    private float itemPostionX;
    private float itemPostionY;
    private final Sprite sprite = new Sprite(new Texture("axe_1.png"),32,32);
    public Axe() {
    }

    public boolean isConsumable() {
        return isConsumable;
    }

    public boolean isWeapon() {
        return isWeapon;
    }

    public int getDamage() {
        return damage;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public float getItemPostionX() {
        return itemPostionX;
    }
    @Override
    public void setItemPostionX(float itemPostionX) {
        this.itemPostionX = itemPostionX;
    }
    public float getItemPostionY() {
        return itemPostionY;
    }
    @Override
    public void setItemPostionY(float itemPostionY) {
        this.itemPostionY = itemPostionY;
    }
}