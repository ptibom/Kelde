/**
 * Description:
 *
 * @author: Hossein Hussain
 */
package se.computerscience.kelde.model.items;

import se.computerscience.kelde.model.encapsulation.libgdx.Atlas;
import se.computerscience.kelde.model.encapsulation.libgdx.Region;
import se.computerscience.kelde.model.encapsulation.libgdx.SpriteEncaps;

public class Item implements IItem {

    private float itemPositionX;
    private float itemPositionY;
    Atlas textureAtlas = new Atlas("allitems.atlas");
    private final SpriteEncaps spriteEncaps;
    protected Region region = new Region(textureAtlas);
    public Item() {
        setRegion();
        spriteEncaps = new SpriteEncaps(region);
    }

   protected void setRegion(){
        region.setRegion(textureAtlas.findRegion(""));
    }
    protected void getRegion(){
        region.setRegion(textureAtlas.findRegion("0001"));
    }

    @Override
    public boolean isConsumable() {
        return false;
    }

    @Override
    public boolean isWeapon() {
        return false;
    }
    public SpriteEncaps getSpriteEncaps(){
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