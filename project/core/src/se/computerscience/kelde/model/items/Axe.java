package se.computerscience.kelde.model.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
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
    private TextureAtlas textureAtlas;
    private final Sprite sprite;
    public Axe() {
        textureAtlas = new TextureAtlas(Gdx.files.internal("allitems.atlas"));
        AtlasRegion region = textureAtlas.findRegion("0002");
        sprite = new Sprite(region);
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
    public float getItemPostionX() {
        return itemPostionX;
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
    public void setItemPostionY(float itemPostionY) {
        this.itemPostionY = itemPostionY;
    }
}