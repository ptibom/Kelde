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
    protected final IAtlas textureAtlas = new Atlas("allitems.atlas");
    private final ISprite spriteEncaps;
    protected IRegion region = new Region(textureAtlas);
    public Item() {
        setRegion();
        spriteEncaps = new SpriteEncaps(region);
    }

    protected void setRegion(){
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
    public ISprite getSpriteEncaps(){
        return spriteEncaps;
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