/** Description: A sword item. Used by player to damage enemies.
 *  @author: Philip Tibom
 *  @co-author Hossein Husain
 */

package se.computerscience.kelde.model.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Sword implements IItem {
    private boolean isConsumable = false;
    private boolean isWeapon = true;
    private final int damage = 10;
    private float itemPostionX;
    private float itemPostionY;
    private TextureAtlas textureAtlas;
    private final Sprite sprite;
    public Sword() {
        textureAtlas = new TextureAtlas(Gdx.files.internal("allitems.atlas"));
        TextureAtlas.AtlasRegion region = textureAtlas.findRegion("0001");
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