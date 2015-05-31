/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.libgdx.*;

public class Item implements IItem {

    private float itemPositionX;
    private float itemPositionY;
    protected IAtlas textureAtlas;
    private final ISprite sprite;
    protected IRegion region;

    public Item() {
        setTextureAtlas();
        region = new Region(textureAtlas);
        setRegion();
        sprite = new ItemSprite(region);
    }

    protected void setTextureAtlas() {
        textureAtlas = new Atlas("allitems.atlas");
    }

    protected void setRegion() {
        region.setRegion(textureAtlas.findRegion(""));
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
    public ISprite getItemSprite() {
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