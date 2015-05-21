/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Item implements IItem {

    private float itemPositionX;
    private float itemPositionY;
    protected final TextureAtlas textureAtlas = new TextureAtlas(Gdx.files.internal("allitems.atlas"));
    private final Sprite sprite;
    protected TextureAtlas.AtlasRegion region;
    public Item() {
        setRegion();
        sprite = new Sprite(region);
    }

    protected void setRegion(){
        this.region = textureAtlas.findRegion("");
    }

    @Override
    public boolean isConsumable() {
        return false;
    }

    @Override
    public boolean isWeapon() {
        return false;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void setItemPositionY(float y) {
        itemPositionY = y;
    }

    @Override
    public void setItemPositionX(float x) {
        itemPositionX = x;
    }

    @Override
    public float getItemPositionY() {
        return itemPositionY;
    }

    @Override
    public float getItemPositionX() {
        return itemPositionX;
    }
}